package unit3;
//4
import java.util.Scanner;

public class Student {
	String name,Class;
	int yu;
	int shu;
	int wai;
	public Student(String name,String Class){
		this.name = name;
		this.Class = Class;
	}
	public void setyushuwai(int a, int b, int c){
		yu = a;
		shu = b;
		wai = c;
	}
	public int getsyu(){
		return  yu;
	}
	public int getshu(){
		return shu;
	}
	public int getwai(){
		return wai;
	}
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生姓名:");
		String name = sc.next();
		System.out.println("请输入班级:");
		String Class = sc.next();
		Student st = new Student(name,Class);
		System.out.println("语：");
		int yu = sc.nextInt();
		System.out.println("数：");
		int shu = sc.nextInt();
		System.out.println("外：");
		int wai = sc.nextInt();
		st.setyushuwai(yu,shu,wai);
		System.out.println("语文："+st.yu);
		System.out.println("数学："+st.shu);
		System.out.println("外："+st.wai);
	}
}
