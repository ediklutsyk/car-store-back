package com.store.car.security;

import com.store.car.db.persistence.User;
import com.store.car.exceptions.BadRequestException;
import com.store.car.exceptions.NotFoundException;
import com.store.car.service.user.UserService;
import org.pac4j.core.context.Pac4jConstants;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.UsernamePasswordCredentials;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.exception.CredentialsException;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.util.CommonHelper;

public class BasicUsernamePassAuth implements Authenticator<UsernamePasswordCredentials> {
    private final UserService userService;

    public BasicUsernamePassAuth(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void validate(UsernamePasswordCredentials credentials, WebContext context) {
        if (credentials == null) {
            throw new BadRequestException("No credential");
        }
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        if (CommonHelper.isBlank(username)) {
            throw new BadRequestException("Username cannot be blank");
        }
        if (CommonHelper.isBlank(password)) {
            throw new BadRequestException("Password cannot be blank");
        }
        User user = userService.findByEmail(username)
                .orElseThrow(() -> new NotFoundException("There isn't user with such username"));
        if (user.getEmail().equals(username) && user.getPassword().equals(password)) {
            CommonProfile profile = new CommonProfile();
            profile.setId(username);
            profile.addAttribute(Pac4jConstants.USERNAME, username);
            if (user.getRole().equals("ROLE_ADMIN")) {
                profile.addRole("ROLE_ADMIN");
                profile.addRole("ROLE_USER");
            }
            if (user.getRole().equals("ROLE_USER")) profile.addRole("ROLE_USER");
            profile.addAttribute("user", user);
            credentials.setUserProfile(profile);
        } else {
            throw new CredentialsException("Username : '" + username + "' does not match password");
        }
    }

}