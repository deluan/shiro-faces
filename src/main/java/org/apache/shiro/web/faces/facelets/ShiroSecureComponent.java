package org.apache.shiro.web.faces.facelets;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author genya80
 */
public abstract class ShiroSecureComponent extends javax.faces.component.UIComponentBase  {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    public ShiroSecureComponent(){
        super();
    }

    public Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    @Override
    public String getFamily() {
        return "org.apache.shiro.Component";
    }
}
