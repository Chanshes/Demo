package unit3;
//��3-5 �û������ж�
import javax.swing.JOptionPane;

public class GoodScore {

	public static void main(String[] args) {
		int score;
		String s = JOptionPane.showInputDialog("������ѧ������");
		score = Integer.parseInt(s);
		if (score >= 90 && score <= 100)
			JOptionPane.showMessageDialog(null, "�����ĳɼ�Ϊ����");
		else
			JOptionPane.showMessageDialog(null, "�����ɼ�Ϊ������");

	}

}
