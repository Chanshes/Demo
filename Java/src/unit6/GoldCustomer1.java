package unit6;
//��6-13 GoldCustomer���ʵ�֡�
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
	public double countRemit(double amount){//���󷽷���ʵ�� 
		double result;
		result = amount * fee * discount;
		return result;	
	}
	public void add_deposite(double i) {
			deposit += i;
	}
}
