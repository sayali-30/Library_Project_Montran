package com.montran.action;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BooksDAO;
import com.montran.form.IssueNewBookForm;
import com.montran.pojo.BookIssuedBy;
import com.montran.pojo.Books;
import com.montran.pojo.Members;

public class IssueBookAction extends Action
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		IssueNewBookForm form2 = (IssueNewBookForm) form;
		BooksDAO dao = new BooksDAO();
		Books book = null;
		Members member = null;
		BookIssuedBy bookIssued = null;
		HttpSession httpSession = request.getSession();
		String msg1="", msg2="";
						
		System.out.println("\nIssueBookForm object  -------------- is set");
		
		if (request.getParameter("serialNo") != null) 
		{
			if (request.getParameter("serialNo").equals("Get Serial No.")) 
			{
				form2.setIssueSerialNo(dao.getMaxIssueSerialNo());
				return mapping.findForward("serialNo");
			}
		}
				
		if (request.getParameter("member") != null) 
		{
			if (request.getParameter("member").equals("Verify Member")) 
			{
				member = dao.getMember(form2.getMemberCode());
				form2.setMemberName(member.getMemberName());		
				httpSession.setAttribute("member", member);
				//System.out.println(member);
				//System.out.println(httpSession.getAttribute("member"));
				return mapping.findForward("member");
			}
		}
		
		if (request.getParameter("book") != null) 
		{
			if (request.getParameter("book").equals("Verify Book")) 
			{
				book = dao.getBook(form2.getBookCode());
				form2.setBookTitle(book.getBookTitle());
				form2.setBookAuthor(book.getBookAuthor());
				httpSession.setAttribute("book", book);
				//System.out.println(book);
				//System.out.println(httpSession.getAttribute("book"));

				LocalDate dateOfIssue = LocalDate.now();
				form2.setDateOfIssue(dateOfIssue.toString());
				httpSession.setAttribute("dateOfIssue", dateOfIssue);
				
				LocalDate dateOfReturn = LocalDate.now();
				
				member = (Members)httpSession.getAttribute("member");
				System.out.println(member);
				
				if (member.getMemberType().equals("Student")) 
					dateOfReturn = dateOfReturn.plusDays(10);
					
				if (member.getMemberType().equals("Faculty")) 
					dateOfReturn = dateOfReturn.plusDays(90);
				
				form2.setDateOfReturn(dateOfReturn.toString());
				httpSession.setAttribute("dateOfReturn", dateOfReturn);
				
				System.out.println(dateOfIssue.toString());
				System.out.println(dateOfReturn.toString());
											
				return mapping.findForward("book");
			}
		}
		
		if (request.getParameter("issue") != null) 
		{
			if (request.getParameter("issue").equals("Issue Book")) 
			{
				LocalDate dateOfIssue = null;						
				LocalDate dateOfReturn = null;
				
				if (httpSession.getAttribute("book") != null)
					book = (Books) httpSession.getAttribute("book");
				
				if (httpSession.getAttribute("member") != null)
					member = (Members) httpSession.getAttribute("member");
				
				if (httpSession.getAttribute("dateOfIssue") != null)
					dateOfIssue = (LocalDate) httpSession.getAttribute("dateOfIssue");
				
				if (httpSession.getAttribute("dateOfReturn") != null)
					dateOfReturn = (LocalDate) httpSession.getAttribute("dateOfReturn");

				Date issueDate = Date.from(dateOfIssue.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date returnDate = Date.from(dateOfReturn.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				member = (Members)httpSession.getAttribute("member");
				book = (Books)httpSession.getAttribute("book");
				
				if((member.getMemberType().equals("Student") && member.getNoOfBooksIssued()<=3) || (member.getMemberType().equals("Faculty") && member.getNoOfBooksIssued()<=25))
				{
					if(book.getIsIssuable() == 1 && book.getIssueStatus().equals("Not Issued"))
					{
						member = (Members)httpSession.getAttribute("member");
						book = (Books)httpSession.getAttribute("book");
						
						member.setNoOfBooksIssued(member.getNoOfBooksIssued()+1);
						book.setIssueStatus("Issued");
						
						bookIssued = new BookIssuedBy(form2.getIssueSerialNo(), issueDate, returnDate, book, member);
						dao.addNewBook(bookIssued);
						System.out.println(bookIssued);
						System.out.println("Book Issued Successfully !!!!!!!!!!!!!!!!!!");	
					}
					else
					{
						msg2="Book is Not Issuable or Already Issued..!!";
						request.setAttribute("msg2", msg2);
					}
				}
				else
				{
					msg1="Maximum Book Issue Count exceeded ..!!";
					request.setAttribute("msg1", msg1);
				}
			}
		}
		
		form2.reset(mapping, request);
		return mapping.findForward("success");
	}
}
