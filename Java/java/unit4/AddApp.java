package unit4;
//例4-12 AddApp.java的源代码。
import java.util.Scanner;

import unit4.addpack.IntegerAdd;

public class AddApp {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int a,b;
		IntegerAdd ia = new IntegerAdd();
		System.out.println("请输入进行加法的两个整数：");
		a = scanner.nextInt();
		b = scanner.nextInt();
		System.out.println("两个整数相加后的结果为:"+ia.addInt(a, b));
	}
}
