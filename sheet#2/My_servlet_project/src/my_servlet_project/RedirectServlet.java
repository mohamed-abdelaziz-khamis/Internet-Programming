//RedirectServlet.java
//Redirecting a user to different web pages

package my_servlet_project;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * <p>Title:RedirectServlet </p>
 *
 * <p>Description:redirecting requests to other resources </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: Mohamed Abd El Aziz</p>
 *
 * @author not attributable
 * @version 1.0
 */


public class RedirectServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request from client
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

      //Obtains the page parameter from the request.
      String location = request.getParameter( "page" );

    //redirect the requests to another servlets
    if ( location != null )
      //Determine if the value is either "servlet1" or "servlet2"
      if ( location.equals( "servlet1" ) )
        //Redirects the request to the servlet servlet1.
        response.sendRedirect( "servlet1" );
      else
      if ( location.equals( "servlet2" ) )
        //Redirects the request to the servlet servlet2.
        response.sendRedirect( "servlet2" );

     //code that executes only if this servlet
     //does not redirect the user to another page
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        //start XHTML document
        out.println("<html>");

        //head section of document
        out.println("<head><title>Invalid page</title></head>");

        //body section of document
        out.println("<body bgcolor=\"#ffffff\">");
        out.println("<h1>Invalid page requested</h1>");
        out.println("<p><a href = " + "\" WebModule1/index.html\">");
        out.println("Click here to choose again</a></p>");
        out.println("</body>");

        //end XHTML document
        out.println("</html>");
        out.close(); //close stream to complete the page.
    }

    //Clean up resources
    public void destroy() {
    }
}
