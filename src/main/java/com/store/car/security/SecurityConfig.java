package com.store.car.security;

import org.pac4j.core.config.Config;
import org.pac4j.springframework.web.SecurityInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("org.pac4j.springframework.web")
class SecurityConfig extends WebMvcConfigurerAdapter {
    private final Config config;

    SecurityConfig(Config config) {
        this.config = config;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CORSInterceptor());
        registry.addInterceptor(new SecurityInterceptor(config, "DirectBasicAuthClient")).addPathPatterns("/api/login");
        registry.addInterceptor(new SecurityInterceptor(config, "HeaderClient", "user")).addPathPatterns("/api/user/**");
        registry.addInterceptor(new SecurityInterceptor(config, "HeaderClient", "admin")).addPathPatterns("/api/admin/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("x-code", "Authorization", "Content-Type", "Origin", "X-Requested-With", "Accept")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE", "HEAD")
                .allowedOrigins("*");
    }
}