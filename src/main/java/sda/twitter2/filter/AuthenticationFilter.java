package sda.twitter2.filter;

import sda.twitter2.services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        String userId = null;
        if(cookies != null)
        for(Cookie c : cookies){
            if(c.getName().equals("userId")){
                userId = c.getValue();
            }
        }
        if(userId == null){
            request.getRequestDispatcher("register.jsp").forward(request,response);
        } else {
            ((HttpServletRequest) request).getSession().setAttribute("user", UserService.INSTANCE.findUser(Integer.parseInt(userId)));
        }
        chain.doFilter(request, response);
    }
}
