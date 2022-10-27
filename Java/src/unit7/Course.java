package unit7;
//例7-3 课程成绩的管理
public class Course {
	int[] chj;
	String[] KeCh;
	//构造方法，初始化对象
	public Course(int[] c, String[] k){
		chj = c;
		KeCh = k;
	}
	//求总分
	public int sumCourse(){
		int sum = 0;
		for(int i = 0;i < chj.length; i++)
			sum += chj[i];
		return sum;
	}
	//返回课程信息
	public String getCourseInfo(){
		String info = "";
		for(int i = 0; i < KeCh.length; i++){
			info += KeCh[i]+"\t"+chj[i]+"\n";
		}
		return info;
	}
	public static void main(String[] args){
		int[] chj = {86,92,78,85,90,80};
		String [] KeCh = {"数学","英语","语文","政治","历史","地理"};
		System.out.println("张三的考试成绩为：");
		Course zhCourse = new Course(chj,KeCh);
		System.out.print(zhCourse.getCourseInfo());
		System.out.println("总分为: "+zhCourse.sumCourse()+"分");
	}
}
