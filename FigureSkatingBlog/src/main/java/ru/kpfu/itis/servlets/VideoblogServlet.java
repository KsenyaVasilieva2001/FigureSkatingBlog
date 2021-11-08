package ru.kpfu.itis.servlets;

import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.ArticleEntity;
import ru.kpfu.itis.entities.CategoryEntity;
import ru.kpfu.itis.models.Items;
import ru.kpfu.itis.models.Pagination;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.System.out;


@WebServlet({"/videoblog", "/videoblog/*"})
public class VideoblogServlet extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int offset = getOffset(req,Constants.LIMIT_ARTICLES_PER_PAGE);
        String requestUrl = req.getRequestURI();
        Items<ArticleEntity> items = null;
        out.print(requestUrl);
        if(requestUrl.endsWith("/videoblog") || requestUrl.endsWith("/videoblog/")){
            items = getBusinessService().listArticles(offset, Constants.LIMIT_ARTICLES_PER_PAGE);
        }
        else{
            String categoryUrl = requestUrl.substring(requestUrl.lastIndexOf("/"),requestUrl.length());
            out.print(categoryUrl);
            items = getBusinessService().listArticlesByCategory(categoryUrl, offset, Constants.LIMIT_ARTICLES_PER_PAGE);
            CategoryEntity category = getBusinessService().findCategoryByUrl(categoryUrl);
            req.setAttribute("selectedCategory", category);
        }
        Pagination pagination = new Pagination.Builder(requestUrl+"?", offset, items.getCount()).withLimit(Constants.LIMIT_ARTICLES_PER_PAGE).build();
        req.setAttribute("pagination", pagination);
        req.setAttribute("list", items.getItems());
        forwardToPage("videoblog.jsp", req, resp);
    }
}