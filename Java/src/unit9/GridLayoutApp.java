package unit9;
//例9-9 GridLayout 的简单应用。`								 
import java.awt.*;
import javax.swing.*;

public class GridLayoutApp {
	@SuppressWarnings("deprecation") 
	public static void main(String[] args){
		JFrame frame = new JFrame();
		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(4,3,5,5));
		for(int i = 1; i <= 12; i++){
			cp.add(new Button(Integer.toString(i)));
		}
		frame.setTitle("GridLayout 的应用");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.show();
	}
}
