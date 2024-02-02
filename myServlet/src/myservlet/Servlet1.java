package myservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Servlet1
    extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";

  //Initialize global variables
  public void init() throws ServletException {
  }

  //Process the HTTP Get request
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws
      ServletException, IOException {
    //start replying
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Welcome1</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");
    out.println("<p>Welcome to my first page.</p>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  //Clean up resources
  public void destroy() {
  }
}
