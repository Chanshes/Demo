package unit7;
//��7-3 �γ̳ɼ��Ĺ���
public class Course {
	int[] chj;
	String[] KeCh;
	//���췽������ʼ������
	public Course(int[] c, String[] k){
		chj = c;
		KeCh = k;
	}
	//���ܷ�
	public int sumCourse(){
		int sum = 0;
		for(int i = 0;i < chj.length; i++)
			sum += chj[i];
		return sum;
	}
	//���ؿγ���Ϣ
	public String getCourseInfo(){
		String info = "";
		for(int i = 0; i < KeCh.length; i++){
			info += KeCh[i]+"\t"+chj[i]+"\n";
		}
		return info;
	}
	public static void main(String[] args){
		int[] chj = {86,92,78,85,90,80};
		String [] KeCh = {"��ѧ","Ӣ��","����","����","��ʷ","����"};
		System.out.println("�����Ŀ��Գɼ�Ϊ��");
		Course zhCourse = new Course(chj,KeCh);
		System.out.print(zhCourse.getCourseInfo());
		System.out.println("�ܷ�Ϊ: "+zhCourse.sumCourse()+"��");
	}
}
