package unit5;
//例5-3 将成绩由百分制转换为等级制
import java.util.Scanner;

public class ScoreTransfer {
	public static void main(String[]  args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入分数: ");
		int score = scanner.nextInt();
		if(score >= 90)
			System.out.println("优秀");
		else if(score >= 80)
			System.out.println("良好");
		else if(score >= 70)
			System.out.println("中等");
		else if(score >= 60)
			System.out.println("及格");
		else
			System.out.println("不及格");
	}
}
