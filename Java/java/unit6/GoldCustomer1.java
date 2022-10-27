package unit6;
//例6-13 GoldCustomer类的实现。
public class GoldCustomer1 extends Customer{
	private double discount;
	public GoldCustomer1(int cardNo, String userName, double fee, double discount){
		this.cardNo = cardNo;
		this.userName = userName;
		deposit = 0;
		this.fee = fee;
		this.discount = discount;
	}
	public void set_Fee(double f){
		fee = f;
	}
	public double get_Fee(){
		return fee;
	}
	public double countRemit(double amount){//抽象方法的实现 
		double result;
		result = amount * fee * discount;
		return result;	
	}
	public void add_deposite(double i) {
			deposit += i;
	}
}
