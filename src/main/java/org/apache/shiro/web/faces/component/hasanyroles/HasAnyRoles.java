package org.apache.shiro.web.faces.component.hasanyroles;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.faces.component.hasrole.HasRole;


/**
 * Displays body content if the current user has any of the roles specified.
 *
 * @author Deluan Quintao
 * @author Jeremy Haile
 */
public class HasAnyRoles extends HasRole {

    //TODO - complete JavaDoc

    // Delimeter that separates role names in tag attribute
    private static final String ROLE_NAMES_DELIMETER = ",";

    public HasAnyRoles() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.hasanyroles.HasAnyRolesRenderer");
    }

    @Override
    protected boolean showTagBody(String roleNames) {
        boolean hasAnyRole = false;

        Subject subject = getSubject();

        if (subject != null) {
            // Iterate through roles and check to see if the user has one of the roles
            for (String role : roleNames.split(ROLE_NAMES_DELIMETER)) {
                if (subject.hasRole(role.trim())) {
                    hasAnyRole = true;
                    break;
                }
            }
        }

        return hasAnyRole;
    }

}
