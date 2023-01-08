package login.teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import login.inter.MainFrame;
import mysql.Connect;

public class Login extends JFrame implements ActionListener{
	/**
	 * 
	 */
	final int JFHMAX = 1920;
	final int JFVMAX = 1080;
	private static final long serialVersionUID = 1L;
	final String Username = "202106104113";
	
	public Login(){
		super();
		JPanel jpbg = new JPanel();
		 setContentPane(jpbg);
		 GridLayout gird = new GridLayout(3,0);
		 jpbg.setLayout(gird);
		 ImageIcon img = new ImageIcon("images\\RC.png");
		 JLabel imgLabel = new JLabel(img);
		 getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		 imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		 getLayeredPane().setLayout(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jpbg.setOpaque(false);
		
		this.setTitle("学生信息管理");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenu menu1=new JMenu("学生信息");
		this.add(menu1);
		JMenu menu2=new JMenu("设置");
		this.add(menu2);
		JMenu menu3=new JMenu("退出");
		this.add(menu3);
		
		JMenuItem item11=new JMenuItem("基本信息查询");
		JMenuItem item12=new JMenuItem("查询课程成绩");

		menu1.add(item11);
		menu1.add(item12);
		
		JMenuItem item21 = new JMenuItem("更改密码");
		menu2.add(item21);
		
		JMenuItem item31 = new JMenuItem("退出账号");
		JMenuItem item32 = new JMenuItem("退出程序");
		
		menu3.add(item31);
		menu3.add(item32);
		
		JMenuBar br=new JMenuBar();
		br.add(menu1);
		br.add(menu2);
		br.add(menu3);
		this.setJMenuBar(br);
		
		item31.addActionListener(this);
		item32.addActionListener(this);
		
		item11.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//信息
				StuBase st = new StuBase();
				st.setVisible(true);
			}
		});	

		item12.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//课程
				StuCourse st = new StuCourse();
				st.setVisible(true);
			}
		});
		
		item21.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//修改个人密码
				final JPanel jp1 = new JPanel();
				
				jp1.setBounds(0,20,JFHMAX,JFVMAX);
				jp1.setOpaque(false);
				setContentPane(jp1);					
				jp1.setLayout(null);
				
				JLabel lb1 = new JLabel("修改管理员密码");
				lb1.setBounds(520,40,400,80);
				lb1.setForeground(Color.red);
				lb1.setFont(new Font("微软雅黑",Font.BOLD,40));
				jp1.add(lb1);
				
				
				JLabel lbname = new JLabel("管理员:");
				lbname.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbname.setBounds(450,165,100,40);
				jp1.add(lbname);
				
				JLabel lbna = new JLabel();
				lbna.setText("root");
				lbna.setBounds(580,170,400,40);
				lbna.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbna);
				
				JLabel lbpa1 = new JLabel();
				lbpa1.setText("密码：");
				lbpa1.setBounds(450,240,100,30);
				lbpa1.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbpa1);
				
				final JPasswordField jt1 = new JPasswordField();
				jt1.setBounds(570,243,250,30);
				jt1.setFont(new Font("微软雅黑",Font.BOLD,20));
				jt1.setEchoChar('*');
				jp1.add(jt1);
				
				JLabel lbpa2 = new JLabel();
				lbpa2.setText("请输入新密码：");
				lbpa2.setBounds(400,300,180,30);
				lbpa2.setFont(new Font("微软雅黑",Font.BOLD,22));
				jp1.add(lbpa2);
				
				final JPasswordField jt2 = new JPasswordField();
				jt2.setBounds(570,303,250,30);
				jt2.setFont(new Font("微软雅黑",Font.BOLD,26));
				jt2.setEchoChar('*');
				jp1.add(jt2);
				
				JLabel lbpa3 = new JLabel();
				lbpa3.setText("再次请输入新密码：");
				lbpa3.setBounds(375,360,200,30);
				lbpa3.setFont(new Font("微软雅黑",Font.BOLD,22));
				jp1.add(lbpa3);
				
				final JPasswordField jt3 = new JPasswordField();
				jt3.setBounds(570,363,250,30);
				jt3.setFont(new Font("微软雅黑",Font.BOLD,26));
				jt3.setEchoChar('*');
				jp1.add(jt3);
				
				final JLabel ltime = new JLabel();
				ltime.setFont(new Font("微软雅黑",Font.BOLD,26));
				ltime.setForeground(Color.red);
				ltime.setBounds(50,50,400,60);
				jp1.add(ltime);
				
				final Timer t = new Timer(1000, new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						Date now = new Date();  
				        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// DateFomat的子类。  
				        System.out.println("现在时刻：" + sdf.format(now));  
//				        Toolkit.getDefaultToolkit().beep(); 
				        ltime.setText(sdf.format(now));
					}
		        }); 
				
				JButton jbadd = new JButton("修改");
				jbadd.setFont(new Font("微软雅黑",Font.BOLD,26));
				jbadd.setBounds(420,440,100,50);
				jp1.add(jbadd);
				jbadd.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						@SuppressWarnings("deprecation")
						String pa1 = jt1.getText().toString();
						@SuppressWarnings("deprecation")
						String pa2 = jt2.getText().toString();
						@SuppressWarnings("deprecation")
						String pa3 = jt3.getText().toString();
//						System.out.println("1:"+pa1+", 2:"+pa2);
						int i = pa1.compareTo("");
						int j = pa2.compareTo("");
						int k = pa3.compareTo("");
//						System.out.println("1:"+i+", 2:"+j);
						if(i==0||j==0||k==0){
							JOptionPane.showMessageDialog(null, "密码不能为空!");
						}else{
							if(Connect.compare(Username, pa1, 0)){
								System.out.println("username="+Username+"pa1="+pa1);
								if(pa2.equals(pa3)){
									Connect cn = new Connect();
									cn.changepass(Username, pa2);
									System.out.println("username="+Username+"pa2="+pa2);
									System.out.println("username="+Username+"pa3="+pa3);
									JOptionPane.showMessageDialog(null, "修改成功!");
									jt1.setText("");
									jt2.setText("");
									jt3.setText("");
								}else{
									JOptionPane.showMessageDialog(null, "两次输入的密码不一致!");
								}
							}else{
								JOptionPane.showMessageDialog(null, "原密码错误!");
							}
						}
					}
				});
				JButton jbre= new JButton("重置");
				jbre.setFont(new Font("微软雅黑",Font.BOLD,26));
				jbre.setBounds(580,440,100,50);
				jp1.add(jbre);
				jbre.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						jt1.setText("");
						jt2.setText("");
						jt3.setText("");
					}
					
				});
				
				JButton jbexit = new JButton("返回");
				jbexit.setFont(new Font("微软雅黑",Font.BOLD,26));
				jbexit.setBounds(740,440,100,50);
				jp1.add(jbexit);
				
				t.start();        
					jbexit.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							jp1.setVisible(false);
							t.stop();
						}
					});
					jp1.setVisible(true);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {	
		AbstractButton item= (AbstractButton)e.getSource();
		if(item.getText().equals("退出账号")){
			this.dispose();
			JOptionPane.showMessageDialog(null, "退出成功!");
			MainFrame mf = new MainFrame();
			mf.setVisible(true);
		}
		if(item.getText().equals("退出程序")){
			System.exit(0);
		}
	}
	
	public static void main(String[] args){
		Login lo = new Login();
		lo.setVisible(true);
	}
	
}

