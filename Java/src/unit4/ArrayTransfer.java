 package unit4;
//��4-9 ArrayTransfer.java��Դ���롣
//�������÷�ʽ��ʵ��
public class ArrayTransfer {
	void changex(float[] x){
		int i = 0;
		for(i = 0; i < x.length; i++){
			System.out.print("x["+i+"]="+x[i]);
			x[i] *= 2;
		}
		System.out.println();
		for(i = 0; i <  x.length; i++)
			System.out.print("x["+i+"]="+x[i]);
		System.out.println();
	}
	public static void main(String[] args){
		float[] d = new float[2];
		d[0] = 2f;
		d[1] = 5f;
		System.out.print("��������ǰ��d[0]Ϊ��"+d[0]);
		System.out.println(",d[1]Ϊ: "+d[1]);
		ArrayTransfer ft = new ArrayTransfer();
		ft.changex(d);
		System.out.print("�������ú�,d[0]Ϊ��"+d[0]);
		System.out.println(",d[1]Ϊ: "+d[1]);
	}
}
