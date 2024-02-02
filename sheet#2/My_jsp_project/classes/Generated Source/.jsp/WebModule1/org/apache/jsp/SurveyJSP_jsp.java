package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.text.*;
import java.util.*;

public final class SurveyJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n<title>\r\nSurveyJSP\r\n</title>\r\n</head>\r\n<body bgcolor=\"#00ffff\">\r\n");
 //begin scriptlet

  //Set up database conncetion and create SQL statment

  //Specify database location.
  String location="C:\\My_animals.mdb";

  //Load the Microsoft Access driver
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

  //Connect to the database
  Connection connection=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+location);

  //Create Statement to query database
  Statement statement=connection.createStatement();

   DecimalFormat twoDigits=new DecimalFormat("0.00");

  //read current survey response
  String Svalue=request.getParameter("animal");

  if(Svalue != null){
    int value=Integer.parseInt(Svalue);
  // Create query to update total for current survey response.
    String query="update surveyresults set votes=votes+1 where id= " +value;
  // Execute query to update total for current survey response.
    statement.executeUpdate(query);
  //get total of all survey responses.
    query="select sum(votes) from surveyresults";
  //Execute query to get total of all survey responses.
    ResultSet totalRS=statement.executeQuery(query);
    totalRS.next();
    int total=totalRS.getInt(1);

   //get results
   //Create query to get survey results.
    query="select surveyoption,votes,id from surveyresults order by id";
   //Execute query to get survey results.
    ResultSet resultsRS = statement.executeQuery(query);
   
      out.write(' ');
      out.write("\r\n   <p>Thank you for participating.<br/> Results: </p>\r\n   <table>\r\n   ");
 //start scriptlet
    int votes;
    while(resultsRS.next()) {
   
      out.write(' ');
      out.write("\r\n\r\n      <tr>\r\n        <td>");
      out.print(resultsRS.getString(1));
      out.write("</td>\r\n        <td><p>:</p></td>\r\n        ");
votes=resultsRS.getInt(2);
      out.write("\r\n        <td>");
      out.print(twoDigits.format((double)votes/total*100));
      out.write("</td>\r\n        <td><p>%  responses:</p></td>\r\n        <td>");
      out.print(votes);
      out.write("</td>\r\n      </tr>\r\n    ");
 }
      out.write("\r\n   <tr>\r\n     <td><p>Total responses: </p></td>\r\n     <td>");
      out.print(total);
      out.write("</td>\r\n   </tr>\r\n   </table>\r\n  ");
}
  else {
      out.write(' ');
      out.write("\r\n    <form method = \"post\" action = \"SurveyJSP.jsp\">\r\n      <p>What is your favorite pet?</p>\r\n      <p>\r\n        <input type = \"radio\" name = \"animal\"\r\n          value = \"1\" />Dog<br />\r\n        <input type = \"radio\" name = \"animal\"\r\n          value = \"2\" />Cat<br />\r\n        <input type = \"radio\" name = \"animal\"\r\n          value = \"3\" />Bird<br />\r\n        <input type = \"radio\" name = \"animal\"\r\n          value = \"4\" />Snake<br />\r\n        <input type = \"radio\" name = \"animal\"\r\n          value = \"5\" checked = \"checked\" />None\r\n      </p>\r\n\r\n      <p><input type = \"submit\" value = \"Submit\" /></p>\r\n\r\n    </form> ");
 //start scriptlet
  }
  statement.close();
  connection.close();
  
      out.write(' ');
      out.write("\r\n\r\n</body>\r\n</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
