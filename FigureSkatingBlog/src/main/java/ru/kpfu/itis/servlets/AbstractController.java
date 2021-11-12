package ru.kpfu.itis.servlets;




import org.apache.commons.beanutils.BeanUtils;
import ru.kpfu.itis.services.BusinessService;

import ru.kpfu.itis.services.SocialService;
import ru.kpfu.itis.services.UserService;
import ru.kpfu.itis.services.impls.ServiceManager;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * for videoblog pages
 */
public abstract class AbstractController extends HttpServlet {
    private BusinessService businessService;
    private SocialService googleService;
    private UserService userService;
    public final BusinessService getBusinessService() {
        return businessService;
    }
    public final UserService getUserService() {return userService;}
    public final SocialService getGoogleService() {return googleService;}
    public final int getOffset(HttpServletRequest req, int limit) {
        String val = req.getParameter("page");
        if (val != null) {
            int page = Integer.parseInt(val);
            return (page - 1) * limit;
        } else {
            return 0;
        }
    }

    @Override
    public void init() throws ServletException {
        businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
       userService = ServiceManager.getInstance(getServletContext()).getUserService();
        ServletContext servletContext = getServletContext();
    }
    public final void forwardToPage (String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", "/WEB-INF/views/jsp/page/"+jspPage);
        req.getRequestDispatcher("/WEB-INF/views/jsp/page-template.jsp").forward(req, resp);
    }

    public final void forwardToFragment (String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/fragment/"+jspPage).forward(req, resp);
    }


    public final <T> T createForm(HttpServletRequest req, Class<T> formClass) throws ServletException {
        try {
            T form = formClass.newInstance();
            BeanUtils.populate(form, req.getParameterMap());
            return form;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new ServletException(e);
        }
    }
}