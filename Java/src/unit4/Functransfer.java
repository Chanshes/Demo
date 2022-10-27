package unit4;

public class Functransfer {
	void changex(float x){
		System.out.println("x = "+x);
		x *= 3.4;
		System.out.println("x ="+x);
	}
	public static void main(String args[]){
		float d;
		d = 7.8f;
		System.out.println("方法调用前, d值为: "+d);
		Functransfer ft = new Functransfer();
		ft.changex(d);
		System.out.println("方法调用后, d值为: "+d);
		
	}
}
