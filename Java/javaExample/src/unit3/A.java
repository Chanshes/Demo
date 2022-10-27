package unit3;
//2
public class A {
	private int data;
	public A(int data){
		this.data = data;
	}
	void setData(int a){
		this.data = a;
	}
	int getData(){
		return this.data;
	}
	public static void main(String[] args){
		A example = new A(1);
		int a = example.getData();
		System.out.println(a);
		example.setData(20);
		a = example.getData();
		System.out.println(a);
	}
}
