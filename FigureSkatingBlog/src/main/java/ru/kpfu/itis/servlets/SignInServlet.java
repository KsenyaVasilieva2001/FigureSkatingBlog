package ru.kpfu.itis.servlets;

import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.exceptions.NoSuchLoginException;
import ru.kpfu.itis.exceptions.WrongPasswordException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/signin")
public class SignInServlet extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("email") != null) {
            req.setAttribute("email", req.getParameter("email"));
            try {
                UUID uuid = getUserService().authorize(req.getParameter("email"),
                        req.getParameter("password"), req.getSession());
                Cookie c = new Cookie(Constants.AUTH_COOKIE_NAME, uuid.toString());
                c.setMaxAge(60*60*24*365);
                resp.addCookie(c);
                resp.sendRedirect(req.getContextPath() + "/profile");
                return;
            } catch (WrongPasswordException e) {
                req.setAttribute("message", "Неверный логин или пароль");
            } catch (NoSuchLoginException e) {
                req.setAttribute("message", "Неверный логин или пароль");
            }

        }
        forwardToPage("signin.jsp",req,resp);
    }
}