package ru.kpfu.itis.servlets;
import ru.kpfu.itis.entities.CommentForArticle;
import ru.kpfu.itis.forms.CommentForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet("/coach-article")
public class CoachArticleServlet extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage("coach-article.jsp", req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
      // req.setAttribute("comments", Collections.singleton(comment));
        forwardToFragment("videoComment.jsp", req, resp);
    }
}
