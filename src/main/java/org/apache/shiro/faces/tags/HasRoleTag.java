package org.apache.shiro.faces.tags;

import com.sun.facelets.tag.TagConfig;

public class HasRoleTag extends PermissionTag {

    public HasRoleTag(TagConfig config) {
        super(config);
    }

    @Override
    protected boolean showTagBody(String roleName) {
        return getSubject() != null && getSubject().hasRole(roleName);
    }

}