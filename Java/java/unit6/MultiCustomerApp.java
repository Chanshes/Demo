package unit6;
//例6-15 GoldCustomer 与 GeneralCustomer 类的应用
public class MultiCustomerApp{
	public static void main(String [] args){
		GoldCustomer1 goldCustomer = new GoldCustomer1(1101011021,"susan",0.05,0.5);
		goldCustomer.add_deposite(20000);
		System.out.printf("%8s,%8s","姓名","手续费\n");
		System.out.printf("%10s, %10.2f",goldCustomer.get_userName(),goldCustomer.countRemit(6000));
		System.out.println();
		Customer customer = new GeneralCustomer(1101022016,"Tom",0.05);
		System.out.printf("%10s,%10.2f",customer.get_userName(),customer.countRemit(6000));
	}
}