package ru.kpfu.itis.servlets;




import ru.kpfu.itis.services.BusinessService;
import ru.kpfu.itis.services.impls.ServiceManager;

import java.io.IOException;

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
    public final BusinessService getBusinessService() {
        return businessService;
    }

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
    }
    public final void forwardToPage (String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", "/WEB-INF/views/jsp/page/"+jspPage);
        req.getRequestDispatcher("/WEB-INF/views/jsp/page-template.jsp").forward(req, resp);
    }

    public final void forwardToFragment (String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/fragment/"+jspPage).forward(req, resp);
    }
}