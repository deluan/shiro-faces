package org.apache.shiro.web.faces.component.hasrole;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.apache.shiro.web.faces.facelets.ShiroSecureRenderer;

public class HasRoleRenderer extends ShiroSecureRenderer {

    @Override
    public void encodeBegin(FacesContext facesContext, UIComponent uiComponent)
            throws IOException {
        
        if(uiComponent instanceof HasRole){
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {

        if (context == null || component == null) {
            throw new NullPointerException();
        }

        if (!component.isRendered()) return;

        if(component instanceof HasRole){
            HasRole hasRoleComponent = (HasRole)component;
            if (!hasRoleComponent.showTagBody(hasRoleComponent.getName())) return;
        }

        renderChildren(context, component);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
