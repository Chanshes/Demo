package unit2;
//5
import java.util.Scanner;

public class transformation {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int a;
		byte c;
		System.out.println("������һ������:");
		int i = scanner.nextInt();
		System.out.println("������һ��С��:");
		double x = scanner.nextDouble();
		c = (byte)i;
		System.out.println(c);
		a = (int)x;
		System.out.println(a);
		
	}
}
