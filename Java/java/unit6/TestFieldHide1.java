package unit6;
//��6-4 ��������ĵ���ʵ����
class Base1 {
	int x = 3;
	public void m(){
		System.out.println("Base��xֵΪ��"+x);
	}
}
class  Derived1 extends Base1{
	double x = 20;
	public void n(){
		System.out.println("Derived��xֵΪ��"+x);
	}
	public void getHideX(){
		System.out.println("�����е���xֵΪ��"+(super.x));//xΪ��Base�ж������
	}
}
public class TestFieldHide1 {
	public static void main(String[] args){
		Derived1 d = new Derived1();
		d.m();
		d.getHideX();
		d.n();
	}
}
