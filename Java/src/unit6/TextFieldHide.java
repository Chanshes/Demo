package unit6;
//例6-3 域的隐藏实例
class Base{
	 int x = 3;
	 public void m(){
		 x++;
		 System.out.println("Base的x值为："+x);
	 }
}
class Derived extends Base{
	double x = 20;
	public void n(){
		x--;
		System.out.println("Derive的x值为："+x);
	}
}
public class TextFieldHide {
	public static void main(String[] args) {
		Derived d = new Derived();
		System.out.println("Derived对象的域x的值为："+d.x);
	}
}
