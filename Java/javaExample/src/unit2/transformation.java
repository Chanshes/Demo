package unit2;
//5
import java.util.Scanner;

public class transformation {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int a;
		byte c;
		System.out.println("请输入一个整数:");
		int i = scanner.nextInt();
		System.out.println("请输入一个小数:");
		double x = scanner.nextDouble();
		c = (byte)i;
		System.out.println(c);
		a = (int)x;
		System.out.println(a);
		
	}
}
