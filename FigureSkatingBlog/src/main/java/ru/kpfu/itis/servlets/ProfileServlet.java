package ru.kpfu.itis.servlets;

import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.ArticleEntity;
import ru.kpfu.itis.entities.CommentForArticle;
import ru.kpfu.itis.entities.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/profile")
public class ProfileServlet extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage("profile.jsp",req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEntity user = (UserEntity) req.getSession().getAttribute("user");
        out.println(user);
        getUserService().updateProfile(user,req.getParameter("first_name"), req.getParameter("last_name")
               );
        req.setAttribute("update", true);

        forwardToPage("profile.jsp",req,resp);
    }

}
