package unit9;
//��9-3 �򵥵İ�ť��ʾ
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ButtonApp extends JFrame{
	JButton button;
	public ButtonApp(){
		super("JF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("��ɫ");
		button.setBounds(40,30,80,20);
		Container cp = getContentPane();
		cp.setBackground(Color.white);
		cp.setLayout(null);
		cp.add(button);
		setSize(200,200);
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		ButtonApp frame = new ButtonApp();
		frame.show();
	}
}
