package unit6;
//��6-2 Teacher����Ķ����ʵ��
public class TextTeacher {

	public static void main(String[] args) {
		Teacher t = new Teacher();
		System.out.println(t.name+"�Ĺ���Ϊ��"+t.getSalary());
		System.out.println(t.name+"��רҵΪ��"+t.getSpeciality());
		
		Teacher s = new Teacher("������",'��',20,10000,"ͳ��ѧ");
		System.out.println(s.name+"�Ĺ���Ϊ��"+s.getSalary());
		System.out.println(s.name+"��רҵΪ��"+s.getSpeciality());
	}
}
