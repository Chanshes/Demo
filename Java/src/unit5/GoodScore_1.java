package unit5;
//��5-5 �û�������жϡ�
import javax.swing.JOptionPane;
public class GoodScore_1 {
	public static void main(String[] args){
		int score;
		String s = JOptionPane.showInputDialog("������ѧ�� ����");
		score = Integer.parseInt(s);
		s = score >=  90 && score <= 100 ? "�����ĳɼ�Ϊ����" : "�����ĳɼ�Ϊ������";
		JOptionPane.showMessageDialog(null, s);
	}
}
