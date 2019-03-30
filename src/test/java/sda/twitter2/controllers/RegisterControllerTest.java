package sda.twitter2.controllers;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class RegisterControllerTest {

    RegisterController registerController;
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);

    @Before
    public void setUp() throws ServletException {
        registerController = new RegisterController();
        registerController.init();
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        // TODO Prepare GIVEN step - mock the content of request object
        //...
        // WHEN
        //registerController.doPost(request, response);
        //TODO Prepare THEN step - verify response object content and whether certain redirects have been called
    }
}
