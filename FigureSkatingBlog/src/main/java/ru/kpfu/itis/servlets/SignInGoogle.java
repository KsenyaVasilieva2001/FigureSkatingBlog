package ru.kpfu.itis.servlets;

import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.exceptions.NoConnectionToGoogleAccount;
import ru.kpfu.itis.exceptions.NoSuchLoginException;
import ru.kpfu.itis.exceptions.WrongPasswordException;
import ru.kpfu.itis.models.SocialAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
/*
@WebServlet("/signin-google")
public class SignInGoogle extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage("signin.jsp",req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SocialAccount user = getGoogleService().getSocialAccount("social.googleplus.clientId");
        req.setAttribute("user", user);
        req.setAttribute("googleProfile", user);
        UUID uuid = UUID.randomUUID();
        Cookie c = new Cookie(Constants.AUTH_COOKIE_NAME, uuid.toString());
        c.setMaxAge(60 * 60 * 24 * 365);
        resp.addCookie(c);
        resp.sendRedirect(req.getContextPath() + "/profile");
        return;
    }
}


 */

