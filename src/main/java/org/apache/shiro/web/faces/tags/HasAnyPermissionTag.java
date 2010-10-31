package org.apache.shiro.web.faces.tags;

import com.sun.facelets.tag.TagConfig;
import org.apache.shiro.subject.Subject;

/**
 * @author Deluan
 */
public class HasAnyPermissionTag extends PermissionTag {

    private static final String PERMISSIONS_DELIMETER = ",";


    public HasAnyPermissionTag(TagConfig config) {
        super(config);
    }

    protected boolean showTagBody(String permissions) {
        boolean hasAnyPermission = false;

        Subject subject = getSubject();

        if (subject != null) {
            // Iterate through permissions and check to see if the user has one of the permission
            for (String permission : permissions.split(PERMISSIONS_DELIMETER)) {
                if (subject.isPermitted(permission.trim())) {
                    hasAnyPermission = true;
                    break;
                }
            }
        }

        return hasAnyPermission;
    }
}
