package pojo;

import java.sql.Date;
import java.util.Objects;

public class User {
	
	// id | first_name | last_name | email_id       | password | reg_amt | reg_date   | role
	
	private int id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private double regAmt;
	private Date regDate;
	private String role;
	
	
	public User(int id, String firstName, String lastName, String emailId, String password, double regAmt, Date regDate,
			String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.regAmt = regAmt;
		this.regDate = regDate;
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", password=" + password + ", regAmt=" + regAmt + ", regDate=" + regDate + ", role=" + role + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getRegAmt() {
		return regAmt;
	}


	public void setRegAmt(double regAmt) {
		this.regAmt = regAmt;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	


}
