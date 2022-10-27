package unit9;
//例9-4 按钮的事件处理
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Button_Event extends JFrame implements ActionListener{
	JButton button;
	public Button_Event(){
		super("蓝色");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		button = new JButton("蓝色");
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
