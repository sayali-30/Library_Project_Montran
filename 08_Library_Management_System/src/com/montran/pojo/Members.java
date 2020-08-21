package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "members")
public class Members 
{
	@Id
	@Column (name = "member_code")
	private String memberCode;
	
	@Column (name = "member_name")
	private String memberName;
	
	@Column (name = "member_type")
	private String memberType;
	
	@Column (name = "no_of_books_issued")
	private int noOfBooksIssued;
	
	public Members() {
		// TODO Auto-generated constructor stub
	}

	public Members(String memberCode, String memberName, String memberType) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.memberType = memberType;
	}
	
	public Members(String memberCode, String memberName, String memberType, int noOfBooksIssued) {
		super();
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.memberType = memberType;
		this.noOfBooksIssued = noOfBooksIssued;
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

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getNoOfBooksIssued() {
		return noOfBooksIssued;
	}

	public void setNoOfBooksIssued(int noOfBooksIssued) {
		this.noOfBooksIssued = noOfBooksIssued;
	}

	@Override
	public String toString() {
		return "Members [memberCode=" + memberCode + ", memberName=" + memberName + ", memberType=" + memberType
				+ ", noOfBooksIssued=" + noOfBooksIssued + "]";
	}
}


