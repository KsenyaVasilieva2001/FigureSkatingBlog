package ru.kpfu.itis.servlets;
import org.apache.commons.lang.StringUtils;
import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.ArticleEntity;
import ru.kpfu.itis.models.Items;
import ru.kpfu.itis.models.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/search")
    public class SearchServlet extends AbstractController {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int offset = getOffset(req, Constants.LIMIT_ARTICLES_PER_PAGE);
            String query = req.getParameter("query");
            if (StringUtils.isNotBlank(query)) {
                Items<ArticleEntity> items = getBusinessService().listArticlesBySearchQuery(query, 0, Constants.LIMIT_ARTICLES_PER_PAGE);
                req.setAttribute("list", items.getItems());
                req.setAttribute("count", items.getCount());
                req.setAttribute("searchQuery", query);


                Pagination pagination = new Pagination.Builder("/search?query=" + URLEncoder.encode(query, "utf8") + "&",
                        offset, items.getCount()).withLimit(Constants.LIMIT_ARTICLES_PER_PAGE).build();
                req.setAttribute("pagination", pagination);
                forwardToPage("search.jsp", req, resp);
            } else {
                resp.sendRedirect("/videoblog");
            }
        }
    }


