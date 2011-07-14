package org.apache.shiro.web.faces.facelets;

import java.io.IOException;
import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author genya80
 */
public abstract class ShiroSecureRenderer extends Renderer  {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    public final void renderChild(FacesContext facesContext, UIComponent child)
            throws IOException {
        if (!child.isRendered()) {
            return;
        }

        child.encodeBegin(facesContext);
        if (child.getRendersChildren()) {
            child.encodeChildren(facesContext);
        } else {
            renderChildren(facesContext, child);
        }
        child.encodeEnd(facesContext);
    }

    public final void renderChildren(FacesContext facesContext,
                                      UIComponent component)
            throws IOException {
        if (component.getChildCount() > 0) {
            for (Iterator it = component.getChildren().iterator();
                 it.hasNext();) {
                UIComponent child = (UIComponent) it.next();
                renderChild(facesContext, child);
            }
        }
    }
}
