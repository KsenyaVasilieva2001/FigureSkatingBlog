package ru.kpfu.itis.servlets;
import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.exceptions.InvalidPhoneNumberException;
import ru.kpfu.itis.exceptions.InvalidUsernameException;
import ru.kpfu.itis.exceptions.NoSuchLoginException;
import ru.kpfu.itis.exceptions.WrongPasswordException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;


@WebServlet("/signup")
public class SignUpServlet extends AbstractController {
    private static final String CONTACT_REQUEST_SUCESS = "CONTACT_REQUEST_SUCESS";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isSuccess = (Boolean) req.getSession().getAttribute(CONTACT_REQUEST_SUCESS);
        if(isSuccess == null) {
            isSuccess = Boolean.FALSE;
        } else {
            req.getSession().removeAttribute(CONTACT_REQUEST_SUCESS);
        }
        req.setAttribute("success", isSuccess);
        forwardToPage("signup.jsp", req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            getUserService().subscribe(req.getParameter("userName"),req.getParameter("pnone_number"));
            req.getSession().setAttribute(CONTACT_REQUEST_SUCESS, Boolean.TRUE);
            resp.sendRedirect(req.getContextPath() + "/signup");
            return;

            } catch (InvalidPhoneNumberException e) {
                req.setAttribute("message", "Неверно указан номер телефона");
        }catch (SQLException e){
            resp.sendRedirect("/500.jsp");
        }
        forwardToPage("signup.jsp",req,resp);
    }
}