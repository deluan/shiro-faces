package org.apache.shiro.web.faces.tags;

import javax.faces.view.facelets.TagConfig;

/**
 * Tag that renders the tag body only if the current user has executed a <b>successful</b> authentication attempt
 * <em>during their current session</em>.
 *
 * <p>This is more restrictive than the {@link UserTag}, which only
 * ensures the current user is known to the system, either via a current login or from Remember Me services,
 * which only makes the assumption that the current user is who they say they are, and does not guarantee it like
 * this tag does.
 *
 * <p>The logically opposite tag of this one is the {@link NotAuthenticatedTag}
 *
 * @author Deluan Quintao
 * @author Jeremy Haile
 * @author Les Hazlewood
 */
public class AuthenticatedTag extends AuthenticationTagHandler {

    public AuthenticatedTag(TagConfig config) {
        super(config);
    }

    protected boolean checkAuthentication() {
        return (getSubject() != null && getSubject().isAuthenticated());
    }
}
