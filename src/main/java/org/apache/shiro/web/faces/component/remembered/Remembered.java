package org.apache.shiro.web.faces.component.remembered;

import org.apache.shiro.web.faces.component.authenticated.Authenticated;

public class Remembered extends Authenticated {

    public Remembered() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.remembered.RememberedRenderer");
    }

    @Override
    protected boolean checkAuthentication() {
        return (getSubject() != null && getSubject().isRemembered());
    }
}
