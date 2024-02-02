<html >
<head>
<title>Survey</title>
</head>

<!jsp:useBean id="survey" scope="session" class="surveys"/>

<body>
<%
     String name=request.getparameter("animal");
     if(name !=null){
	survey.addVote(Integer.parseInt(name));
	survey.getAll();
	int i=0;
	for(i=0;i<survey.names.length;i++)
	{
%>
		<%=survey.names[i]%> : <%=survey.v[i]%> % responses: <%=survey.vot[i]%> votes.<br/>
	
<%

     	} //end for
%>
	Total response: <%=survey.total%>
<%
     }
     else{
%>
		<form method = "post" action="survey.jsp">

		<p>What is your favorite pet?</p>

		<p>
		<input type = "radio" name = "animal" value = "1" />Dog<br />
		<input type = "radio" name = "animal" value = "2" />Cat<br />
		<input type = "radio" name = "animal" value = "3" />Bird<br />
		<input type = "radio" name = "animal" value = "4" />Snake<br />
		<input type = "radio" name = "animal" value = "5" checked = "checked" />
		None
		</p>

		<p><input type = "submit" value = "Submit" /></p>

		</form>
<%
	}
%>
</body>
</html>
