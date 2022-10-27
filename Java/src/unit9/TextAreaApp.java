package unit9;
//��9-6 �����ı���ļ�ʹ��
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class TextAreaApp extends JFrame implements DocumentListener{
	private JTextArea baseText,copyText;
	private JScrollPane sp1, sp2;
	public TextAreaApp(){
		setTitle("�����ı����ʹ��");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		baseText = new JTextArea(5,5);//���ó��ȺͿ��
		copyText = new JTextArea(8,6);
		baseText.setLineWrap(true);
		copyText.setLineWrap(true);
		sp1 = new JScrollPane(baseText);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//������ʾ��ֱ������
		cp.add(sp1);
		sp2 = new JScrollPane(copyText);
		sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//��Ҫʱ��ʾ��ֱ������
		cp.add(sp2);
		baseText.getDocument().addDocumentListener(this);
		setSize(240,200);//���ô��ڴ�С
	}
	public void insertUpdate(DocumentEvent e){//����ı��¼��Ĵ�����
		copyText.setText(baseText.getText());
	}
	public void removeUpdate(DocumentEvent e){//ɾ���ı��¼�������
		copyText.setText(baseText.getText());
	}
	public void changedUpdate(DocumentEvent e){//�ı����ݸı��¼�������
		copyText.setText(baseText.getText());
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		TextAreaApp frame = new TextAreaApp();
		frame.show();
	}
}
