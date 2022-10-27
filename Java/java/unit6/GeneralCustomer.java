package unit6;
//例6-14 GeneralCustomer
public class GeneralCustomer extends Customer{
	 public GeneralCustomer(int cardNo, String userName,double fee){
		 this.cardNo = cardNo;
		 this.userName = userName;
		 deposit = 0;
		 this.fee = fee;
	 }
	 public void set_Fee(double f){
		 fee = f;
	 }
	 public double get_Fee(){
		 return fee;
	 }
	 public double countRemit(double amount){//抽象方法实现
		 double result;
		 result = amount * fee;
		 return result;
	 }
}
