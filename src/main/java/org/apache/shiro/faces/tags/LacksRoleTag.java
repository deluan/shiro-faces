package org.apache.shiro.faces.tags;

import com.sun.facelets.tag.TagConfig;

public class LacksRoleTag extends PermissionTag {

    public LacksRoleTag(TagConfig config) {
        super(config);
    }

    @Override
    protected boolean showTagBody(String roleName) {
        return getSubject() != null && getSubject().hasRole(roleName);
    }

}