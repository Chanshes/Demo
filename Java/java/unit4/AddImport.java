package unit4;
//��4-13 ʹ��import���װ��IntegerAdd�ࡣ
import java.util.Scanner;

import unit4.addpack.IntegerAdd;

public class AddImport {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int a, b;
		IntegerAdd ia = new IntegerAdd();
		System.out.println("��������мӷ�������������");
		a = scanner.nextInt();
		b = scanner.nextInt();
		System.out.println("����������Ӻ�Ľ��Ϊ��"+ia.addInt(a,b));
	}
}
