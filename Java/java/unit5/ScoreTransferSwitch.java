package unit5;
//��5-4 ѧ���ɼ��ĸ�ʽת����
import java.util.Scanner;

public class ScoreTransferSwitch {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("���������(0-100):");
		int score = scanner.nextInt();
		int level = (int)score/10;
		if(score>100 || score <0)
			System.out.println("������ĳɼ��Ƿ�!");
		else{ //����ɼ��Ϸ�
			System.out.print("�ɼ�Ϊ");
			switch(level){
			case 10:
			case 9:
				System.out.println("����");
				break;
			case 8:
				System.out.println("����");
				break;
			case 7:
				System.out.println("�е�");
				break;
			case 6:
				System.out.println("����");
				break;
			default:
				System.out.println("������");
			}
		}
	}
}
