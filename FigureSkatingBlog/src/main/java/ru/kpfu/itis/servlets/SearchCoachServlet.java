package ru.kpfu.itis.servlets;

import org.apache.commons.lang.StringUtils;
import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.ArticleEntity;
import ru.kpfu.itis.entities.CoachEntity;
import ru.kpfu.itis.models.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search-coach")
public class SearchCoachServlet extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        if (StringUtils.isNotBlank(query)) {
            Items<CoachEntity> items = getBusinessService().listCoachesBySearchQuery(query, 0, Constants.LIMIT_ARTICLES_PER_PAGE);
            req.setAttribute("list", items.getItems());
            req.setAttribute("count", items.getCount());
            req.setAttribute("searchQuery", query);
            forwardToPage("searchCoach.jsp", req, resp);
        } else {
            resp.sendRedirect("/coach-list");
        }
    }
}

