package org.apache.shiro.web.faces.tags;

import com.sun.facelets.tag.TagConfig;

/**
 * @author Deluan Quintao
 */
public class LacksPermissionTag extends PermissionTag {

    // TODO - complete JavaDoc

    public LacksPermissionTag(TagConfig config) {
        super(config);
    }

    protected boolean showTagBody(String p) {
        return !isPermitted(p);
    }

}
