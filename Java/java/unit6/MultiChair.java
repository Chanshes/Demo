package unit6;
//��6-21 �����ֹ��ܵ����ְ�Ħ�ε�ʵ�֡�
//ʵ����ӿڹ��ܵ�������
public class MultiChair extends Chair implements Music,Massage,Video{
	int sitMinute;
	public MultiChair(int time){
		sitMinute = time;
	}
	public void sit(){
		System.out.println("����������Ϣ"+sitMinute+"���ӣ�");
	}
	public void listenMusic(){
		System.out.println("�����������������������ְɣ�");
	}
	public void getMassage(){
		System.out.println("�������������ӵ��Զ���Ħ����ɣ�");
	}
	public void watchVideo(){
		System.out.println("���������������Ͽ����Ӱ����");
	}
}
