package unit6;
//例6-2 Teacher对象的定义和实现
public class TextTeacher {

	public static void main(String[] args) {
		Teacher t = new Teacher();
		System.out.println(t.name+"的工资为："+t.getSalary());
		System.out.println(t.name+"的专业为："+t.getSpeciality());
		
		Teacher s = new Teacher("张重阳",'男',20,10000,"统计学");
		System.out.println(s.name+"的工资为："+s.getSalary());
		System.out.println(s.name+"的专业为："+s.getSpeciality());
	}
}
