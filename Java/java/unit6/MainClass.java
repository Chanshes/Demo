package unit6;
//��6-1 �̳й�ϵ������͸��ඨ��
class Employee{
	public String name;
	char gender;
	int age;
	private double salary;
	//���췽��
	public Employee(){
		name = "Tom";
		gender = '��';
	}
	public Employee(String n, char g, int a, double s){
		name = n;
		gender = g;
		age = a;
		salary = s;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double a){
		salary = a;
	}
}
class Teacher extends Employee{
	String speciality;//רҵ
	//���췽��
	public Teacher(){
		speciality = "Computer Science";
	}
	public Teacher(String n,char g, int a,double s, String spe){
		name = n;
		gender = g;
		age = a;
		setSalary(s);
		speciality = spe;
	}
	public String getSpeciality(){
		return speciality;
	}
	public void setSpeciality(String s){
		speciality = s;
	}
}
public class MainClass {
	public static void main(String[] args) {
		Teacher t = new Teacher("zhangsan",'��',30,8000.0,"�����");
		System.out.println("t.name="+t.name+";t.gender="+t.gender+";t.age="+t.age+";t.salary="+t.getSalary()+";t.Speciality="+t.speciality);
	}

}
