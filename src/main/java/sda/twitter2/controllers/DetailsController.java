package sda.twitter2.controllers;

import sda.twitter2.models.User;
import sda.twitter2.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="DetailsController",
        urlPatterns = "/details")
public class DetailsController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("selectedUser", UserService.INSTANCE.findUser(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("details.jsp").forward(request, response);
    }
}
