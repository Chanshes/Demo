package unit4;
//������ֲ���������ͬ��ʵ����
public class EqualVarible {
	int i = 2;//�� i
	void show(){
		int i = 6;//�ֲ����� i
		System.out.println("i="+i);
		System.out.println("this.i="+this.i);//this:��ǰ�����
	}
	public static void main(String args[]) {
		EqualVarible ev = new EqualVarible();
		ev.show();
	}
}
