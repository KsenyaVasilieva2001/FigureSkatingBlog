package ru.kpfu.itis.servlets;
import org.apache.commons.lang.StringUtils;
import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.ArticleEntity;
import ru.kpfu.itis.exceptions.RedirectToValidUrlException;
import ru.kpfu.itis.models.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;


@WebServlet("/article/*")
public class ArticleServlet extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String requestUrl = req.getRequestURI();
          String url = requestUrl.substring(requestUrl.lastIndexOf("/"), requestUrl.length());
          ArticleEntity article = getBusinessService().viewArticle(url, requestUrl);
          req.setAttribute("article", article);
          forwardToPage("article.jsp", req, resp);
          out.print(article);
    }
}
