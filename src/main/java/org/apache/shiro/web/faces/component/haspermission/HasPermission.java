package org.apache.shiro.web.faces.component.haspermission;

import javax.el.ValueExpression;
import org.apache.shiro.web.faces.facelets.ShiroSecureComponent;

/**
 * Tag that renders the tag body only if the current user has the string permissions
 * specified in <tt>name</tt> attribute.
 *
 * @author Deluan Quintao
 */
public class HasPermission extends ShiroSecureComponent {

    private String name;

    public HasPermission() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.haspermission.HasPermissionRenderer");
    }

    protected boolean showTagBody(String p) {
        return isPermitted(p);
    }

    public String getName() {
        if (null != this.name) {
            return name;
        }
        ValueExpression ve = getValueExpression("name");
        if (ve != null) {
            return (java.lang.String) ve.getValue(getFacesContext().getELContext());
        } else {
            return null;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    protected boolean isPermitted(String p) {
        return getSubject() != null && getSubject().isPermitted(p);
    }
}
