package org.apache.shiro.web.faces.component.hasanypermission;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.apache.shiro.web.faces.facelets.ShiroSecureRenderer;

public class HasAnyPermissionRenderer extends ShiroSecureRenderer {

    @Override
    public void encodeBegin(FacesContext facesContext, UIComponent uiComponent)
            throws IOException {
        
        if(uiComponent instanceof HasAnyPermission){
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {

        if (context == null || component == null) {
            throw new NullPointerException();
        }

        if (!component.isRendered()) return;

        if(component instanceof HasAnyPermission){
            HasAnyPermission hasAnyPermissionComponent = (HasAnyPermission)component;
            if (!hasAnyPermissionComponent.showTagBody(hasAnyPermissionComponent.getName())) return;
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
