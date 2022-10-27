package unit9;
//例9-5 单行文本框和密码输入框的简单运用
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TextApp extends JFrame implements ActionListener{
	private JLabel label1, label2;
	private JTextField inputText,displayText;
	private JPasswordField inputPwd;
	public TextApp(){
		super("单行文本框的应用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("用户名：");
		label2 = new JLabel("密码：");
		inputText = new JTextField("请输入名字",27);
		inputPwd = new JPasswordField(15);
		displayText = new JTextField(30);
		inputText.addActionListener(this);		//添加监听器
		inputPwd.addActionListener(this);
		Container cp = getContentPane();		//将组件加入到内容面板中
		cp.setLayout(new FlowLayout());
		cp.add(label1);
		cp.add(inputText);
		cp.add(label2);
		cp.add(inputPwd);
		cp.add(displayText);
		
		setSize(400,200);
	}
	public void actionPerformed(ActionEvent e){	//对回车事件的处理
		if(e.getSource()==inputText||e.getSource()==inputPwd)
			displayText.setText("用户名："+inputText.getText()+",密码："+new String(inputPwd.getPassword()));
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		TextApp frame = new TextApp();
		frame.show();
	}
}
