package unit4;
//例4-16 protected修饰符的使用。
class A{
//在类A中定义了3个域，为不同的访问权限修饰符所修饰。
	protected int pa;
	public int pi;
	private double pd;//域pd被private修饰，只能在类A中访问。
	
	public double getPd(){
		return pd;
	}
	public void setPd(double d){
		pd = d;
	}
}
class SubA extends A{
//类SubA是类A的子类，可以直接访问继承自父类中被protected和public修饰的域pa和域pi。
	public SubA(int a, int b, double c){
		pa = a;
		pi = b;
		setPd(c);
	}
}

public class SubApp {
	public static void main(String[] args){
		SubA sa = new SubA(2,3,5.7);
		System.out.println("sa.pa="+sa.pa);
		System.out.println("sa.pi="+sa.pi);
		System.out.println("Sa.pd="+sa.getPd());
		//由于pd被private修饰，只能通过调用方法setPd来修改pd的值。
	}
}
