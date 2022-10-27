package unit9;
//例9-13 下拉列表的简单应用。
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class JComboBoxApp extends JFrame{
	private JLabel picture;
	@SuppressWarnings("rawtypes")
	private JComboBox imgList;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBoxApp(){
		super("组合列表框的应用");
		imgList = new JComboBox();
		imgList.setEditable(true);
		for(int i=1; i<6; i++)
			imgList.addItem("images"+i+".gif");
		imgList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String imgName = (String)imgList.getSelectedItem();
				picture.setIcon(new ImageIcon("image/"+imgName));
			}
		});
		picture = new JLabel(new ImageIcon("image/"+imgList.getSelectedItem()));
		picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		getContentPane().add(imgList, BorderLayout.NORTH);
		getContentPane().add(picture, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(340,300);
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		JComboBoxApp frame = new JComboBoxApp();
		frame.show();
	}
}
