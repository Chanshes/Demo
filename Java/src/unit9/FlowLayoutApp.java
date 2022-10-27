package unit9;
//��9-8  FlowLayout �ļ�Ӧ��
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class FlowLayoutApp extends JFrame{
	private JButton oneButton, twoButton, threeButton, fourButton, fiveButton;
	private FlowLayout layout;
	public FlowLayoutApp(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FlowLayout ��Ӧ��");
		layout = new FlowLayout(FlowLayout.LEFT);
		setSize(300,200);
		Container cp = getContentPane();
		cp.setLayout(layout);
		oneButton = new JButton("��ť1");
		twoButton = new JButton("��ť2");
		threeButton = new JButton("��������ť");
		fourButton = new JButton("��ť4");
		fiveButton = new JButton("��ť5");
		cp.add(oneButton);
		cp.add(twoButton);
		cp.add(threeButton);
		cp.add(fourButton);
		cp.add(fiveButton);
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		FlowLayoutApp frame = new FlowLayoutApp();
		frame.show();
	}
}
