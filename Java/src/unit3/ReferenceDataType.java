package unit3;
//例3-3 引用数据类型变量的性质
public class ReferenceDataType {
		int num = 2;
	public static void main(String[] args){
		ReferenceDataType t = new ReferenceDataType();
		ReferenceDataType age = new ReferenceDataType();
		t.num = 4;
		System.out.println("t.num="+t.num+",age.num="+age.num);
		t = age;
		System.out.println("t 赋为 age 后：");
		System.out.println("t.num="+t.num+",age.num"+age.num);
		t.num = 4;
		System.out.println("对象 t 的 num 属性的值改变后：");
		System.out.println("t.num="+t.num+",age.num"+age.num);
	}

}
