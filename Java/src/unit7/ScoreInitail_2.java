package unit7;
//��7-2 ����ĳ�ʼ��ʵ����
public class ScoreInitail_2 {
	public static void main(String[] args){
		int[] chj = {86,92,78,85,90,80};
		String [] KeCh = {"��ѧ","Ӣ��","����","����","��ʷ","����"};
		System.out.println("�����Ŀ��Գɼ�Ϊ��");
		//��ʾ�γ�����
		for(int i = 0; i < KeCh.length; i++){
			System.out.printf("%6s",KeCh[i]);
		}
		System.out.println();		//����
		//��ʾ�γ̳ɼ�
		for(int i = 0; i < chj.length; i++){
			System.out.printf("%8d",chj[i]);
		}
	}
}
