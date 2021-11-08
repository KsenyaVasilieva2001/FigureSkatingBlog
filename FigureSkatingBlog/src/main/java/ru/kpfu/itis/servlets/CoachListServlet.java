package ru.kpfu.itis.servlets;
import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.ArticleEntity;
import ru.kpfu.itis.entities.CategoryEntity;
import ru.kpfu.itis.entities.CoachEntity;
import ru.kpfu.itis.models.Items;
import ru.kpfu.itis.models.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;


@WebServlet({"/coach-list", "/coach-list/*"})
    public class CoachListServlet extends AbstractController {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int offset = getOffset(req,Constants.LIMIT_ARTICLES_PER_PAGE);
            String requestUrl = req.getRequestURI();
            Items<CoachEntity> items = null;
            if(requestUrl.endsWith("/coach-list")){
                items = getBusinessService().listCoaches(offset, Constants.LIMIT_ARTICLES_PER_PAGE);
                req.setAttribute("listCoaches", items.getItems());
                Pagination pagination = new Pagination.Builder(requestUrl+"?", offset, items.getCount()).withLimit(Constants.LIMIT_ARTICLES_PER_PAGE).build();
                req.setAttribute("pagination", pagination);
                req.setAttribute("listCoaches", items.getItems());
                forwardToPage("coach-list.jsp", req, resp);
            }
            else{
                String coachUrl = requestUrl.substring(requestUrl.lastIndexOf("/"),requestUrl.length());
                items = getBusinessService().listCoachesByCategory("/coach-list"+coachUrl);
                CoachEntity coach = getBusinessService().findCoachByUrl("/coach-list"+coachUrl);
                Pagination pagination = new Pagination.Builder(requestUrl+"?", offset, items.getCount()).withLimit(Constants.LIMIT_ARTICLES_PER_PAGE).build();
                req.setAttribute("pagination", pagination);
                req.setAttribute("coach", coach);
                forwardToPage("coach-article.jsp", req, resp);
            }
        }
    }

