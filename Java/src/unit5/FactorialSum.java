package unit5;
//��5-11 ����� 1��10�Ľ׳˺͡�
public class FactorialSum {
	//�����number�Ľ׳�
	public static int factorial(int n){
		int result = 1;
		for(int i = 1;i<=n;i++)
			result = result *i;
		return result;
	}
	public static void main(String[] args){
		int sum = 0;
		for(int i = 1;i<=10;i++)
			sum = sum + factorial(i);
		System.out.println("��1��10�Ľ׳˺�Ϊ��" + sum);
	}
}
