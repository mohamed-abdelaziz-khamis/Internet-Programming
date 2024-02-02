package my_servlet_project;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * <p>Title:servlet2 </p>
 *
 * <p>Description:The second servlet </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company:Mohamed Abd El Aziz </p>
 *
 * @author not attributable
 * @version 1.0
 */


public class servlet2 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>servlet2</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");
        out.println("<p>The second servlet has received a GET. This is the reply.</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    //Clean up resources
    public void destroy() {
    }
}
