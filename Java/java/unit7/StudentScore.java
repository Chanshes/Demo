package unit7;
//例7-5 学生成绩的统计.
import java.text.DecimalFormat;

public class StudentScore {
	public static void main(String[] args){
		String[] student = {"张三","李冰","曹宇","金欣","吴语"};   //学号
		String[]course = {"数学","英语","语文","政治","历史","地理"};  //课程名
		int[][]chj = {{92,87,83,92,96,93},
				{78,50,69,60,70,67},
				{67,75,73,76,85,98},
				{86,56,70,74,56,78},
				{82,83,86,94,84,90}};
		int[] studentSum = new int[5];										//每个学生的总分
		double[] courseSum = new double[6];							//统计每门课程的总分
		DecimalFormat df = new DecimalFormat("#.#");			//将成绩精确到小数点后一位
		for(int i=0; i<student.length; i++){
			for(int j=0; j<chj[i].length;j++)
				studentSum[i] += chj[i][j];
			System.out.println("学生" + student[i] + "的总分为" + studentSum[i] + ", 平均分为"+ df.format(studentSum[i]/course.length));
		}
		for(int i=0; i<course.length;i++){
			for(int j=0;j<student.length;j++)
				courseSum[i] += chj[j][i];
			System.out.println(course[i]+"课程的平均分为:"+ df.format(courseSum[i]/student.length));
		}
	}
}
