package unit7;
//��7-5 ѧ���ɼ���ͳ��.
import java.text.DecimalFormat;

public class StudentScore {
	public static void main(String[] args){
		String[] student = {"����","���","����","����","����"};   //ѧ��
		String[]course = {"��ѧ","Ӣ��","����","����","��ʷ","����"};  //�γ���
		int[][]chj = {{92,87,83,92,96,93},
				{78,50,69,60,70,67},
				{67,75,73,76,85,98},
				{86,56,70,74,56,78},
				{82,83,86,94,84,90}};
		int[] studentSum = new int[5];										//ÿ��ѧ�����ܷ�
		double[] courseSum = new double[6];							//ͳ��ÿ�ſγ̵��ܷ�
		DecimalFormat df = new DecimalFormat("#.#");			//���ɼ���ȷ��С�����һλ
		for(int i=0; i<student.length; i++){
			for(int j=0; j<chj[i].length;j++)
				studentSum[i] += chj[i][j];
			System.out.println("ѧ��" + student[i] + "���ܷ�Ϊ" + studentSum[i] + ", ƽ����Ϊ"+ df.format(studentSum[i]/course.length));
		}
		for(int i=0; i<course.length;i++){
			for(int j=0;j<student.length;j++)
				courseSum[i] += chj[j][i];
			System.out.println(course[i]+"�γ̵�ƽ����Ϊ:"+ df.format(courseSum[i]/student.length));
		}
	}
}
