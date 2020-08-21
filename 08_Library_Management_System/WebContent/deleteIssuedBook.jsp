<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Book</title>
</head>
<body>
	<h3>Delete Issued Book</h3>
	<hr>
	
	<html:form action="deleteIssuedBookAction" method="post">
		<table>
			<tr>
				<td>Enter Issue Serial No. to delete : </td>
				<td><html:text property="issueSerialNo" size="20" maxlength="20"></html:text></td>
				<td><html:submit property="issued" value="Get Details">Get Issued Book Details</html:submit></td>
			</tr>
			<tr>
				<td><h4>Issued Book Details are as follows : </h4><hr></td>
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
			
			<tr>
				<td></td>
				<td><html:submit property="delete" value="Delete Issued Book"></html:submit></td>
			</tr>
			
			<div style="color: red">
				<html:errors />
			</div>	
		</table>
	</html:form>
</body>
</html>
