package unit9;
//例9-12 单选按钮的简单应用。
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JRadioButtonApp extends JFrame implements ItemListener {
	private JRadioButton jrb1, jrb2, jrb3, jrb4, jrb5;
	private JTextField text;
	private ButtonGroup group;
	private int bold  = Font.PLAIN, italic = Font.PLAIN;
	JRadioButtonApp(){
		super("JRadioButtonApp 的应用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		group = new ButtonGroup();
		jrb1 = new JRadioButton("红色字",true);
		jrb2 = new JRadioButton("蓝色字");
		jrb3 = new JRadioButton("黄色字");
		jrb4 = new JRadioButton("粗体");
		jrb5 = new JRadioButton("斜体");
		jrb1.addItemListener(this);
		jrb2.addItemListener(this);
		jrb3.addItemListener(this);
		jrb4.addItemListener(this);
		jrb5.addItemListener(this);
		group.add(jrb1);
		group.add(jrb2);
		group.add(jrb3);
		text = new JTextField("观察字体和颜色的变化",15);
		text.setForeground(Color.red);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(jrb1);
		cp.add(jrb2);
		cp.add(jrb3);
		cp.add(jrb4);
		cp.add(jrb5);
		cp.add(text);
		setSize(240,200);
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == jrb1)
			text.setForeground(Color.red);
		if(e.getSource() == jrb2)
			text.setForeground(Color.blue);
		if(e.getSource() == jrb3)
			text.setForeground(Color.yellow);
		if(e.getSource() == jrb4)
			bold = jrb4.isSelected()? Font.BOLD:Font.PLAIN ;
		if(e.getSource() == jrb5)
			italic = jrb5.isSelected()? Font.ITALIC:Font.PLAIN ;
		text.setFont(new Font("宋体",bold+italic,14));
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		JRadioButtonApp frame = new JRadioButtonApp();
		frame.show();
	}
}
