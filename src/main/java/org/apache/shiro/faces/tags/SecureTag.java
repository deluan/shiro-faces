package org.apache.shiro.faces.tags;

import com.sun.facelets.tag.TagConfig;
import com.sun.facelets.tag.TagHandler;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for all TagHandlers
 * 
 * @author Deluan 
 */
public abstract class SecureTag extends TagHandler {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    public SecureTag(TagConfig config) {
        super(config);
    }

    protected Subject getSubject() {
        return SecurityUtils.getSubject();
    }

}
