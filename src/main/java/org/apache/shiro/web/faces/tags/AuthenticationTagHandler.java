package org.apache.shiro.web.faces.tags;

import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagConfig;
import java.io.IOException;

/**
 * Base TagHandler for Tags that check for authentication.
 *
 * @author Deluan Quintao
 */
public abstract class AuthenticationTagHandler extends SecureTagHandler {

    public AuthenticationTagHandler(TagConfig config) {
        super(config);
    }

    public void apply(FaceletContext ctx, UIComponent parent) throws IOException, FacesException, ELException {
        if (showTagBody()) {
            this.nextHandler.apply(ctx, parent);
        }
    }

    protected abstract boolean checkAuthentication();

    protected boolean showTagBody() {
        if (checkAuthentication()) {
            if (log.isTraceEnabled()) {
                log.trace("Authentication successfully verified.  " + "Tag body will be evaluated.");
            }
            return true;
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Authentication verification failed.  " + "Tag body will not be evaluated.");
            }
            return false;
        }
    }

}
