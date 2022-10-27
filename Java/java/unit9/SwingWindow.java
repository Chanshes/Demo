package unit9;
//例9-1 简单窗口显示代码
import javax.swing.*;//引用Swing组件
import java.awt.*;

@SuppressWarnings("serial")
public class SwingWindow extends JFrame{
	JLabel labell;//创建一个标签
	public SwingWindow(){
		setTitle("简单Swing窗口");//窗口标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//建立默认关闭按钮：退出程序
/*public void setDefaultCloseOperation(int operation)是JFrame的方法，当单击“关闭”按钮
 * 时，程序按照参数operation的值决定将执行的操作。*/
		//EXIT_ON_CLOSE:退出应用程序，该参数仅用于应用程序
		//HIDE_ON_CLOSE:默认值，用户关闭窗口后，窗口隐藏起来
		//DISPOSE_ON_CLOSE:用户关闭后，窗口消失并释放所有占有的资源
		/*DO_NOTHING_ON_CLOSE:用户关闭窗口后不做任何事，需要调用窗口监听器
 * 中的windowClosing()方法执行其他动作*/
		labell = new JLabel("这是一个简单的Swing实例");//给标签初始化
		Container myCP = getContentPane();//获得顶层容器的内容面板
		myCP.setBackground(Color.red);//设置背景颜色
		myCP.add(labell);//向窗口添加JLabel组件
		setSize(200,200);//设置窗口大小
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		SwingWindow sWindow = new SwingWindow();//实例化SwingWindow对象
		sWindow.show();//显示窗口 （setVisible(true)方法也可达到此目的）
	}
}
