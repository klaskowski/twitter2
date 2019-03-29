package sda.twitter2.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LogoutController",
        urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        for (Cookie cookie : request.getCookies())
            if(cookie.getName().equals("userId")) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                response.sendRedirect("/twitter2/");
            }
    }
}
