package unit9;
//例9-2 JFrame中标与按钮的显示
import javax.swing.*;
import java.awt.*;//引入包

@SuppressWarnings("serial")
public class FrameApp extends JFrame{
	JLabel label;
	JButton button1,button2;
	public FrameApp(){
		super("JFrame 窗口");//设置框架的标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("Photos/sun.gif");/*定义了一个ImageIcon对象，在
下一行JLabel中将该图标加入到标签中*/
		label = new JLabel("JFrame应用，标签显示图标",icon,JLabel.LEFT);
/*标签的构造方法"JLabel(String text, Icon icon, int horizontalAlignment)" 能同时将文字
 * 和图标显示在标签上。参数horizontalAlignment指定了标签的水平对齐方式，取值为Swing的常
 * 量：LEFT,CENTER,RIGHT,LEADING和TRAILING*/
		button1 = new JButton("按钮1");
		button2 = new JButton("按钮2");
		Container cp = getContentPane();//获取框架的内容面板
		cp.add(label,"Center");
		cp.add(button2,"South");//布局 North South West East Center这五个方位
		cp.add(button1,"North");//将控件添加到框架的内容面板中去
		setSize(200,200);
	/*设置框架的大小
	 * pack()方法自动调整框架的大小为框架中组件所占用的大小。如果JFrame中不包
	 * 含组件，则只显示框架的标题栏*/
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		FrameApp frame = new FrameApp();
		frame.show();//显示框架
	}
}
