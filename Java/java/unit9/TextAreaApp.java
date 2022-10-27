package unit9;
//例9-6 多行文本域的简单使用
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class TextAreaApp extends JFrame implements DocumentListener{
	private JTextArea baseText,copyText;
	private JScrollPane sp1, sp2;
	public TextAreaApp(){
		setTitle("多行文本域的使用");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		baseText = new JTextArea(5,5);//设置长度和宽度
		copyText = new JTextArea(8,6);
		baseText.setLineWrap(true);
		copyText.setLineWrap(true);
		sp1 = new JScrollPane(baseText);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//总是显示垂直滚动条
		cp.add(sp1);
		sp2 = new JScrollPane(copyText);
		sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//需要时显示垂直滚动条
		cp.add(sp2);
		baseText.getDocument().addDocumentListener(this);
		setSize(240,200);//设置窗口大小
	}
	public void insertUpdate(DocumentEvent e){//添加文本事件的处理方法
		copyText.setText(baseText.getText());
	}
	public void removeUpdate(DocumentEvent e){//删除文本事件处理方法
		copyText.setText(baseText.getText());
	}
	public void changedUpdate(DocumentEvent e){//文本内容改变事件处理方法
		copyText.setText(baseText.getText());
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		TextAreaApp frame = new TextAreaApp();
		frame.show();
	}
}
