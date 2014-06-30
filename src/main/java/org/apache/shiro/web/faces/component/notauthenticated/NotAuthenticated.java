package org.apache.shiro.web.faces.component.notauthenticated;

import org.apache.shiro.web.faces.component.authenticated.Authenticated;

public class NotAuthenticated extends Authenticated {

    public NotAuthenticated() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.notauthenticated.NotAuthenticatedRenderer");
    }

    @Override
    protected boolean checkAuthentication() {
        return !super.checkAuthentication();
    }
}
