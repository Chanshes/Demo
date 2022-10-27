package unit9;
//��9-5 �����ı�������������ļ�����
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class TextApp extends JFrame implements ActionListener{
	private JLabel label1, label2;
	private JTextField inputText,displayText;
	private JPasswordField inputPwd;
	public TextApp(){
		super("�����ı����Ӧ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("�û�����");
		label2 = new JLabel("���룺");
		inputText = new JTextField("����������",27);
		inputPwd = new JPasswordField(15);
		displayText = new JTextField(30);
		inputText.addActionListener(this);		//��Ӽ�����
		inputPwd.addActionListener(this);
		Container cp = getContentPane();		//��������뵽���������
		cp.setLayout(new FlowLayout());
		cp.add(label1);
		cp.add(inputText);
		cp.add(label2);
		cp.add(inputPwd);
		cp.add(displayText);
		
		setSize(400,200);
	}
	public void actionPerformed(ActionEvent e){	//�Իس��¼��Ĵ���
		if(e.getSource()==inputText||e.getSource()==inputPwd)
			displayText.setText("�û�����"+inputText.getText()+",���룺"+new String(inputPwd.getPassword()));
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		TextApp frame = new TextApp();
		frame.show();
	}
}
