package unit4;
//3
public class shuixianhuashu {
	public static void main(String[] args){
		int i = 100;
		System.out.println("Ë®ÏÉ»¨Êı:");
		while(i<=999){
			findshuixianhuashu(i);
			i++;
		}
	}
	 public static void findshuixianhuashu(int x){
		int ge,shi,bai;
		ge = x%10;
		shi = x/10%10;
		bai = x/100;
		if((ge*ge*ge+shi*shi*shi+bai*bai*bai) == x)
			System.out.println(x);
	}
}