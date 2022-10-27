 package unit6;
//例6-10 某银行客户类定义。
public abstract class Customer {
	protected int cardNo;
	protected String userName;
	protected double deposit;
	protected double fee;
	public  String get_userName(){
		return userName;
	}
	public void set_userName(String name){
		userName = name;
	}
	public int get_cardNo(){
		return cardNo;
	}
	public double get_deposit(){
		return deposit;
	}
	public void add_deposit(double count){
		deposit += count;
	}
	public abstract double countRemit(double amount);
}