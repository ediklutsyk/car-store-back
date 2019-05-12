package com.store.car.security;

import com.store.car.service.user.UserService;
import org.pac4j.core.authorization.authorizer.RequireAnyRoleAuthorizer;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.http.client.direct.DirectBasicAuthClient;
import org.pac4j.http.client.direct.HeaderClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Pac4jConfig {
    private final UserService userService;

    public Pac4jConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public Config config() {
        DirectBasicAuthClient directBasicAuthClient = new DirectBasicAuthClient(new BasicUsernamePassAuth(userService));
        HeaderClient headerClient = new HeaderClient("x-code", new TokenAuthenticator(userService));

        Clients clients = new Clients(directBasicAuthClient, headerClient);
        Config config = new Config(clients);
        config.addAuthorizer("user", new RequireAnyRoleAuthorizer("ROLE_USER"));
        config.addAuthorizer("admin", new RequireAnyRoleAuthorizer("ROLE_ADMIN"));
        return config;
    }
}