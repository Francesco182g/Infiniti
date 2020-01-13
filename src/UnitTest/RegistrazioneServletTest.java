package UnitTest;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Servlet.RegistrazioneServlet;

public class RegistrazioneServletTest extends Mockito{
	RegistrazioneServlet servlet;
    HttpServletRequest request;     
    HttpServletResponse response;
    
    /**
     * Before.
     */
    @Before
    public void setUp() {
      servlet = new RegistrazioneServlet();
      request = mock(HttpServletRequest.class);       
      response = mock(HttpServletResponse.class); 
    }
    
	  @Test
	  public void testRegistrazioneUtente() throws ServletException, IOException {
		request.setAttribute("user_email", "pippo@pippo.it");  
		request.setAttribute("user_password", "password");
	    request.setAttribute("user_confpassword", "password");
	    servlet.doGet(request, response);
	    assertEquals("json", response.getContentType());
	  }

}
