package unit6;
//��6-14 GeneralCustomer
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
	 public double countRemit(double amount){//���󷽷�ʵ��
		 double result;
		 result = amount * fee;
		 return result;
	 }
}
