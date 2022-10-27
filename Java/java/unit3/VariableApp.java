package unit3;
//例3-1 变量的定义和使用
public class VariableApp {
	public static void main(String[] args){
		String name = "Tom";
		char sex = '男';
		int age = 28;
		double salary = 6000;
		boolean isMarrage = false;
		System.out.println("姓名\t性别\t年龄\t薪水\t已婚");
		System.out.printf("%4s\t%4c\t%4d\t%4.2f\t%4b", name, sex, age, salary, isMarrage);
	}

}
