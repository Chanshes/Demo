package unit9;
//��9-2 JFrame�б��밴ť����ʾ
import javax.swing.*;
import java.awt.*;//�����

@SuppressWarnings("serial")
public class FrameApp extends JFrame{
	JLabel label;
	JButton button1,button2;
	public FrameApp(){
		super("JFrame ����");//���ÿ�ܵı���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("Photos/sun.gif");/*������һ��ImageIcon������
��һ��JLabel�н���ͼ����뵽��ǩ��*/
		label = new JLabel("JFrameӦ�ã���ǩ��ʾͼ��",icon,JLabel.LEFT);
/*��ǩ�Ĺ��췽��"JLabel(String text, Icon icon, int horizontalAlignment)" ��ͬʱ������
 * ��ͼ����ʾ�ڱ�ǩ�ϡ�����horizontalAlignmentָ���˱�ǩ��ˮƽ���뷽ʽ��ȡֵΪSwing�ĳ�
 * ����LEFT,CENTER,RIGHT,LEADING��TRAILING*/
		button1 = new JButton("��ť1");
		button2 = new JButton("��ť2");
		Container cp = getContentPane();//��ȡ��ܵ��������
		cp.add(label,"Center");
		cp.add(button2,"South");//���� North South West East Center�������λ
		cp.add(button1,"North");//���ؼ���ӵ���ܵ����������ȥ
		setSize(200,200);
	/*���ÿ�ܵĴ�С
	 * pack()�����Զ�������ܵĴ�СΪ����������ռ�õĴ�С�����JFrame�в���
	 * ���������ֻ��ʾ��ܵı�����*/
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		FrameApp frame = new FrameApp();
		frame.show();//��ʾ���
	}
}
