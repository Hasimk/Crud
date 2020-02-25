<%@page import="com.bean.LoginBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.LoginDao"%>
<%@page import="com.daoimpl.LoginDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>


<script type="text/javascript">
function edit(id,name,mobile){

	document.getElementById('id').value = id;
	document.getElementById('name').value=name;
	document.getElementById('mobile').value=mobile;
	document.getElementById('btname').innerHTML = "Update";
	document.getElementById('btname').value = 'update';
	document.getElementById('id').readOnly =true;
	
}



</script>
</head>
<body>


	<form action="LoginController" method="post">
		<table align="center" border="1" cellpadding="2" cellspacing="0"
			style="margin-top: 10%">
			<tr>
				<td colspan="2" bgcolor="black"
					style="color: white; text-align: center;">Add Employees</td>
			</tr>
			<tr>
				<td>User Id</td>
				<td><input type="text" id="id"  name="id"></td>

			</tr>

			<tr>
				<td>User name</td>
				<td><input type="text" id="name" name="name"></td>

			</tr>

			<tr>
				<td>MobileNo</td>
				<td><input type="text" id="mobile"  name="mobile"></td>

			</tr>
			<tr>

				<td></td>
				<td><input type="submit" name="btname" id="btname"value="login"></td>
			</tr>


		</table>

	</form>
	
	<table align="center">
	<th>UserId</th>
	<th>UserName</th>
	<th>UserMobileNo</th>
	<th>action</th>
	
	<%LoginDaoImpl dao=new LoginDaoImpl();
	
	List list= dao.fetch();
	
	Iterator itr =list.iterator();
	while(itr.hasNext()) {
		
		
		LoginBean bean = (LoginBean) itr.next();
			
	
%>	
	<tr>
	<td><%=bean.getId() %></td>
	<td><%=bean.getName() %></td>
	<td><%=bean.getMobile() %></td>
	
	<td><a href="#" onclick="edit(<%=bean.getId() %>,'<%=bean.getName() %>','<%=bean.getMobile() %>')">Edit</a></td>
	<td><a href="LoginController?id=<%=bean.getId() %>">Delete</a></td>
				
	
	</tr>
	
	
	<% }   %>
		</table>
	
	
	
	

</body>
</html>