package unit4;
//��4-14 ����ChangeFunc.java��Դ����
public class ChangeFunc {
	static void change(float x){
		System.out.println("x = "+x);
		x *= 3.14;
		System.out.println("x = "+x);
	}
}
class FuncMain{
	public static void main(String[] args){
		float data;
		data = 7.8f;
		System.out.println("data = "+data);
		ChangeFunc.change(data);
		System.out.println("data = "+data);
	}
}