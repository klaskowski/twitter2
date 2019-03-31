package sda.twitter2.filter;

import sda.twitter2.services.UserService;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/"})
public class AuthenticationFilter extends HttpServlet {

//    @Override
//    public void doGet(HttpServletRequest request,
//                       HttpServletResponse response) throws IOException {
//
//        String userId = null;
//        for(Cookie c : request.getCookies()){
//            if(c.getName().equals("userId")){
//                userId = c.getValue();
//            }
//        }
//        if(userId == null){
//            response.sendRedirect("register.jsp");
//        } else {
//            request.setAttribute("user", UserService.INSTANCE.findUser(Integer.parseInt(userId)));
//        }
//    }
}
