package unit6;
//�� 6-6 ConstruApp.java��Դ����
class SuperClass{
	int x;
	SuperClass(){//��������ϵͳ�Զ�����
		x=2;
	}
	SuperClass(int x){
		this.x=x;
	}
	}
class SubClass extends SuperClass{
	double d;
	SubClass(){
		super();
	}

	SubClass(double dx){
		super();//����Ĺ��췽�� ����ɾ ϵͳ�Զ������޲����Ĺ��췽��
		d=dx;
	}
	SubClass(int i,double dx){
		super(i);//����Ĺ��췽�� ����Ҫ��ʾ����
		d=dx;
	}
}
public class ConstruApp{
	public static void main(String[] args){
		SubClass b1=new SubClass();
		SubClass b2=new SubClass(3.54);
		SubClass b3=new SubClass(20,78.97);
		System.out.printf("��b1����x��d��ֵ�ֱ�Ϊ��%2d,%2.2f",b1.x,b1.d);
		System.out.println();
		System.out.printf("��b2��x��d��ֵ�ֱ�Ϊ��%2d,%2.2f",b2.x,b2.d);	
		System.out.println();
		System.out.printf("��b3��������d��ֵ�ֱ�Ϊ��%2d,%2.2f",b3.x,b3.d);
	}
}
