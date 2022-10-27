package unit3;
//例3-5 用户输入判断
import javax.swing.JOptionPane;

public class GoodScore {

	public static void main(String[] args) {
		int score;
		String s = JOptionPane.showInputDialog("请输入学生分数");
		score = Integer.parseInt(s);
		if (score >= 90 && score <= 100)
			JOptionPane.showMessageDialog(null, "该生的成绩为优秀");
		else
			JOptionPane.showMessageDialog(null, "该生成绩为不优秀");

	}

}
