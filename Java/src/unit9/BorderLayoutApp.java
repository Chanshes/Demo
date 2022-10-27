package unit9;
//��9-7 BorderLayout �ļ�Ӧ�á�
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BorderLayoutApp extends JFrame{
	private JButton northButton,southButton,eastButton,westButton,centerButton;
	public BorderLayoutApp(){
		setTitle("BorderLayout ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		Container cp = getContentPane();
		northButton = new JButton("����");
		southButton = new JButton("����");
		eastButton = new JButton("����");
		westButton = new JButton("����");
		centerButton = new JButton("�м�");
		cp.add(northButton,BorderLayout.NORTH);
		cp.add(southButton,BorderLayout.SOUTH);
		cp.add(eastButton,BorderLayout.EAST);
		cp.add(westButton,BorderLayout.WEST);
		cp.add(centerButton,BorderLayout.CENTER);
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		BorderLayoutApp  frame = new BorderLayoutApp();
		frame.show();//show()������ʱ��setVisible(boolean)����
	}
}
