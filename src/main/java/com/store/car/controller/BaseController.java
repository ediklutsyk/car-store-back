package com.store.car.controller;

import com.store.car.db.persistence.User;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

class BaseController {

    protected User getProfile(HttpServletRequest request, HttpServletResponse response) {
        J2EContext context = new J2EContext(request, response);
        ProfileManager manager = new ProfileManager(context);
        Optional<CommonProfile> profile = manager.get(true);
        return profile.get().getAttribute("user", User.class);
    }
}
