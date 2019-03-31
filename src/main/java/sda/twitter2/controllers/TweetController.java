package sda.twitter2.controllers;

import sda.twitter2.models.Tweet;
import sda.twitter2.services.TweetService;
import sda.twitter2.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name="TweetController",
        urlPatterns = "/tweet")
public class TweetController extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = null;
        for(Cookie c : request.getCookies()){
            if(c.getName().equals("userId")){
                userId = c.getValue();
            }
        }

        Tweet tweet = new Tweet();
        tweet.setContent(request.getParameter("content"));
        tweet.setDate(new Date());
        tweet.setAuthor(UserService.INSTANCE.findUser(Integer.parseInt(userId)));
        TweetService.INSTANCE.createTweet(tweet);
        response.setStatus(201);
    }
}
