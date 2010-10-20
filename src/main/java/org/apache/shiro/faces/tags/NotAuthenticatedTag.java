package org.apache.shiro.faces.tags;

import com.sun.facelets.tag.TagConfig;

/**
 * Tag that renders the tag body only if the current user has <em>not</em> executed a successful authentication
 * attempt <em>during their current session</em>.
 *
 * <p>The logically opposite tag of this one is the {@link AuthenticatedTag}.
 *
 * @author Deluan
 * @author Jeremy Haile
 */
public class NotAuthenticatedTag extends AuthenticatedTag {

    public NotAuthenticatedTag(TagConfig config) {
        super(config);
    }

    @Override
    protected boolean checkAuthentication() {
        return !super.checkAuthentication();
    }
}
