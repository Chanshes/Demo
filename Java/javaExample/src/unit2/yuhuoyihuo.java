package unit2;
//2-2
public class yuhuoyihuo {

	public static void main(String[] args) {	
		int a = 20, b = 10, c1, c2, c3;
		c1 = a & b;
		c2 = a | b;
		c3 = a ^ b;
		dectoobin(c1);//10100 & 1010 = 00000
		System.out.println();
		decToobin(c2);//10100 | 1010 = 11110
		System.out.println();
		decTooBin(c3);//10100 ^ 1010 = 11110
		//教材43页：按位逻辑运算的结果
	}
	static  void decTooBin(int  dec){
		int res = 0,num = dec, k = 1;
		while(num != 0){
			res  +=  k * (num %2);
			num /= 2;
			k *=10;
		}
		System.out.println(res);
	}
	static void dectoobin(int n){
		for(int i = 31; i >= 0; i--){
			System.out.print((n >>> i) & 1);
		}
	}
	static void decToobin(int n){
		if(n == 0){
			return;
		}
		decToobin(n / 2);
		System.out.print(n % 2);
	}
}
