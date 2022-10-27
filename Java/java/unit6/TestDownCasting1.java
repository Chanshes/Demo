package unit6;
//例6-9
public class TestDownCasting1 {
	public static void main(String[] args) {
		Human h = new Worker("Marry",20,'女',  10000);
		if(h instanceof Worker){
			Worker a = (Worker)h;
			System.out.println(a.name+"薪水为："+a.salary);
		}
		else{
			System.out.println("不能进行对象类型转换");
		}
	}
}
