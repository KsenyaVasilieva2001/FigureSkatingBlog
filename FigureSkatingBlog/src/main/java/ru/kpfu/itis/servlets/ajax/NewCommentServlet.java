package ru.kpfu.itis.servlets.ajax;

import ru.kpfu.itis.entities.CommentForArticle;
import ru.kpfu.itis.entities.UserEntity;
import ru.kpfu.itis.forms.CommentForm;
import ru.kpfu.itis.servlets.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet("/ajax/comment")
public class NewCommentServlet extends AbstractController {
    private static final long serialVersionUID = 5627021600006044806L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentForm form = createForm(req, CommentForm.class);
        UserEntity user = (UserEntity) req.getSession().getAttribute("user");
        CommentForArticle comment = getBusinessService().createComment(form,user);
        req.setAttribute("comments", Collections.singleton(comment));
        forwardToFragment("videoComment.jsp", req, resp);
    }
}
