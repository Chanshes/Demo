package unit3;
//例3-2 基本数据类型变量的性质
public class PrimitiveDataType {
	public static void main(String[] args){
		int t;
		int age =28;
		t = age;
		System.out.println("将变量age赋值给变量t后，");
		System.out.println("t="+t+",age="+age);
		t = 40;
		System.out.println("将变量t的值改变后，");
		System.out.println("t="+t+",age="+age);
	}

}
