package unit6;
//��6-9
public class TestDownCasting1 {
	public static void main(String[] args) {
		Human h = new Worker("Marry",20,'Ů',  10000);
		if(h instanceof Worker){
			Worker a = (Worker)h;
			System.out.println(a.name+"нˮΪ��"+a.salary);
		}
		else{
			System.out.println("���ܽ��ж�������ת��");
		}
	}
}
