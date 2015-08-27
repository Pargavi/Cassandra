package com.sample.nosql.pojo;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.stereotype.Component;

@Component
@Table(value = "users")
public class UserBO {
	
	/*
	Table Details 
	
	CREATE TABLE users (
            user_id varchar PRIMARY KEY,
            first varchar,
            last varchar,
            age int
          );
	*/
	
	@PrimaryKey
	@Column(value = "user_id")
	private String user_Id;

	@Column(value = "first")
	private String firstName;

	@Column(value = "last")
	private String lastName;

	@Column(value = "age")
	private int age;


	public String getUser_Id() {
		return user_Id;
	}



	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
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



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserPrivilege ["
				+ (user_Id != null ? "userId=" + user_Id + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (age != 0 ? "age=" + age + ", " : "0")
				+ "]";
	}


}
