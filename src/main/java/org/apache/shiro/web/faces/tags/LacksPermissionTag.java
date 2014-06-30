package org.apache.shiro.web.faces.tags;

import javax.faces.view.facelets.TagConfig;

/**
 * @author Deluan Quintao
 */
public class LacksPermissionTag extends PermissionTagHandler {

    // TODO - complete JavaDoc

    public LacksPermissionTag(TagConfig config) {
        super(config);
    }

    protected boolean showTagBody(String p) {
        return !isPermitted(p);
    }

}
