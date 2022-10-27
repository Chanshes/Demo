package unit6;
//例6-5 方法覆盖实例。
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
		x--;//为类A中定义的域,可以被类B的方法m()直接操作
		System.out.println("y = "+y+", x = "+x);
	}
}

public class C{
	public static void main(String[] args){
		B1 b = new B1();
		b.m();
	}
}