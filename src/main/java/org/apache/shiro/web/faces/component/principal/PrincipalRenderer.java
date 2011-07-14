package org.apache.shiro.web.faces.component.principal;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.apache.shiro.web.faces.facelets.ShiroSecureRenderer;

public class PrincipalRenderer extends ShiroSecureRenderer {

    @Override
    public void encodeBegin(FacesContext facesContext, UIComponent uiComponent)
            throws IOException {
        
        if(uiComponent instanceof Principal){
            Principal principalComponent = (Principal) uiComponent;
            String strValue = null;

            try {
                if (principalComponent.getSubject() != null) {
                    // Get the principal to print out
                    Object principal;

                    if (principalComponent.getType() == null) {
                        principal = principalComponent.getSubject().getPrincipal();
                    } else {
                        principal = principalComponent.getPrincipalFromClassName();
                    }

                    // Get the string value of the principal
                    if (principal != null) {
                        if (principalComponent.getProperty() == null) {
                            strValue = principal.toString();
                        } else {
                            strValue = principalComponent.getPrincipalProperty(principal, principalComponent.getProperty());
                        }
                    }
                }
            } catch (Exception e) {
                log.error("Error getting principal type [" + principalComponent.getType() + "], property [" + principalComponent.getProperty() + "]: " + e.getMessage(), e);
            }

            if (strValue == null) {
                strValue = principalComponent.getDefaultValue();
            }

            // Print out the principal value if not null
            if (strValue != null) {
                try {
                    facesContext.getResponseWriter().write(strValue);
                } catch (IOException e) {
                    throw new IOException("Error writing [" + strValue + "] to output.");
                }
            }
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {

        if (context == null || component == null) {
            throw new NullPointerException();
        }

        if (!component.isRendered()) return;

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
