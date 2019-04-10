package sda.twitter2.controllers;

import sda.twitter2.models.User;
import sda.twitter2.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(name="LoginController",
        urlPatterns = "/login")
public class LoginController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passwordHash = "";
        try {
            passwordHash = DatatypeConverter.printHexBinary(
                    MessageDigest.getInstance("MD5").digest(request.getParameter("password").getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = UserService.INSTANCE.findUser(request.getParameter("username"), passwordHash);
        Cookie c = new Cookie("userId", ""+user.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
    }
}
