package unit6;
//��6-3 �������ʵ��
class Base{
	 int x = 3;
	 public void m(){
		 x++;
		 System.out.println("Base��xֵΪ��"+x);
	 }
}
class Derived extends Base{
	double x = 20;
	public void n(){
		x--;
		System.out.println("Derive��xֵΪ��"+x);
	}
}
public class TextFieldHide {
	public static void main(String[] args) {
		Derived d = new Derived();
		System.out.println("Derived�������x��ֵΪ��"+d.x);
	}
}
