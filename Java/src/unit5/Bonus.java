package unit5;
//��5-1 ����if���ʹ��ʵ��
import javax.swing.JOptionPane;
public class Bonus {
	public static void main(String[] args) {
		int x;
		String s = JOptionPane.showInputDialog("������һ������");
		x = Integer.parseInt(s);
		if(x == 1)
			JOptionPane.showMessageDialog(null,"һ�Ƚ�");
	}
}
