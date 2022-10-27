package unit4;
//域名与局部变量名相同的实例。
public class EqualVarible {
	int i = 2;//域 i
	void show(){
		int i = 6;//局部变量 i
		System.out.println("i="+i);
		System.out.println("this.i="+this.i);//this:当前类对象
	}
	public static void main(String args[]) {
		EqualVarible ev = new EqualVarible();
		ev.show();
	}
}
