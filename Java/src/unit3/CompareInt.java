package unit3;
import javax.swing.JOptionPane;
//例3-4 整形变量的比较
public class CompareInt{

	public static void main(String[] args) {
		int x, y;
		String s = JOptionPane.showInputDialog("请输入第一个整数");
		x = Integer.parseInt(s);
		s = JOptionPane.showInputDialog("请输入第二个整数");
		y = Integer.parseInt(s);
		if(x < y)
			JOptionPane.showMessageDialog(null, "较大值为："+y);
		else
			JOptionPane.showMessageDialog(null, "较大值为："+x);

	}

}
