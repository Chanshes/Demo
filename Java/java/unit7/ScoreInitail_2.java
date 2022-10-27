package unit7;
//例7-2 数组的初始化实例。
public class ScoreInitail_2 {
	public static void main(String[] args){
		int[] chj = {86,92,78,85,90,80};
		String [] KeCh = {"数学","英语","语文","政治","历史","地理"};
		System.out.println("张三的考试成绩为：");
		//显示课程名称
		for(int i = 0; i < KeCh.length; i++){
			System.out.printf("%6s",KeCh[i]);
		}
		System.out.println();		//换行
		//显示课程成绩
		for(int i = 0; i < chj.length; i++){
			System.out.printf("%8d",chj[i]);
		}
	}
}
