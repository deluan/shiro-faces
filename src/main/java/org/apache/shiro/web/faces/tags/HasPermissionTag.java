package org.apache.shiro.web.faces.tags;

import com.sun.facelets.tag.TagConfig;

/**
 * Tag that renders the tag body only if the current user has the string permissions
 * specified in <tt>name</tt> attribute.
 *
 * @author Deluan Quintao
 */
public class HasPermissionTag extends PermissionTag {

    public HasPermissionTag(TagConfig config) {
        super(config);
    }

    protected boolean showTagBody(String p) {
        return isPermitted(p);
    }
}
