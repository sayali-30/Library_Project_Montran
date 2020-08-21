<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Books</title>
</head>
<body>
	<h3>Issue New Book</h3>
	<hr>
	
	<html:form action="issueNewBookAction" method="post">
		<table>
			<%! String msg1, msg2; %>
			<tr>
				<td></td>
				<td><html:submit property="serialNo" value="Get Serial No."></html:submit></td>
			</tr>
			<tr>
				<td>Issue Serial No : </td>
				<td><html:text property="issueSerialNo" size="20" maxlength="20"></html:text></td>
			</tr>
			<tr>
				<td>Member Code : </td>
				<td><html:text property="memberCode" size="20" maxlength="20"></html:text></td>
				<td><html:submit property="member" value="Verify Member"></html:submit></td>
			</tr>
			<tr>
				<td>Member Name : </td>
				<td><html:text property="memberName"></html:text></td>
				<td></td>
				<td><% if (request.getAttribute("msg1") != null)
						{
							msg1 = request.getAttribute("msg1").toString();%>
							<%= msg1 %>
					<% 	} %>
					</td>
			</tr>
			<tr>
				<td>Book code : </td>
				<td><html:text property="bookCode" size="20" maxlength="20"></html:text></td>
				<td><html:submit property="book" value="Verify Book"></html:submit></td>
			</tr>
			<tr>
				<td>Book Title : </td>
				<td><html:text property="bookTitle"></html:text></td>
				<td></td>
				<td><% if (request.getAttribute("msg2") != null)
						{
							msg2 = request.getAttribute("msg2").toString(); %>
							<%= msg2 %>
					<%	} %>
					</td>
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
			<tr>
				<td></td>
				<td><html:submit property="issue" value="Issue Book"></html:submit></td>
			</tr>
			
			<div style="color: red">
				<html:errors />
			</div>	
		</table>
	</html:form>
</body>
</html>
