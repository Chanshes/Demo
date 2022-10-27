package unit9;
//例9-11 复选框的简单应用。
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JCheckBoxApp extends JFrame implements ActionListener {
	private JCheckBox jcb1, jcb2, jcb3, jcb4;
	private JTextArea favorite;
	JCheckBoxApp(){
		super("JCheckBoxApp 的应用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jcb1 = new JCheckBox("足球");
		jcb2 = new JCheckBox("古典音乐");
		jcb3 = new JCheckBox("摄影");
		jcb4 = new JCheckBox("英语");
		jcb1.addActionListener(this);
		jcb2.addActionListener(this);
		jcb3.addActionListener(this);
		jcb4.addActionListener(this);
		favorite = new JTextArea(7,12);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(jcb1);
		cp.add(jcb2);
		cp.add(jcb3);
		cp.add(jcb4);
		cp.add(new JScrollPane(favorite));
		setSize(280,200);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jcb1)
			courseSelect(jcb1);
		if(e.getSource() == jcb2)
			courseSelect(jcb2);
		if(e.getSource() == jcb3)
			courseSelect(jcb3);
		if(e.getSource() == jcb4)
			courseSelect(jcb4);
	}
	public void courseSelect(JCheckBox c){
		if(c.isSelected())
			favorite.append(c.getText()+"课程被选择\n");
		else
			favorite.append(c.getText()+"课程被取消\n");
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		JCheckBoxApp frame = new JCheckBoxApp();
		frame.show();
	}
}
