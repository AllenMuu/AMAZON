package com.amazon.bin;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String sex;
	private String birthday;
	private String identity;
	private String email;
	private String mobile;
	private String address;
	private String status;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public User() {
		super();
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password, String email, String mobile) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}
	public User(String userName, String password, String sex, String birthday, String identity, String email,
			String mobile, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.identity = identity;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", sex=" + sex
				+ ", birthday=" + birthday + ", identity=" + identity + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + ", status=" + status + "]";
	}
	
	
}
