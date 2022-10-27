package unit9;
//面板的简单应用。
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JPanelApp extends JFrame{
	private JPanel panel1, panel2;
	JPanelApp(){
		setTitle("面板的应用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new JPanel();
		panel1.setBackground(Color.RED);
		for(int i=1;i<5;i++)
			panel1.add(new Button(""+i));
		panel2 = new JPanel(new BorderLayout());
		panel2.setBackground(Color.YELLOW);
		panel2.add(new Button("1"),"North");
		panel2.add(new Button("2"),"South");
		panel2.add(new Button("3"),"East");
		panel2.add(new Button("4"),"West");
		getContentPane().add(panel1, "North");
		getContentPane().add(panel2, "Center");
		setSize(240,200);
	}
	public static void main(String[] args){
		JPanelApp frame = new JPanelApp();
		frame.setVisible(true);
	}
}
