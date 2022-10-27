package unit9;
//例9-8  FlowLayout 的简单应用
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class FlowLayoutApp extends JFrame{
	private JButton oneButton, twoButton, threeButton, fourButton, fiveButton;
	private FlowLayout layout;
	public FlowLayoutApp(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FlowLayout 的应用");
		layout = new FlowLayout(FlowLayout.LEFT);
		setSize(300,200);
		Container cp = getContentPane();
		cp.setLayout(layout);
		oneButton = new JButton("按钮1");
		twoButton = new JButton("按钮2");
		threeButton = new JButton("第三个按钮");
		fourButton = new JButton("按钮4");
		fiveButton = new JButton("按钮5");
		cp.add(oneButton);
		cp.add(twoButton);
		cp.add(threeButton);
		cp.add(fourButton);
		cp.add(fiveButton);
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		FlowLayoutApp frame = new FlowLayoutApp();
		frame.show();
	}
}
