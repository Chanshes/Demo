package unit5;
//��5-9 ��do������while���ʵ�ֲ�����Ϸ��
import java.util.Scanner;
public class GuessNumberDoWhile {
	public static void main(String[] args){
		//���岢��ʼ������
		int count = 0;
		int inputNumber; //����Ҫ��ʼ��Ϊ0
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//����10���ڵ�������
		int number = (int)(Math.random()*10+1);
		//ѭ���ж�����ֵ���������С
		System.out.println("�������������1~10֮�䣬��³�������");
		do{
			inputNumber = scanner.nextInt();
			count++;
			if(inputNumber > number)
				System.out.println("���´��ˣ��������");
			else if(inputNumber < number)
				System.out.println("����С�ˣ��������");
		}while(inputNumber != number);
		System.out.println("��ϲ�������ˣ�������"+count+"��");
	}
}
