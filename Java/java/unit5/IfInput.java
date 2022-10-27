package unit5;
//例5-2 判断输入的整数是非负数还是负数
import java.util.Scanner;

public class IfInput {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入整数: ");
		int number = scanner.nextInt();
		if(number >=  0)
			System.out.println("你输入的是非负数");
		else
			System.out.println("您输入的是负数");
	}
}