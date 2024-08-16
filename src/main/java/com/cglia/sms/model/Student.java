package com.cglia.sms.model;

public class Student {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private Long mobile_no;
	private String gender;
	private String dept;
	
	public Student(Integer id, String firstname, String lastname, String email, Long mobile_no, String gender,
			String dept) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile_no = mobile_no;
		this.gender = gender;
		this.dept = dept;
	}
	public void setId(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", mobile_no=" + mobile_no + ", gender=" + gender + ", dept=" + dept + "]";
	}

}
