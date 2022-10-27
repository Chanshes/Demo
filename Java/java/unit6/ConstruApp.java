package unit6;
//例 6-6 ConstruApp.java的源代码
class SuperClass{
	int x;
	SuperClass(){//不带参数系统自动调用
		x=2;
	}
	SuperClass(int x){
		this.x=x;
	}
	}
class SubClass extends SuperClass{
	double d;
	SubClass(){
		super();
	}

	SubClass(double dx){
		super();//父类的构造方法 ；可删 系统自动调用无参数的构造方法
		d=dx;
	}
	SubClass(int i,double dx){
		super(i);//父类的构造方法 ；需要显示调用
		d=dx;
	}
}
public class ConstruApp{
	public static void main(String[] args){
		SubClass b1=new SubClass();
		SubClass b2=new SubClass(3.54);
		SubClass b3=new SubClass(20,78.97);
		System.out.printf("象b1的域x和d的值分别为：%2d,%2.2f",b1.x,b1.d);
		System.out.println();
		System.out.printf("象b2的x和d的值分别为：%2d,%2.2f",b2.x,b2.d);	
		System.out.println();
		System.out.printf("象b3的域西和d的值分别为：%2d,%2.2f",b3.x,b3.d);
	}
}
