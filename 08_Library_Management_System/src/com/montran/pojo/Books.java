package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "books")
public class Books 
{
	@Id
	@Column (name = "book_code")
	private String bookCode;
	
	@Column (name = "book_title")
	private String bookTitle;
	
	@Column (name = "book_author")
	private String bookAuthor;
	
	@Column (name = "issue_status")
	private String issueStatus;
	
	@Column (name = "is_issuable")
	private int isIssuable;
	
	public Books() {
		// TODO Auto-generated constructor stub
	}

	public Books(String bookCode, String bookTitle, String bookAuthor) {
		super();
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
	}
	
	public Books(String bookCode, String bookTitle, String bookAuthor, String issueStatus, int isIssuable) {
		super();
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.issueStatus = issueStatus;
		this.isIssuable = isIssuable;
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

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public int getIsIssuable() {
		return isIssuable;
	}

	public void setIsIssuable(int isIssuable) {
		this.isIssuable = isIssuable;
	}

	@Override
	public String toString() {
		return "Books [bookCode=" + bookCode + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", issueStatus=" + issueStatus + ", isIssuable=" + isIssuable + "]";
	}	
}
