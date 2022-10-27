package customize;

import java.io.Serializable;

public class Base implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 学号
	 */
	private  String id;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 年龄
	 */
	private String age;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 学院
	 */
	private String sdept;
	
	/**
	 * 班级
	 */
	private String school;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getAge(){
		return age;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	
	public String getSex(){
		return sex;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public String getSdept(){
		return sdept;
	}
	
	public void setSdept(String sdept){
		this.sdept = sdept;
	}
	
	public String getSchool(){
		return school;
	}
	
	public void setSchool(String school){
		this.school = school;
	}
	
	public Base(){}
	
	public Base(String id, String name, String age, String sex, String sdept, String school){
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.sdept = sdept;
		this.school = school;
	}
	
	public String toString(){
		return "Base [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", sdept=" + sdept +", school="+ school + "]";
	}
}
