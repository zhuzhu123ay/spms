package com.huihui.spms.bean;

public class Staff {

	//私有属性
	private Long id;
	private String username;
	private String password;
	private String gender;
	private Integer age;
	
	//构造
	public Staff(){
		
	}

	//公共的setter,getter
	public Staff(Long id, String username, String password, String gender, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", username=" + username + ", password=" + password + ", gender=" + gender + ", age="
				+ age + "]";
	}
	
	
	
}
