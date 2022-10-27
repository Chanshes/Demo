package unit4;
//1
import java.util.Scanner;

public class Ifelse {
	public static void main(String[] args){
		int a,b;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		a = 10;
		b = sc.nextInt();
		if(b > a || b < a)
			System.out.println("Êä³ö´íÎó");
		else
			System.out.println("hello.if");
	}
}
