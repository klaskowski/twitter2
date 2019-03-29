package sda.twitter2.controllers;

import sda.twitter2.models.User;
import sda.twitter2.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

@WebServlet(name="RegisterController",
        urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        try {
            user.setPassword(DatatypeConverter.printHexBinary(
                    MessageDigest.getInstance("MD5").digest(request.getParameter("password").getBytes("UTF-8"))));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        UserService.INSTANCE.registerUser(user);
        Cookie c = new Cookie("userId", ""+user.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);
        response.sendRedirect("/twitter2/");
    }
}
