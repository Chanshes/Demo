package unit5;
//��5-6 ������Ϸ��
import java.util.Scanner;
public class GuessNumber {
	public static void main(String[] args){
		//���岢��ʼ������
		int count = 0;
		int inputNumber = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//����10���ڵ�������
		int number = (int)(Math.random()*10+1);
		System.out.println("�������������1~10֮�䣬��³�������");
		while(inputNumber != number){
			inputNumber = scanner.nextInt();
			count++;
			if(inputNumber > number)
				System.out.println("���´��ˣ��������");
			else if(inputNumber < number)
				System.out.println("����С�ˣ��������");
		}
		System.out.println("��ϲ�������ˣ�������"+ count +"��");
	}
}
