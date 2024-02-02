<%@page import="java.sql.*"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*" %>
<html>
<head>
<title>
myJSP
</title>
</head>
<body bgcolor="#ffffff">
  <%
  //The driver for microsoft databases
  String JDBC_DRIVER="sun.jdbc.odbc.JdbcOdbcDriver";
  //the path of the database Access file
  String path="C:\\animals.mdb";
  //the URL used to connect with the database
  String DATABASE_URL=
      "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path;

  String choice=request.getParameter("animal");

  DecimalFormat twoDigits=new DecimalFormat("0.00");

  //Load the database driver
  Class.forName(JDBC_DRIVER);

  //Get a connection to the database by sending its path
  Connection connection=DriverManager.getConnection(DATABASE_URL);

  //Create a statement to be able to execute query through it
  Statement stmt=connection.createStatement();

  //Define the string that will contain the query
  String query;
  int value,total;

if(choice != null){
    value=Integer.parseInt(choice);
    query="update animal set vote=vote+1 where id= " +value;
    stmt.executeUpdate(query);
    ResultSet rs,totrs;
    query="select sum(vote) from animal";
    totrs=stmt.executeQuery(query);
    totrs.next();
    total=totrs.getInt(1);
    query="select option,vote from animal order by vote";
    rs=stmt.executeQuery(query);
    while(rs.next())
    {%>
    <table width=400>
      <tr>
        <td width=50%><h1> <%=rs.getString(1)%></h1></td>
        <td width=50%><h1> <%=twoDigits.format((float)rs.getInt(2)/(float)total)%></h1> </td>
      </tr>
    </table>
    <% }
  }
  else {%>
    <form method = "post" action = "myJSP.jsp">
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
    </form> <%
  }%>

</body>
</html>
