package unit5;
//例5-4 学生成绩的格式转换。
import java.util.Scanner;

public class ScoreTransferSwitch {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入分数(0-100):");
		int score = scanner.nextInt();
		int level = (int)score/10;
		if(score>100 || score <0)
			System.out.println("您输入的成绩非法!");
		else{ //输入成绩合法
			System.out.print("成绩为");
			switch(level){
			case 10:
			case 9:
				System.out.println("优秀");
				break;
			case 8:
				System.out.println("良好");
				break;
			case 7:
				System.out.println("中等");
				break;
			case 6:
				System.out.println("及格");
				break;
			default:
				System.out.println("不及格");
			}
		}
	}
}
