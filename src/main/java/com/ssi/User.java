package com.ssi;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id 
	@GeneratedValue
	private int userId;
	private String userName;
	private Date birthDate;
	private Blob userPic;
	public User(String userName,  Blob userPic) {
		super();
		this.userName = userName;
		this.userPic = userPic;
	}
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Blob getUserPic() {
		return userPic;
	}
	public void setUserPic(Blob userPic) {
		this.userPic = userPic;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userPic=" + userPic + "]";
	}
	
}
