package unit5;
//例5-1 单向if语句使用实例
import javax.swing.JOptionPane;
public class Bonus {
	public static void main(String[] args) {
		int x;
		String s = JOptionPane.showInputDialog("请输入一个整数");
		x = Integer.parseInt(s);
		if(x == 1)
			JOptionPane.showMessageDialog(null,"一等奖");
	}
}
