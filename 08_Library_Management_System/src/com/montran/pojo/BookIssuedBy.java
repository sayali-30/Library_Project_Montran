package com.montran.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity (name = "booksIssued")
public class BookIssuedBy 
{
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_issue_gen")
	//@SequenceGenerator(sequenceName = "issue_serial_no_seq", name = "book_issue_gen")
	@Column (name = "issue_serial_no")
	private int issueSerialNo;
	
	@Column (name = "date_of_issue")
	private Date dateOfIssue;
	
	@Column (name = "date_of_return")
	private Date dateOfReturn;	
	
	@OneToOne
	@JoinColumn (name = "book_code")
	private Books books;
	
	@OneToOne
	@JoinColumn (name = "member_code")
	private Members members;
	
	public BookIssuedBy() {
		// TODO Auto-generated constructor stub
	}	

	public BookIssuedBy(int issueSerialNo, Date dateOfIssue, Date dateOfReturn, Books books, Members members) {
		super();
		this.issueSerialNo = issueSerialNo;
		this.dateOfIssue = dateOfIssue;
		this.dateOfReturn = dateOfReturn;
		this.books = books;
		this.members = members;
	}


	public int getIssueSerialNo() {
		return issueSerialNo;
	}

	public void setIssueSerialNo(int issueSerialNo) {
		this.issueSerialNo = issueSerialNo;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "BookIssuedBy [issueSerialNo=" + issueSerialNo + ", dateOfIssue=" + dateOfIssue + ", dateOfReturn=" + dateOfReturn + ", books=" + books + ", members="
				+ members + "]";
	}
}
