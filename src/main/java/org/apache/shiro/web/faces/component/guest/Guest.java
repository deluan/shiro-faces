package org.apache.shiro.web.faces.component.guest;

import org.apache.shiro.web.faces.component.authenticated.Authenticated;


public class Guest extends Authenticated {

    public Guest() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.guest.GuestRenderer");
    }

    @Override
    protected boolean checkAuthentication() {
        return (getSubject() == null || getSubject().getPrincipal() == null);
    }

}
