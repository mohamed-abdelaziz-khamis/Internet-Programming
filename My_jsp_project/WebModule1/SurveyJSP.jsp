<%--A web-based survey that uses JDBC from a JSP--%>
<%@ page import="java.sql.*"  %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>

<html>
<head>
<title>
SurveyJSP
</title>
</head>
<body bgcolor="#00ffff">
<% //begin scriptlet

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
   %> <%--end scriptlet; insert fixed template data--%>
   <p>Thank you for participating.<br/> Results: </p>
   <table>
   <% //start scriptlet
    int votes;
    while(resultsRS.next()) {
   %> <%--end scriptlet; insert fixed template data--%>

      <tr>
        <td><%=resultsRS.getString(1)%></td>
        <td><p>:</p></td>
        <%votes=resultsRS.getInt(2);%>
        <td><%=twoDigits.format((double)votes/total*100)%></td>
        <td><p>%  responses:</p></td>
        <td><%=votes%></td>
      </tr>
    <% }%>
   <tr>
     <td><p>Total responses: </p></td>
     <td><%=total%></td>
   </tr>
   </table>
  <%}
  else {%> <%--end scriptlet; insert fixed template data--%>
    <form method = "post" action = "SurveyJSP.jsp">
      <p>What is your favorite pet?</p>
      <p>
        <input type = "radio" name = "animal"
          value = "1" />Dog<br />
        <input type = "radio" name = "animal"
          value = "2" />Cat<br />
        <input type = "radio" name = "animal"
          value = "3" />Bird<br />
        <input type = "radio" name = "animal"
          value = "4" />Snake<br />
        <input type = "radio" name = "animal"
          value = "5" checked = "checked" />None
      </p>

      <p><input type = "submit" value = "Submit" /></p>

    </form> <% //start scriptlet
  }
  statement.close();
  connection.close();
  %> <%--end scriptlet; insert fixed template data--%>

</body>
</html>
