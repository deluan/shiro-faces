package org.apache.shiro.web.faces.tags;

import com.sun.facelets.tag.TagConfig;

/**
 * @author Deluan
 */
public class HasPermissionTag extends PermissionTag {

    public HasPermissionTag(TagConfig config) {
        super(config);
    }

    protected boolean showTagBody(String p) {
        return isPermitted(p);
    }
}
