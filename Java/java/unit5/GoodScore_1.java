package unit5;
//例5-5 用户输入的判断。
import javax.swing.JOptionPane;
public class GoodScore_1 {
	public static void main(String[] args){
		int score;
		String s = JOptionPane.showInputDialog("请输入学生 分数");
		score = Integer.parseInt(s);
		s = score >=  90 && score <= 100 ? "该生的成绩为优秀" : "该生的成绩为不优秀";
		JOptionPane.showMessageDialog(null, s);
	}
}
