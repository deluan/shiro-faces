package org.apache.shiro.faces.tags;

import java.io.IOException;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for JSF components
 * 
 * @author Deluan
 */
public abstract class SecureComponent extends UIOutput {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    protected Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    @Override
    public void encodeAll(FacesContext ctx) throws IOException {
        verifyAttributes();
        doEncodeAll(ctx);
    }

    protected void verifyAttributes() throws IOException {
    }

    protected abstract void doEncodeAll(FacesContext ctx) throws IOException;
    
}
