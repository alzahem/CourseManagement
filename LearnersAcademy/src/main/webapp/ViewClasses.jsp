<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome to my display page</title>
</head>
<body>


	<%

try
{
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/School", "root", "");
	String sql = "select class, subject,student,teacher from classes";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	if(rs.next()==false)
	{
		out.println("No record found in table");
	}
	else
	{%>
	<table>
		<tr>
			<th>Class</th>
			<th>Subject</th>
			<th>student</th>
			<th>teacher</th>
		</tr>
			<%
		 do 
		 {%>
		
		<tr>
			<td><%= rs.getString(1) %></td>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %></td>
		</tr>
		<%
		 	
		  } while(rs.next());

		}
}
	catch(Exception e)
		
{
    System.out.println(e.getMessage());
    e.getStackTrace();
}
	
%>

</table>
</body>
</html>