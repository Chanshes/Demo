package unit5;
//例5-10 计算阶乘。
import java.util.Scanner;
public class Factorial {
	//求变量number的阶乘
	public static int factorial(int n){
		int result = 1;
		for(int i = 1; i <= n; i++)
			result = result * i;
		return result;
	}
	public static void main(String[] args){
		int number;
		//从键盘接收整数输入
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个正整数:");
		number = scanner.nextInt();
		System.out.println(number+"的阶乘为："+factorial(number));
	}
}
