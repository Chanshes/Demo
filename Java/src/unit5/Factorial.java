package unit5;
//��5-10 ����׳ˡ�
import java.util.Scanner;
public class Factorial {
	//�����number�Ľ׳�
	public static int factorial(int n){
		int result = 1;
		for(int i = 1; i <= n; i++)
			result = result * i;
		return result;
	}
	public static void main(String[] args){
		int number;
		//�Ӽ��̽�����������
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ��������:");
		number = scanner.nextInt();
		System.out.println(number+"�Ľ׳�Ϊ��"+factorial(number));
	}
}
