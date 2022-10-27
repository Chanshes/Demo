package unit4;
//7.
public class interest {
	public static void main(String[] args){
		int year = 20;
		double capital = 1000;
		double result;
		for(int i = 1; i <= year; i++){
			result = rates(capital,i);
			System.out.printf("第%d年的存款：%.2f\n",i,result);
		}
	}
	public static double rates(double capital, int year){
		double a;
		double p = capital;
		double r = 0.05;
		int n = year;
		a = p * Power((r+1.0),n);
		return a;
	}
	public static double Power(double c,int d ){
		double result = 1;
		for(int i = 1; i <= d; i++){
			result *= c;
		}
		return result;
	}
}
