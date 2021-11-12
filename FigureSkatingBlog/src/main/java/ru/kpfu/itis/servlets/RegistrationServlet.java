package ru.kpfu.itis.servlets;
import ru.kpfu.itis.constants.Constants;
import ru.kpfu.itis.entities.UserEntity;
import ru.kpfu.itis.exceptions.InvalidEmailException;
import ru.kpfu.itis.exceptions.OcupiedLoginException;
import ru.kpfu.itis.exceptions.WeakPasswordException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@WebServlet("/registration")
public class RegistrationServlet extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage("registration.jsp",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("password").equals(req.getParameter("rep_password"))){
            try {
               UUID uuid = getUserService().registration(req.getParameter("username"),req.getParameter("email"),
                     req.getParameter("password"), req.getSession());
                UserEntity user = getUserService().getUserByUUID(uuid);
              Cookie c = new Cookie(Constants.AUTH_COOKIE_NAME, uuid.toString());
              c.setMaxAge(60*60*24*365);
              resp.addCookie(c);
                resp.sendRedirect(req.getContextPath() + "/profile");
                return;
            } catch (InvalidEmailException e){
                req.setAttribute("message", "Неверный email");
            } catch (OcupiedLoginException e){
                req.setAttribute("message", "Такой email уже существует");
            } catch (WeakPasswordException e) {
                req.setAttribute("message", "Пароль слишком короткий (мин. 8 символов)");
            }
        }
        else {
            req.setAttribute("message", "Пароли не совпадают");
        }
        forwardToPage("registration.jsp",req,resp);
    }
}

