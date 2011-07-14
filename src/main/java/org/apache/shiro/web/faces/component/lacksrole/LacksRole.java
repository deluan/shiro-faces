package org.apache.shiro.web.faces.component.lacksrole;

import org.apache.shiro.web.faces.component.hasrole.HasRole;

public class LacksRole extends HasRole {

    // TODO - complete JavaDoc

    public LacksRole() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.lacksrole.LacksRoleRenderer");
    }

    @Override
    protected boolean showTagBody(String roleName) {
        boolean hasRole = getSubject() != null && getSubject().hasRole(roleName);
        return !hasRole;
    }

}