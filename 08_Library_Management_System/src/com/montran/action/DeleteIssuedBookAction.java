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

public class DeleteIssuedBookAction extends Action
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		IssueNewBookForm form2 = (IssueNewBookForm) form;
		BooksDAO dao = new BooksDAO();
		BookIssuedBy bookIssuedBy = new BookIssuedBy();
		Books book = new Books();
		Members member = new Members();
		HttpSession httpSession = request.getSession();
		
		if (request.getParameter("issued") != null) 
		{
			if (request.getParameter("issued").equals("Get Details")) 
			{
				bookIssuedBy = dao.getIssuedBook(form2.getIssueSerialNo());
				book = bookIssuedBy.getBooks();
				member = bookIssuedBy.getMembers();
				form2.setMemberCode(member.getMemberCode());
				form2.setMemberName(member.getMemberName());
				form2.setBookCode(book.getBookCode());
				form2.setBookTitle(book.getBookTitle());
				form2.setBookAuthor(book.getBookAuthor());
				form2.setDateOfIssue(bookIssuedBy.getDateOfIssue().toString());
				form2.setDateOfReturn(bookIssuedBy.getDateOfReturn().toString());
				
				//httpSession.setAttribute("issueSerialNo", form2.getIssueSerialNo());
				return mapping.findForward("issued");
			}
		}
		
		if (request.getParameter("delete") != null) 
		{
			if (request.getParameter("delete").equals("Delete Issued Book")) 
			{
				dao.deleteIssuedBook(form2.getIssueSerialNo());
				System.out.println("Book Deleted Successfully !!!!!");
			}
		}
		form2.reset(mapping, request);
		return mapping.findForward("success");
	}
}
