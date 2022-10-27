package unit3;
//3-4test
public class Stringcom {
	public static void main(String args[]){
		String a = "abc";
		String b = "abc";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		String c = new String("abc");
		String d = new String("abc");
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		System.out.println(a == b? "true" :"false");
		System.out.println(c == d? "true" :"false");
		int result1 = -13%3;
		float result2 = 12/7.0f;
		System.out.println(result1+";"+result2);
		
	}
}
