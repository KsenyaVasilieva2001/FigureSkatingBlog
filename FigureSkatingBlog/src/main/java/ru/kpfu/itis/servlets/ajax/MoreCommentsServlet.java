package ru.kpfu.itis.servlets.ajax;

import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.CommentForArticle;
import ru.kpfu.itis.servlets.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajax/comments")
public class MoreCommentsServlet extends AbstractController {


    private int getOffset(HttpServletRequest req) {
        String val = req.getParameter("offset");
        if (val != null) {
            return Integer.parseInt(val);
        } else {
            return 0;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int offset = getOffset(req);
        long idArticle = Long.parseLong(req.getParameter("idArticle"));
        List<CommentForArticle> comments = getBusinessService().listCommentsArticle(idArticle, offset+1, Constants.LIMIT_COMMENTS_PER_PAGE);
        req.setAttribute("comments", comments);
        forwardToFragment("videoComment.jsp", req, resp);
    }
}
