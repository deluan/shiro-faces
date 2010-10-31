package org.apache.shiro.web.faces.tags;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.TagConfig;

import javax.el.ELException;
import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import java.io.IOException;

/**
 * Base TagHandler for Tags that check for permissions.
 *
 * @author Deluan
 */
public abstract class PermissionTag extends SecureTag {

    private final TagAttribute name;

    public PermissionTag(TagConfig config) {
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
