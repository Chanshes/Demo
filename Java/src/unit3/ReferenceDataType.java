package unit3;
//��3-3 �����������ͱ���������
public class ReferenceDataType {
		int num = 2;
	public static void main(String[] args){
		ReferenceDataType t = new ReferenceDataType();
		ReferenceDataType age = new ReferenceDataType();
		t.num = 4;
		System.out.println("t.num="+t.num+",age.num="+age.num);
		t = age;
		System.out.println("t ��Ϊ age ��");
		System.out.println("t.num="+t.num+",age.num"+age.num);
		t.num = 4;
		System.out.println("���� t �� num ���Ե�ֵ�ı��");
		System.out.println("t.num="+t.num+",age.num"+age.num);
	}

}
