package unit5;
//��5-12 ʹ��˫��ѭ�������1��10�Ľ׳˺͡�
public class FactorialSum1 {
	public static void main(String[] args){
		int sum = 0;
		int result = 1;
		for(int i = 1; i<=10; i++){
			//1.��i�Ľ׳�
			for(int j = 1; j <= i; j++)
				result = result * j;
			//2.���׳�ֵ���뵽sum��
			sum += result;
			//3.result���±���ֵΪ1������������һ�����Ľ׳�
			result = 1;
		}
		System.out.println("��һ��10�Ľ׳˺�Ϊ: " + sum);
	}
}
