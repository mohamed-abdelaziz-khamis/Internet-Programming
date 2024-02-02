package myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class MainServlet
    extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";

  //Initialize global variables
  public void init() throws ServletException {
  }

  //Process the HTTP Get request
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws
      ServletException, IOException {

    //get the parameter "page"
    String location = request.getParameter( "page" );
    //redirect the requests to another servlets
    if ( location != null )
      if ( location.equals( "welcome1" ) )
        response.sendRedirect( "servlet1" );
      else
      if ( location.equals( "welcome2" ) )
        response.sendRedirect( "servlet2" );

   response.setContentType(CONTENT_TYPE);
   PrintWriter out = response.getWriter();
   out.println("<html>");
   out.println("<head><title>MainServlet</title></head>");
   out.println("<body bgcolor=\"#ffffff\">");
   out.println("<p>Invalid page.</p>");
   out.println("</body>");
   out.println("</html>");
   out.close();
  }

  //Clean up resources
  public void destroy() {
  }
}
