package org.apache.shiro.web.faces.component.lackspermission;

import org.apache.shiro.web.faces.component.haspermission.HasPermission;

/**
 * @author Deluan Quintao
 */
public class LacksPermission extends HasPermission {

    // TODO - complete JavaDoc

    public LacksPermission() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.lackspermission.LacksPermissionRenderer");
    }

    @Override
    protected boolean showTagBody(String p) {
        return !isPermitted(p);
    }

}
