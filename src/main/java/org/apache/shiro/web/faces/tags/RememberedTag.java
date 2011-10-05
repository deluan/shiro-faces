package org.apache.shiro.web.faces.tags;

import javax.faces.view.facelets.TagConfig;

/**
 * Tag that renders the tag body only if the current user's identity (aka principals) is remembered from a
 * successful authentication during a previous session and the user has <b>not</b> executed a successful authentication
 * attempt during their current session.
 *
 * <p><b>Note:</b> This is <em>less</em> restrictive than the <code>AuthenticatedTag</code> since it only assumes
 * the user is who they say they are <em>via Remember Me services</em>, which
 * makes no guarantee the user is who they say they are.  The <code>AuthenticatedTag</code> however
 * guarantees that the current user has logged in <em>during their current session</em>, proving they really are
 * who they say they are.
 *
 * @author Deluan Quintao
 */
public class RememberedTag extends AuthenticationTagHandler {

    public RememberedTag(TagConfig config) {
        super(config);
    }

    protected boolean checkAuthentication() {
        return (getSubject() != null && getSubject().isRemembered());
    }
}
