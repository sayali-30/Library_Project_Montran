package com.montran.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class IssueNewBookForm extends ActionForm
{
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) 
	{
		ActionErrors errors = new ActionErrors();
		
		if (request.getParameter("member") != null) 
			if (request.getParameter("member").equals("Verify Member")) 
				if (getMemberCode() == null || getMemberCode().equals("")) 
					errors.add("common.name.err", new ActionMessage("error.common.name.requiredMemberCode"));
		
		if (request.getParameter("book") != null) 
			if (request.getParameter("member").equals("Verify Book")) 
				if (getBookCode() == null || getBookCode().equals("")) 
					errors.add("common.name.err", new ActionMessage("error.common.name.requiredBookCode"));

		if (request.getParameter("member") == null && request.getParameter("memberCode") != null)
			errors.add("common.name.err", new ActionMessage("error.common.name.member"));
		
		if (request.getParameter("book") == null && request.getParameter("bookCode") != null)
			errors.add("common.name.err", new ActionMessage("error.common.name.book"));
		
		if (request.getParameter("issued") != null) 
			if (request.getParameter("issued").equals("Get Details")) 
				if (getIssueSerialNo() == 0) 
					errors.add("common.name.err", new ActionMessage("error.common.name.requiredIssueSerialNo"));
		
		if (request.getParameter("updateVal") == null)
			errors.add("common.name.err", new ActionMessage("error.common.name.requiredUpdateVal"));
		
		if (request.getParameter("updateVal") != null)
			if (request.getParameter("updateVal").equals("Update Issue Date"))
				if (getNewDateOfIssue() == null || getNewDateOfIssue().equals("")) 
					errors.add("common.name.err", new ActionMessage("error.common.name.requiredDates"));
		
		if (request.getParameter("updateVal") != null)
			if (request.getParameter("updateVal").equals("Update Return Date"))
				if (getNewDateOfReturn() == null || getNewDateOfReturn().equals("")) 
					errors.add("common.name.err", new ActionMessage("error.common.name.requiredDates"));
		
		if (request.getParameter("updateVal") != null)
			if (request.getParameter("updateVal").equals("Update Both"))
				if (getNewDateOfIssue() == null || getNewDateOfIssue().equals("") || getNewDateOfReturn() == null || getNewDateOfReturn().equals("")) 
					errors.add("common.name.err", new ActionMessage("error.common.name.requiredDates"));
		
		return errors;
	}
	
	private int issueSerialNo;
	private String memberCode;
	private String memberName;
	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String dateOfIssue;
	private String dateOfReturn;
	private String updateVal;
	private String newDateOfIssue;
	private String newDateOfReturn;
	
	public int getIssueSerialNo() {
		return issueSerialNo;
	}
	public void setIssueSerialNo(int issueSerialNo) {
		this.issueSerialNo = issueSerialNo;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public String getDateOfReturn() {
		return dateOfReturn;
	}
	public void setDateOfReturn(String dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
	public String getUpdateVal() {
		return updateVal;
	}
	public void setUpdateVal(String updateVal) {
		this.updateVal = updateVal;
	}
	public String getNewDateOfIssue() {
		return newDateOfIssue;
	}
	public void setNewDateOfIssue(String newDateOfIssue) {
		this.newDateOfIssue = newDateOfIssue;
	}
	public String getNewDateOfReturn() {
		return newDateOfReturn;
	}
	public void setNewDateOfReturn(String newDateOfReturn) {
		this.newDateOfReturn = newDateOfReturn;
	}
	@Override
	public String toString() {
		return "IssueNewBookForm [issueSerialNo=" + issueSerialNo + ", memberCode=" + memberCode + ", memberName="
				+ memberName + ", bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", dateOfIssue=" + dateOfIssue + ", dateOfReturn=" + dateOfReturn + "]";
	}
}
