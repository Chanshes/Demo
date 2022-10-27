package unit6;
//例6-7
class Human{
	String name;
	int age;
	char sex;
	Human(String name,int age, char sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	int getAge(){
		return age;
	}
}
class Worker extends Human{
	double salary;
	Worker(String name, int age,char sex,double salary){
		super(name,age,sex);
		this.salary = salary;
	}
	void addSalary(double sum){
		salary += sum;
	}
}
public class TextCasting {

	public static void main(String[] args) {
		Worker a = new Worker("Marry",20,'女',10000);
		Human h = a;
		System.out.println(h.name+"的年龄为"+h.age);
	}

}