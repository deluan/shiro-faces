package org.apache.shiro.web.faces.tags;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import java.io.IOException;

/**
 * Base TagHandler for Tags that check for permissions.
 *
 * @author Deluan Quintao
 */
public abstract class PermissionTagHandler extends SecureTagHandler {

    private final TagAttribute name;

    public PermissionTagHandler(TagConfig config) {
        super(config);
        this.name = this.getRequiredAttribute("name");
    }

    private String getAttrValue(FaceletContext ctx, TagAttribute attr) {
        String value;
        if (attr.isLiteral()) {
            value = attr.getValue(ctx);
        } else {
            ValueExpression expression = attr.getValueExpression(ctx, String.class);
            value = (String) expression.getValue(ctx);
        }
        return value;
    }

    public void apply(FaceletContext ctx, UIComponent parent)
            throws IOException, FacesException, ELException {
        String perm;
        perm = getAttrValue(ctx, name);
        if (showTagBody(perm)) {
            this.nextHandler.apply(ctx, parent);
        }
    }

    protected boolean isPermitted(String p) {
        return getSubject() != null && getSubject().isPermitted(p);
    }

    protected abstract boolean showTagBody(String p);

}
