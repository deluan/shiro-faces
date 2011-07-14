package org.apache.shiro.web.faces.tags;

import javax.faces.view.facelets.TagConfig;

/**
 * Tag that renders the tag body if the current user <em>is not</em> known to the system, either because they
 * haven't logged in yet, or because they have no 'RememberMe' identity.
 *
 * <p>The logically opposite tag of this one is the {@link UserTag}.  Please read that class's JavaDoc as it explains
 * more about the differences between Authenticated/Unauthenticated and User/Guest semantic differences.
 *
 * @author Deluan Quintao
 * @author Les Hazlewood
 */
public class GuestTag extends AuthenticationTagHandler {

    public GuestTag(TagConfig config) {
        super(config);
    }

    protected boolean checkAuthentication() {
        return (getSubject() == null || getSubject().getPrincipal() == null);
    }
}
