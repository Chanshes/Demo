package unit9;
//��9-1 �򵥴�����ʾ����
import javax.swing.*;//����Swing���
import java.awt.*;

@SuppressWarnings("serial")
public class SwingWindow extends JFrame{
	JLabel labell;//����һ����ǩ
	public SwingWindow(){
		setTitle("��Swing����");//���ڱ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرհ�ť���˳�����
/*public void setDefaultCloseOperation(int operation)��JFrame�ķ��������������رա���ť
 * ʱ�������ղ���operation��ֵ������ִ�еĲ�����*/
		//EXIT_ON_CLOSE:�˳�Ӧ�ó��򣬸ò���������Ӧ�ó���
		//HIDE_ON_CLOSE:Ĭ��ֵ���û��رմ��ں󣬴�����������
		//DISPOSE_ON_CLOSE:�û��رպ󣬴�����ʧ���ͷ�����ռ�е���Դ
		/*DO_NOTHING_ON_CLOSE:�û��رմ��ں����κ��£���Ҫ���ô��ڼ�����
 * �е�windowClosing()����ִ����������*/
		labell = new JLabel("����һ���򵥵�Swingʵ��");//����ǩ��ʼ��
		Container myCP = getContentPane();//��ö����������������
		myCP.setBackground(Color.red);//���ñ�����ɫ
		myCP.add(labell);//�򴰿����JLabel���
		setSize(200,200);//���ô��ڴ�С
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		SwingWindow sWindow = new SwingWindow();//ʵ����SwingWindow����
		sWindow.show();//��ʾ���� ��setVisible(true)����Ҳ�ɴﵽ��Ŀ�ģ�
	}
}
