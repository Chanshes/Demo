package unit3;
//1.
public class Person {
	private int height,weight,age;
	private char sex;
	private String name;
	public Person(int height, int weight,char sex, String name, int age){
		this.height = height;
		this.weight = weight;
		this.sex = sex;
		this.name = name;
		this.age = age;
	}
	
	int getHeight(){
		return this.height;
	}
	
	int getWeight(){
		return this.weight;
	}
	
	int getAge(){
		return this.age;
	}
	
	char getSex(){
		return this.sex;
	}
	
	String getName(){
		return this.name;
	}
	void house(){
		System.out.println("^_^ <- this is my house");
	}
	
	public static void main(String[] args){
		Person human = new Person(170,60,'男',"星辰",18);
		human.house();
		String name = human.getName();
		char sex = human.getSex();
		int height = human.getHeight();
		int weight = human.getWeight();
		int age = human.getAge();
		System.out.println("姓名:"+name);
		System.out.println("性别:"+sex);
		System.out.println("年龄："+age+"岁");
		System.out.println("身高："+height+"cm");
		System.out.println("体重："+weight+"kg");
		
	}
}