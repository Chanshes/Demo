package unit3;
import javax.swing.JOptionPane;
//��3-4 ���α����ıȽ�
public class CompareInt{

	public static void main(String[] args) {
		int x, y;
		String s = JOptionPane.showInputDialog("�������һ������");
		x = Integer.parseInt(s);
		s = JOptionPane.showInputDialog("������ڶ�������");
		y = Integer.parseInt(s);
		if(x < y)
			JOptionPane.showMessageDialog(null, "�ϴ�ֵΪ��"+y);
		else
			JOptionPane.showMessageDialog(null, "�ϴ�ֵΪ��"+x);

	}

}
