package unit6;
//��6-8
public class TestDownCasting {
	public static void main(String[] args) {
		Human h = new Human("Marry",20,'Ů');
		if(h instanceof Worker){
			Worker a = (Worker)h;
			System.out.println(a.name+"нˮΪ��"+a.salary);
		}
		else{
			System.out.println("���ܽ��ж�������ת��");
		}
	}
}
