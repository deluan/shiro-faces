package org.apache.shiro.web.faces.component.user;

import org.apache.shiro.web.faces.component.guest.Guest;

public class User extends Guest {

    public User() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.user.UserRenderer");
    }

    @Override
    protected boolean checkAuthentication() {
        return !super.checkAuthentication();
    }
}
