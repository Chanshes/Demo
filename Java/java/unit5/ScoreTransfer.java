package unit5;
//��5-3 ���ɼ��ɰٷ���ת��Ϊ�ȼ���
import java.util.Scanner;

public class ScoreTransfer {
	public static void main(String[]  args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("�������: ");
		int score = scanner.nextInt();
		if(score >= 90)
			System.out.println("����");
		else if(score >= 80)
			System.out.println("����");
		else if(score >= 70)
			System.out.println("�е�");
		else if(score >= 60)
			System.out.println("����");
		else
			System.out.println("������");
	}
}
