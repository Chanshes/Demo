package unit9;
//��9-4 ��ť���¼�����
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Button_Event extends JFrame implements ActionListener{
	JButton button;
	public Button_Event(){
		super("��ɫ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		button = new JButton("��ɫ");
		button.setBounds(40,30,80,20);
		button.addActionListener(this);
		Container cp = getContentPane();
		cp.setBackground(Color.white);
		cp.setLayout(null);
		cp.add(button);
		setSize(200,200);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button)
			this.getContentPane().setBackground(Color.blue);
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		Button_Event frame = new Button_Event();
		frame.show();
	}
}
