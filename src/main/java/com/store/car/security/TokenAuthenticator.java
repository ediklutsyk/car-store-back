package com.store.car.security;

import com.store.car.db.persistence.User;
import com.store.car.exceptions.UnauthorizedException;
import com.store.car.service.user.UserService;
import org.pac4j.core.context.Pac4jConstants;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.util.CommonHelper;

public class TokenAuthenticator implements Authenticator<TokenCredentials> {
    private final UserService userService;

    public TokenAuthenticator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void validate(TokenCredentials credentials, WebContext context) {
        if (credentials == null) throw new UnauthorizedException("Credentials must not be null");
        if (CommonHelper.isBlank(credentials.getToken())) throw new UnauthorizedException("Token must not be blank");
        User user = userService.findByToken(credentials.getToken())
                .orElseThrow(() -> new UnauthorizedException("Token is invalid"));
        CommonProfile profile = new CommonProfile();
        profile.setId(user.getEmail());
        profile.addAttribute(Pac4jConstants.USERNAME, user.getEmail());
        if (user.getRole().equals("ROLE_ADMIN")) {
            profile.addRole("ROLE_ADMIN");
            profile.addRole("ROLE_USER");
        }
        if (user.getRole().equals("ROLE_USER")) profile.addRole("ROLE_USER");
        profile.addAttribute("user", user);
        credentials.setUserProfile(profile);
    }
}
