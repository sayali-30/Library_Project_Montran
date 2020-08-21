<%@page import="java.io.PrintWriter"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
</head>
<body>
	<h3>Update Issued Book</h3>
	<hr>
	
	<html:form action="updateIssuedBookAction" method="post">
		<table>
			<tr>
				<td><h4>Choose One : </h4></td>
			</tr>
			<tr>
				<td><html:radio property="updateVal" value="Update Issue Date"/>Update Issue Date
				<td><html:radio property="updateVal" value="Update Return Date"/>Update Return Date</td><td>
				<td><html:radio property="updateVal" value="Update Both"/>Update Both</td>
			</tr>
			<tr>
				<td><hr></td>
			</tr>
			<tr>
				<td>Enter Issue Serial No. to Update : </td>
				<td><html:text property="issueSerialNo" size="20" maxlength="20"></html:text></td>
				<td><html:submit property="issued" value="Get Details"></html:submit></td>
			</tr>
			<tr>
				<td><h4>Issued Book Details :- </h4><hr></td>
			</tr>
			<tr>
				<td>Member Code : </td>
				<td><html:text property="memberCode"></html:text></td>
			</tr>
			<tr>
				<td>Member Name : </td>
				<td><html:text property="memberName"></html:text></td>
				<td></td>
			</tr>
			<tr>
				<td>Book code : </td>
				<td><html:text property="bookCode"></html:text></td>
			</tr>
			<tr>
				<td>Book Title : </td>
				<td><html:text property="bookTitle"></html:text></td>
				<td></td>
			</tr>
			<tr>
				<td>Book Author : </td>
				<td><html:text property="bookAuthor"></html:text></td>
				<td></td>
			</tr>
			<tr>
				<td>Issue Date : </td>
				<td><html:text property="dateOfIssue" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Return Date : </td>
				<td><html:text property="dateOfReturn" /></td>
				<td></td>
			</tr>
		</table>
		<br><br>
		
		<% 	if(request.getParameter("updateVal") != null && request.getParameter("updateVal").equals("Update Issue Date"))
			{ %>
				<table>
					<tr>
						<td><h5>Enter New Issue Date : </h5></td>
						<td><html:text property="newDateOfIssue" /></td>
						<td></td>
					</tr>
				</table>
		<% 	} 
			else if(request.getParameter("updateVal") != null && request.getParameter("updateVal").equals("Update Return Date"))
			{ %>
				<table>
					<tr>
						<td><h5>Enter New Return Date : </h5></td>
						<td><html:text property="newDateOfReturn" /></td>
						<td></td>
					</tr>
				</table>
				
		<% 	} 
			else if(request.getParameter("updateVal") != null && request.getParameter("updateVal").equals("Update Both"))
			{ %>
				<table>
					<tr>
						<td><h5>Enter New Issue Date : </h5></td>
						<td><html:text property="newDateOfIssue" /></td>
					</tr>
					<tr>
						<td><h5>Enter New Return Date : </h5></td>
						<td><html:text property="newDateOfReturn" /></td>
						<td></td>
					</tr>
				</table>
				
		<% 	} 
			System.out.println(request.getParameter("updateVal"));%>
			<table>
				<tr>
						<td></td>
						<td><html:submit property="update" value="Update Issue Details"></html:submit></td>
					</tr>
			</table>
			
			<div style="color: red">
				<html:errors />
			</div>	
	</html:form>
</body>
</html>
