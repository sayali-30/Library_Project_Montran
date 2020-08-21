package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BooksDAO;
import com.montran.pojo.BookIssuedBy;

public class BooksListAction extends Action
{
	List<BookIssuedBy> booksList = null;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		BooksDAO dao = new BooksDAO();
		booksList = dao.getAllEmployees();
		
		request.setAttribute("booksList", booksList);
		return mapping.findForward("success");
	}
}
