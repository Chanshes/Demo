package unit5;
//��5-2 �ж�����������ǷǸ������Ǹ���
import java.util.Scanner;

public class IfInput {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("����������: ");
		int number = scanner.nextInt();
		if(number >=  0)
			System.out.println("��������ǷǸ���");
		else
			System.out.println("��������Ǹ���");
	}
}