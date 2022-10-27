package unit4;
//例4-15 私有域的使用
class Person{
	private String name;  //姓名
	private int sex;      //性别
	private int age;      //年龄
	
	public Person(String name, String sex, int age){
		this.name = name;
		this.age = age;
		setSex(sex);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getSex(){
		if (sex == 0)
			return "男";
		else
			return "女";
	}
	public void setSex(String sex){
		if(sex.equals("男"))
			this.sex = 0;
		else if(sex.equals("女"))
			this.sex = 1;
	}
}

public class PersonApp {
	public static void main(String[] args){
		Person p = new Person("luise","男",18);
		//System.out.println("姓名为: "+p.name);//错误
		//直接通过p.name获取对象p的私有域name的值 不能直接访问
		System.out.println("姓名为："+p.getName());
		p.setAge(20);
	}
}
