package org.apache.shiro.faces.tags;

import com.sun.facelets.tag.TagConfig;

/**
 * @author Deluan
 */
public class LacksPermissionTag extends PermissionTag {

    public LacksPermissionTag(TagConfig config) {
        super(config);
    }

    protected boolean showTagBody(String p) {
        return !isPermitted(p);
    }

}
