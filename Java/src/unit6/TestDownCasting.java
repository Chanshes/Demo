package unit6;
//例6-8
public class TestDownCasting {
	public static void main(String[] args) {
		Human h = new Human("Marry",20,'女');
		if(h instanceof Worker){
			Worker a = (Worker)h;
			System.out.println(a.name+"薪水为："+a.salary);
		}
		else{
			System.out.println("不能进行对象类型转换");
		}
	}
}
