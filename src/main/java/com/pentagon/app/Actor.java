package com.pentagon.app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="actor_table2")
public class Actor {
	@Id
	@GeneratedValue
	@Column(name="a_id")
	private long id;
	@Column(name="a_name")
	private String name;
	@Column(name="a_gender")
	private String gender;
	@Column(name="a_dob")
	private String dob;
	@Column(name="a_fd")
	private String fd;
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getFd() {
		return fd;
	}
	public void setFd(String fd) {
		this.fd = fd;
	}
	public Actor(String name, String gender, String dob, String fd) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.fd = fd;
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", fd=" + fd + "]";
	}
	

}
