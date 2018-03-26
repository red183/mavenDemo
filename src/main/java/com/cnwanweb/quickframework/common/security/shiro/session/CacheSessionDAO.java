package com.cnwanweb.quickframework.common.security.shiro.session;

import com.cnwanweb.quickframework.common.config.Global;
import com.cnwanweb.quickframework.common.utils.DateUtils;
import com.cnwanweb.quickframework.common.utils.StringUtils;
import com.cnwanweb.quickframework.common.web.Servlets;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheSessionDAO extends EnterpriseCacheSessionDAO implements SessionDAO {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CacheSessionDAO() {
    }

    protected void doUpdate(Session session) {
        if(session != null && session.getId() != null) {
            HttpServletRequest request = Servlets.getRequest();
            if(request != null) {
                String uri = request.getServletPath();
                if(Servlets.isStaticFile(uri)) {
                    return;
                }

                if(StringUtils.startsWith(uri, Global.getConfig("web.view.prefix")) && StringUtils.endsWith(uri, Global.getConfig("web.view.suffix"))) {
                    return;
                }

                String updateSession = request.getParameter("updateSession");
                if("false".equals(updateSession) || "0".equals(updateSession)) {
                    return;
                }
            }

            super.doUpdate(session);
            this.logger.debug("update {} {}", session.getId(), request != null?request.getRequestURI():"");
        }
    }

    protected void doDelete(Session session) {
        if(session != null && session.getId() != null) {
            super.doDelete(session);
            this.logger.debug("delete {} ", session.getId());
        }
    }

    protected Serializable doCreate(Session session) {
        HttpServletRequest request = Servlets.getRequest();
        if(request != null) {
            String uri = request.getServletPath();
            if(Servlets.isStaticFile(uri)) {
                return null;
            }
        }

        super.doCreate(session);
        this.logger.debug("doCreate {} {}", session, request != null?request.getRequestURI():"");
        return session.getId();
    }

    protected Session doReadSession(Serializable sessionId) {
        return super.doReadSession(sessionId);
    }

    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        try {
            Session s = null;
            HttpServletRequest request = Servlets.getRequest();
            if(request != null) {
                String uri = request.getServletPath();
                if(Servlets.isStaticFile(uri)) {
                    return null;
                }

                s = (Session)request.getAttribute("session_" + sessionId);
            }

            if(s != null) {
                return s;
            } else {
                Session session = super.readSession(sessionId);
                this.logger.debug("readSession {} {}", sessionId, request != null?request.getRequestURI():"");
                if(request != null && session != null) {
                    request.setAttribute("session_" + sessionId, session);
                }

                return session;
            }
        } catch (UnknownSessionException var5) {
            return null;
        }
    }

    public Collection<Session> getActiveSessions(boolean includeLeave) {
        return this.getActiveSessions(includeLeave, (Object)null, (Session)null);
    }

    public Collection<Session> getActiveSessions(boolean includeLeave, Object principal, Session filterSession) {
        if(includeLeave && principal == null) {
            return this.getActiveSessions();
        } else {
            Set<Session> sessions = Sets.newHashSet();
            Iterator i$ = this.getActiveSessions().iterator();

            while(i$.hasNext()) {
                Session session = (Session)i$.next();
                boolean isActiveSession = false;
                if(includeLeave || DateUtils.pastMinutes(session.getLastAccessTime()) <= 3L) {
                    isActiveSession = true;
                }

                if(principal != null) {
                    PrincipalCollection pc = (PrincipalCollection)session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                    if(principal.toString().equals(pc != null?pc.getPrimaryPrincipal().toString():"")) {
                        isActiveSession = true;
                    }
                }

                if(filterSession != null && filterSession.getId().equals(session.getId())) {
                    isActiveSession = false;
                }

                if(isActiveSession) {
                    sessions.add(session);
                }
            }

            return sessions;
        }
    }
}
