package org.apache.shiro.web.faces.component.principal;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Modifier;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.faces.facelets.ShiroSecureComponent;

public class Principal extends ShiroSecureComponent {

    public Principal() {
        super();
        setRendererType("org.apache.shiro.web.faces.component.principal.PrincipalRenderer");
    }

    /**
     * The type of principal to be retrieved, or null if the default principal should be used.
     */
    private String type;
    /**
     * The property name to retrieve of the principal, or null if the <tt>toString()</tt> value should be used.
     */
    private String property;
    /**
     * The default value that should be displayed if the user is not authenticated, or no principal is found.
     */
    private String defaultValue;

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/
    public String getType() {
        if (null != this.type) {
            return type;
        }
        ValueExpression ve = getValueExpression("type");
        if (ve != null) {
            return (java.lang.String) ve.getValue(getFacesContext().getELContext());
        } else {
            return null;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperty() {
        if (null != this.property) {
            return property;
        }

        ValueExpression ve = getValueExpression("property");
        if (ve != null) {
            return (java.lang.String) ve.getValue(getFacesContext().getELContext());
        } else {
            return null;
        }
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDefaultValue() {
        if (null != this.defaultValue) {
            return this.defaultValue;
        }

        ValueExpression ve = getValueExpression("defaultValue");
        if (ve != null) {
            return (java.lang.String) ve.getValue(getFacesContext().getELContext());
        } else {
            return null;
        }
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/
    @SuppressWarnings({"unchecked"})
    protected Object getPrincipalFromClassName() {
        Object principal = null;

        try {
            Class cls = Class.forName(type);
            PrincipalCollection principals = getSubject().getPrincipals();
            if (principals != null) {
                principal = principals.oneByType(cls);
            }
        } catch (ClassNotFoundException e) {
            if (log.isErrorEnabled()) {
                log.error("Unable to find class for name [" + type + "]");
            }
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Unknown error while getting principal for type [" + type + "]: " + e.getMessage(), e);
            }
        }
        return principal;
    }

    protected String getPrincipalProperty(Object principal, String property) throws IOException {
        String strValue = null;

        try {
            BeanInfo bi = Introspector.getBeanInfo(principal.getClass());

            // Loop through the properties to get the string value of the specified property
            boolean foundProperty = false;
            for (PropertyDescriptor pd : bi.getPropertyDescriptors()) {
                if (pd.getName().equals(property) && (Modifier.isPublic(pd.getReadMethod().getModifiers()))) {
                    Object value = null;
                    try {
                        pd.getReadMethod().setAccessible(true);
                        value = pd.getReadMethod().invoke(principal, (Object[]) null);
                    } finally {
                        pd.getReadMethod().setAccessible(false);
                    }
                    strValue = String.valueOf(value);
                    foundProperty = true;
                    break;
                }
            }

            if (!foundProperty) {
                final String message = "Property [" + property + "] not found in principal of type [" + principal.getClass().getName() + "]";
                if (log.isErrorEnabled()) {
                    log.error(message);
                }
                throw new IOException(message);
            }

        } catch (Exception e) {
            final String message = "Error reading property [" + property + "] from principal of type [" + principal.getClass().getName() + "]";
            if (log.isErrorEnabled()) {
                log.error(message, e);
            }
            throw new IOException(message);
        }

        return strValue;
    }

    // ----------------------------------------------------- StateHolder Methods
    private Object[] values;

    @Override
    public Object saveState(FacesContext context) {
        if (values == null) {
            values = new Object[4];
        }
        values[0] = super.saveState(context);
        values[1] = type;
        values[2] = property;
        values[3] = defaultValue;

        return values;
    }

    @Override
    public void restoreState(FacesContext context, Object state) {
        values = (Object[]) state;
        super.restoreState(context, values[0]);
        type = (String) values[1];
        property = (String) values[2];
        defaultValue = (String) values[3];
    }
}
