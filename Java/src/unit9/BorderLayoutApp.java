package unit9;
//例9-7 BorderLayout 的简单应用。
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BorderLayoutApp extends JFrame{
	private JButton northButton,southButton,eastButton,westButton,centerButton;
	public BorderLayoutApp(){
		setTitle("BorderLayout 布局");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		Container cp = getContentPane();
		northButton = new JButton("北面");
		southButton = new JButton("南面");
		eastButton = new JButton("东面");
		westButton = new JButton("西面");
		centerButton = new JButton("中间");
		cp.add(northButton,BorderLayout.NORTH);
		cp.add(southButton,BorderLayout.SOUTH);
		cp.add(eastButton,BorderLayout.EAST);
		cp.add(westButton,BorderLayout.WEST);
		cp.add(centerButton,BorderLayout.CENTER);
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		BorderLayoutApp  frame = new BorderLayoutApp();
		frame.show();//show()方法过时被setVisible(boolean)代替
	}
}
