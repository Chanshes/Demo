package unit4;
//��4-16 protected���η���ʹ�á�
class A{
//����A�ж�����3����Ϊ��ͬ�ķ���Ȩ�����η������Ρ�
	protected int pa;
	public int pi;
	private double pd;//��pd��private���Σ�ֻ������A�з��ʡ�
	
	public double getPd(){
		return pd;
	}
	public void setPd(double d){
		pd = d;
	}
}
class SubA extends A{
//��SubA����A�����࣬����ֱ�ӷ��ʼ̳��Ը����б�protected��public���ε���pa����pi��
	public SubA(int a, int b, double c){
		pa = a;
		pi = b;
		setPd(c);
	}
}

public class SubApp {
	public static void main(String[] args){
		SubA sa = new SubA(2,3,5.7);
		System.out.println("sa.pa="+sa.pa);
		System.out.println("sa.pi="+sa.pi);
		System.out.println("Sa.pd="+sa.getPd());
		//����pd��private���Σ�ֻ��ͨ�����÷���setPd���޸�pd��ֵ��
	}
}
