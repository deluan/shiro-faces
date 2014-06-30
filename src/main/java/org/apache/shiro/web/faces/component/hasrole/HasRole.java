package org.apache.shiro.web.faces.component.hasrole;

import javax.el.ValueExpression;
import org.apache.shiro.web.faces.facelets.ShiroSecureComponent;

/**
 * @author Deluan Quintao
 */
public class HasRole extends ShiroSecureComponent {

    // TODO - complete JavaDoc
    private String name;

    public HasRole() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.hasrole.HasRoleRenderer");
    }

    protected boolean showTagBody(String roleName) {
        return getSubject() != null && getSubject().hasRole(roleName);
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
}