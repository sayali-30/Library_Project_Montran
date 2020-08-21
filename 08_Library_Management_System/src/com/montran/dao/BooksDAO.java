package com.montran.dao;
import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.montran.pojo.BookIssuedBy;
import com.montran.pojo.Books;
import com.montran.pojo.Members;
import com.montran.util.SessionFactoryUtil;

public class BooksDAO {
	private Session session;
	private Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getFactory();

	List<BookIssuedBy> booksList = null;
	
	public List<BookIssuedBy> getAllEmployees()
	{
		session = factory.openSession();
		Query query = session.createQuery("from booksIssued order by issueSerialNo");
		//Query query = session.createQuery("from booksIssued");
		booksList = query.list();
		System.out.println(booksList);
		session.close();
		return booksList;
	}	
	
	public Books getBook(String bookCode) {
		session = SessionFactoryUtil.getFactory().openSession();
		Books book = session.get(Books.class, bookCode);
		System.out.println(book);
		session.close();
		return book;
	}

	public Members getMember(String memberCode) {
		session = SessionFactoryUtil.getFactory().openSession();
		Members member = session.get(Members.class, memberCode);
		System.out.println(member);
		session.close();
		return member;
	}
	
	public int getMaxIssueSerialNo() {
		session = SessionFactoryUtil.getFactory().openSession();
		Query query = session.createQuery("select max(issueSerialNo) from booksIssued");
		List<Integer> issueList = query.list();
		int maxCount = issueList.get(0);
		System.out.println("Total Books :: " + maxCount);
		session.close();

		return maxCount + 1;
	}
	
	public void addNewBook(BookIssuedBy bookIssued) 
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.save(bookIssued);
		transaction.commit();
		session.close();
	}
	
	public BookIssuedBy getIssuedBook(int issueSerialNo) {
		session = SessionFactoryUtil.getFactory().openSession();
		BookIssuedBy bookIssuedBy = session.get(BookIssuedBy.class, issueSerialNo);
		System.out.println(bookIssuedBy);
		session.close();
		return bookIssuedBy;
	}
	
	public void deleteIssuedBook(int issueSerialNo) 
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		BookIssuedBy bookIssuedBy = session.get(BookIssuedBy.class, issueSerialNo);
		session.delete(bookIssuedBy);
		transaction.commit();
		session.close();
	}
	
	public void updateIssuedBook1(int issueSerialNo, Date issueDate) 
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		BookIssuedBy bookIssuedBy = session.get(BookIssuedBy.class, issueSerialNo);
		bookIssuedBy.setDateOfIssue(issueDate);
		session.update(bookIssuedBy);
		transaction.commit();
		session.close();
	}

	public void updateIssuedBook2(int issueSerialNo, Date returnDate) 
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		BookIssuedBy bookIssuedBy = session.get(BookIssuedBy.class, issueSerialNo);
		bookIssuedBy.setDateOfReturn(returnDate);
		session.update(bookIssuedBy);
		transaction.commit();
		session.close();
	}

	public void updateIssuedBook(int issueSerialNo, Date issueDate, Date returnDate) 
	{
		session = factory.openSession();
		transaction = session.beginTransaction();
		BookIssuedBy bookIssuedBy = session.get(BookIssuedBy.class, issueSerialNo);
		bookIssuedBy.setDateOfIssue(issueDate);
		bookIssuedBy.setDateOfReturn(returnDate);
		session.update(bookIssuedBy);
		transaction.commit();
		session.close();
	}
}