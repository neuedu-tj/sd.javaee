package com.model;

public class Users {
	
	private int uid;
	private String uname;
	private String pwd;
	
	public Users() {}
	
	
	
	public Users(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd = pwd;
	}



	public Users(int uid, String uname, String pwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	
	
	
	
	

}
