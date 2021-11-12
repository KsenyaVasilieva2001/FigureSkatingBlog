package ru.kpfu.itis.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class MainFilter implements Filter {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public void init(FilterConfig filterConfig) throws ServletException {
    }


    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        doFilter(req, resp, chain);
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException{
        try {
            chain.doFilter(req, resp);
        } catch (Throwable th) {
            String requestUrl = req.getRequestURI();
            LOGGER.error("Error during processing the request: " + requestUrl, th);
            if (requestUrl.startsWith("/ajax/")) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } else if (!requestUrl.startsWith("/error")) {
                resp.sendRedirect("/error");
            } else {
                throw new ServletException(th);
            }
        }
    }


    public void destroy() {
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
