package unit6;
//��6-5 ��������ʵ����
class A1 {
		int x = 3;
		public void m(){
			System.out.println("the x of A is "+x);
		}
}

class B1 extends A1{
	double y = 20.67;
	public void m(){
		y--;
		x--;//Ϊ��A�ж������,���Ա���B�ķ���m()ֱ�Ӳ���
		System.out.println("y = "+y+", x = "+x);
	}
}

public class C{
	public static void main(String[] args){
		B1 b = new B1();
		b.m();
	}
}