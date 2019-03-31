package sda.twitter2.filter;

import sda.twitter2.services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/"})
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig fcg) {
        System.out.println("fcg = [" + fcg + "]");
    }

    public void destroy(){

    }

    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("request = [" + request + "], response = [" + response + "], chain = [" + chain + "]");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String userId = null;
        for(Cookie c : servletRequest.getCookies()){
            if(c.getName().equals("userId")){
                userId = c.getValue();
            }
        }
        if(userId == null){
            System.out.println("request = [" + request + "], response = [" + response + "], chain = [" + chain + "]");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        } else {
            request.setAttribute("user", UserService.INSTANCE.findUser(Integer.parseInt(userId)));
        }
        chain.doFilter(request, response);
    }
}
