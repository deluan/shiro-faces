package org.apache.shiro.web.faces.component.authenticated;

import org.apache.shiro.web.faces.facelets.ShiroSecureComponent;

public class Authenticated extends ShiroSecureComponent {

    public Authenticated() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.authenticated.AuthenticatedRenderer");
    }

    protected boolean checkAuthentication() {
        return (getSubject() != null && getSubject().isAuthenticated());
    }
}
