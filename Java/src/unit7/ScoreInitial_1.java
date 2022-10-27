package unit7;
//例7-1 数组的创建实例。
public class ScoreInitial_1 {
	public static void main(String[] args){
		int[] chj = new int [6];
		System.out.println("数组chj的默认值为：");
		for(int i = 0; i < chj.length;i++){
			System.out.print("chj["+i+"]="+chj[i] + "\t");
		}	
	}
}
