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
		System.out.println("������ѧ������:");
		String name = sc.next();
		System.out.println("������༶:");
		String Class = sc.next();
		Student st = new Student(name,Class);
		System.out.println("�");
		int yu = sc.nextInt();
		System.out.println("����");
		int shu = sc.nextInt();
		System.out.println("�⣺");
		int wai = sc.nextInt();
		st.setyushuwai(yu,shu,wai);
		System.out.println("���ģ�"+st.yu);
		System.out.println("��ѧ��"+st.shu);
		System.out.println("�⣺"+st.wai);
	}
}
