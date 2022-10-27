package unit6;
//例6-4 被隐藏域的调用实例。
class Base1 {
	int x = 3;
	public void m(){
		System.out.println("Base的x值为："+x);
	}
}
class  Derived1 extends Base1{
	double x = 20;
	public void n(){
		System.out.println("Derived的x值为："+x);
	}
	public void getHideX(){
		System.out.println("父类中的域x值为："+(super.x));//x为类Base中定义的域
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
