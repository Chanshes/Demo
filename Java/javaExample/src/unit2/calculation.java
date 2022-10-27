package unit2;
//6
public class calculation {
	public static void main(String[] args){
		short i = 1;
		float f = 0.1f;
		char c = 'a';
		float result1, result2;
		result1 = (c--)+(++i)*f;
		result2 = f *c;
		System.out.println(result1);
		System.out.println(result2);
	}
}
