package login.teacher;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mysql.Connect;

public class AddStuCourse extends JFrame implements ActionListener{
	/**
	 * 添加成绩
	 */
	private static final long serialVersionUID = 1L;

	JLabel j0=new JLabel("学号:");
	JTextField J0 = new JTextField();

	JLabel j1=new JLabel("姓名:");
	JTextField J1 = new JTextField();
	
	JLabel j2=new JLabel("学期:");
	JTextField J2=new JTextField();
	
	JLabel j3=new JLabel("文学:");
	JTextField J3=new JTextField();
	
	JLabel j4=new JLabel("高数:");
	JTextField J4=new JTextField();
	
	JLabel j5=new JLabel("英语:");
	JTextField J5=new JTextField();
	
	JLabel j6=new JLabel("物联网:");
	JTextField J6=new JTextField();
	
	JLabel j7=new JLabel("健康:");
	JTextField J7=new JTextField();
	
	JLabel j8=new JLabel("Java:");
	JTextField J8=new JTextField();
	
    JButton jb1 =new JButton("添加");
    JButton jb2 =new JButton("重置");
    JButton jb3 =new JButton("返回");
	
	public AddStuCourse(){
		super();
		JPanel jpbg = new JPanel();
		setContentPane(jpbg);
		GridLayout gird = new GridLayout(3,0);
		jpbg.setLayout(gird);
		ImageIcon img = new ImageIcon("images\\R-C.png");
		JLabel imgLabel = new JLabel(img);
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		getLayeredPane().setLayout(null);
		jpbg.setOpaque(false);
		
		 this.setTitle("添加学生成绩");
		 this.setLayout(null);
		 this.setSize(700,540);
		 this.setResizable(false);
		 this.setLocationRelativeTo(null);
		 
		 Container cp = getContentPane();
		 
	     j0.setForeground(Color.RED);
	     j0.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j0.setBounds(120,30,200,30);
	     cp.add(j0);

	     J0.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J0.setBounds(180,30,200,30);
	     cp.add(J0);
	     
	     j1.setForeground(Color.RED);
	     j1.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j1.setBounds(120,80,200,30);
	     cp.add(j1);

	     J1.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J1.setBounds(180,80,200,30);
	     cp.add(J1);
	     
	     j2.setForeground(Color.RED);
	     j2.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j2.setBounds(120,130,200,30);
	     cp.add(j2);

	     J2.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J2.setBounds(180,130,200,30);
	     cp.add(J2);
	     
	     j3.setForeground(Color.RED);
	     j3.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j3.setBounds(120,180,200,30);
	     cp.add(j3);

	     J3.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J3.setBounds(180,180,200,30);
	     cp.add(J3);
	     
	     j4.setForeground(Color.RED);
	     j4.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j4.setBounds(120,230,200,30);
	     cp.add(j4);

	     J4.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J4.setBounds(180,230,200,30);
	     cp.add(J4);
	     
	     j5.setForeground(Color.RED);
	     j5.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j5.setBounds(120,280,200,30);
	     cp.add(j5);

	     J5.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J5.setBounds(180,280,200,30);
	     cp.add(J5);
	     
	     j6.setForeground(Color.RED);
	     j6.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j6.setBounds(105,330,200,30);
	     cp.add(j6);

	     J6.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J6.setBounds(180,330,200,30);
	     cp.add(J6);
	     
	     j7.setForeground(Color.RED);
	     j7.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j7.setBounds(120,380,200,30);
	     cp.add(j7);

	     J7.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J7.setBounds(180,380,200,30);
	     cp.add(J7);
		 
	     j8.setForeground(Color.RED);
	     j8.setFont(new java.awt.Font("微软雅黑",Font.PLAIN+Font.BOLD,22));
	     j8.setBounds(120,430,200,30);
	     cp.add(j8);

	     J8.setFont(new java.awt.Font("微软雅黑",Font.BOLD,15));
	     J8.setBounds(180,430,200,30);
	     cp.add(J8);
	     
	     jb1.setFont(new java.awt.Font("微软雅黑",Font.BOLD,24));
	     jb1.setBounds(460,60,150,70);
	     jb1.addActionListener(this);
	     cp.add(jb1);
	    
	     jb2.setFont(new java.awt.Font("微软雅黑",Font.BOLD,24));
	     jb2.setBounds(460,210,150,70);
	     jb2.addActionListener(this);
	     cp.add(jb2);
	     
	     jb3.setFont(new java.awt.Font("微软雅黑",Font.BOLD,24));
	     jb3.setBounds(460,360,150,70);
	     jb3.addActionListener(this);
	     cp.add(jb3);
	     
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == jb1){
			  String q0=J0.getText();
			  String q1=J1.getText();
			  String q2=J2.getText();
			  String q3=J3.getText();
			  String q4=J4.getText();
			  String q5=J5.getText(); 
			  String q6=J6.getText(); 
			  String q7=J7.getText(); 
			  String q8=J8.getText(); 
			  
			  Connect ct = new Connect();
			  boolean b = ct.addcourses(q0, q1, q2, q3, q4, q5, q6, q7, q8);
			  if(b == true){
				  JOptionPane.showMessageDialog(null, "添加成功！");
				  setVisible(false);  
				  new StuCourse().setVisible(true);
			  }else{
				  JOptionPane.showMessageDialog(null, "添加失败！");
			  }
		}
		if(e.getSource() == jb2){
    		 J0.setText("");
    		 J1.setText("");
    		 J2.setText("");
    		 J3.setText("");
    		 J4.setText("");
    		 J5.setText("");
    		 J6.setText("");
    		 J7.setText("");
    		 J8.setText("");   		 
		}
		if(e.getSource()==jb3){
			 setVisible(false);   
			 new StuCourse().setVisible(true);
		}
		
		
	}
	
	public static void main(String[] args){
		new AddStuCourse().setVisible(true);
	}
}
