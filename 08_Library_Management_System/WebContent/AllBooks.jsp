<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Books</title>
	</head>
	<body>
		<h3>List Of All Books</h3>
		<hr>
		<br><br>
		
		<table border="1" style="text-align:center">
			<tr>
				<th>Issue Serial Number</th>
				<th>Member Code</th>
				<th>Member Name</th>
				<th>Book Code</th>
				<th>Book Name</th>
				<th>Date of Issue</th>
				<th>Date of Return</th>
			</tr>
		
			<logic:iterate name="booksList" id="allBooks">
				<tr>
					<td><bean:write name="allBooks" property="issueSerialNo" /></td>
					<td><bean:write name="allBooks" property="members.memberCode" /></td>
					<td><bean:write name="allBooks" property="members.memberName" /></td>
					<td><bean:write name="allBooks" property="books.bookCode" /></td>
					<td><bean:write name="allBooks" property="books.bookTitle" /></td>
					<td><bean:write name="allBooks" property="dateOfIssue" /></td>
					<td><bean:write name="allBooks" property="dateOfReturn" /></td>
				</tr>
			</logic:iterate>
		</table>
		<br><br>
		
		<table style="text-align:center">
			<tr>
				<th>
					<form >
						<button type="submit" formaction="/08_Library_Management_System/issueBook.jsp">Issue New Book</button>
					</form>
				</th>
				<th>
					<form >
						<button type="submit" formaction="/08_Library_Management_System/updateIssuedBook.jsp">Update Issued Book</button>
					</form>
				</th>
				<th>
					<form >
						<button type="submit" formaction="/08_Library_Management_System/deleteIssuedBook.jsp">Delete Issued Book</button>
					</form>
				</th>
			</tr>
		</table>
	</body>
</html>
