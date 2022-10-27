package unit4;
//5
public class qinmishu {
	public static void main(String[] args){
		int A, B;
		for(A = 1; A < 1000; A++){
			for(B = 1; B < 1000; B++){
				if(A == B)
					break;
				if(yinzihe(A) == B && yinzihe(B) == A)
					System.out.printf("%d与%d是亲密数对",A,B);
				}
		}
	}
	private static int yinzihe(int a) {
		int result = 0;
		for(int i = 1; i<a;i++){
			if(a%i == 0)
				result += i;
		}
		return result;
	}
}