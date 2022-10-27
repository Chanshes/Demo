package unit9;
//例9-10 BoxLayout 的简单应用
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class BoxLayoutApp extends JFrame{
	public BoxLayoutApp(){
		super("BoxLayout 实例");
		setSize(300,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final int SIZE = 3;
		Container c = getContentPane();
		c.setLayout(new BorderLayout(30,30));
		Box [] boxes = new Box[4];
		boxes[0] = Box.createHorizontalBox();
		boxes[1] = Box.createVerticalBox();
		boxes[2] = Box.createHorizontalBox();
		boxes[3] = Box.createVerticalBox();
		for(int i = 0;i<4;i++){
			for(int j=0;j<SIZE;j++)
				boxes[i].add(new JButton("数组"+i+":"+j));
		c.add(boxes[0],BorderLayout.NORTH);
		c.add(boxes[1],BorderLayout.EAST);
		c.add(boxes[2],BorderLayout.SOUTH);
		c.add(boxes[3],BorderLayout.WEST);
		}
	}
	public static void main(String[] args){
		BoxLayoutApp f = new BoxLayoutApp();
		f.setVisible(true);
	}
}