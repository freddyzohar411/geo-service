package com.avensys.rts.geo.interceptor;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/***
 * This class is used to intercept the request and inject audit data into the request context.
 * @author Pranay Patadiya
 */

public class AuditInterceptor implements HandlerInterceptor   {

	private static final Logger log = LogManager.getLogger(AuditInterceptor.class);

    /**
     * This method is used to intercept the request and inject audit data into the request context.
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     

        // Get In-time in milliseconds and set in request context
        request.setAttribute("in", System.currentTimeMillis());

        // Get Thread ID and set in request context
        String threadId = RandomStringUtils.randomAlphanumeric(10);
        request.setAttribute("threadId", threadId);
        log.info("Pre-handling request :: THREAD_ID :: {} ",threadId);

        return true; // Continue the request processing chain
    }
}

