package login.student;

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

public class Loin extends JFrame implements ActionListener{
	/**
	 * 
	 */
	final int JFHMAX = 1920;
	final int JFVMAX = 1080;
	private static final long serialVersionUID = 1L;
	private JLabel lbnum,lbna,lbm,lben,lbio,lbmc,lbja,lbjav;
	
	public Loin(final String Username){
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
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 jpbg.setOpaque(false);
		
		Connect cn = new Connect();		
		String name = new String(cn.getid(Username));
		this.setTitle(name+"的个人主页");
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenu menu1=new JMenu("个人信息");
		this.add(menu1);
		JMenu menu2=new JMenu("设置");
		this.add(menu2);
		JMenu menu3=new JMenu("退出");
		this.add(menu3);
		
		JMenuItem item11=new JMenuItem("个人基本信息查询");
		JMenuItem item12=new JMenuItem("修改个人信息");
		JMenuItem item13=new JMenuItem("查询个人课程成绩");
		menu1.add(item11);
		menu1.add(item12);
		menu1.add(item13);
		
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
			public void actionPerformed(ActionEvent e) {
			
					final JPanel jp1 = new JPanel();
					
					jp1.setBounds(0,20,JFHMAX,JFVMAX);
					jp1.setOpaque(false);
					setContentPane(jp1);					
					jp1.setLayout(null);
					

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
//					        Toolkit.getDefaultToolkit().beep(); 
					        ltime.setText(sdf.format(now));
						}
			        }); 
					
					
					JLabel lb1 = new JLabel("个人信息基本查询");
					lb1.setBounds(520,40,400,80);
					lb1.setFont(new Font("微软雅黑",Font.BOLD,40));
					jp1.add(lb1);
					
					JLabel lbid = new JLabel("学号:");
					lbid.setFont(new Font("微软雅黑",Font.BOLD,26));
					lbid.setBounds(450,110,100,40);
					jp1.add(lbid);
					
					Connect ct = new Connect();
					String bases[] = ct.getstubase(Username);
					
					JLabel lbnum = new JLabel();
					lbnum.setText(bases[0]);
					lbnum.setBounds(580,110,400,40);
					lbnum.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lbnum);
					
					JLabel lbname = new JLabel("姓名:");
					lbname.setFont(new Font("微软雅黑",Font.BOLD,26));
					lbname.setBounds(450,165,100,40);
					jp1.add(lbname);
					
					JLabel lbna = new JLabel();
					lbna.setText(bases[1]);
					lbna.setBounds(580,165,400,40);
					lbna.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lbna);
					
					JLabel lbage = new JLabel("年龄:");
					lbage.setFont(new Font("微软雅黑",Font.BOLD,26));
					lbage.setBounds(450,220,100,40);
					jp1.add(lbage);
					
					JLabel lage = new JLabel();
					lage.setText(bases[2]);
					lage.setBounds(580,220,400,40);
					lage.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lage);
					
					JLabel lsex = new JLabel("性别:");
					lsex.setBounds(450,280,200,40);
					lsex.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lsex);
					
					JLabel lbsex = new JLabel();
					lbsex.setText(bases[3]);
					lbsex.setBounds(580,280,100,40);
					lbsex.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lbsex);
					
					JLabel lbsd = new JLabel("学院:");
					lbsd.setBounds(450,350,200,40);
					lbsd.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lbsd);
					
					JLabel lsd = new JLabel();
					lsd.setText(bases[4]);
					lsd.setBounds(580,350,400,40);
					lsd.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lsd);
					
					JLabel lbsc = new JLabel("班级:");
					lbsc.setBounds(450,430,200,40);
					lbsc.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lbsc);
					
					JLabel lsc = new JLabel();
					lsc.setText(bases[5]);
					lsc.setBounds(580,430,400,40);
					lsc.setFont(new Font("微软雅黑",Font.BOLD,26));
					jp1.add(lsc);
					
					JButton jbexit = new JButton("返回");
					jbexit.setBounds(650,560,100,50);
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
		item12.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			
				AbstractButton item= (AbstractButton)e.getSource();
				if(item.getText().equals("修改个人信息")){
					SetStudentBase ssb = new SetStudentBase(Username);
					ssb.setVisible(true);
				}
			}
		});
		item13.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				final JPanel jp1 = new JPanel();
				jp1.setBounds(0,20,JFHMAX,JFVMAX);
				jp1.setOpaque(false);
				setContentPane(jp1);					
				jp1.setLayout(null);

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
				
				Connect ct = new Connect();
				String course[] = ct.getcourse(Username);
				
				JLabel lbchi = new JLabel("学期:");
				lbchi.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbchi.setBounds(450,200,100,40);
				jp1.add(lbchi);
				
				lbm = new JLabel();
				lbja = new JLabel();
				lbjav = new JLabel();
				lbmc = new JLabel();
				lbio = new JLabel();
				lben = new JLabel();
				lbna = new JLabel();
				lbnum = new JLabel();
				
				final	JComboBox<String> comboBox = new JComboBox<String>();
				comboBox.setBounds(580,200,100,30);
				comboBox.addItem("1");
				comboBox.addItem("2");
				comboBox.addItem("3");
				comboBox.addItem("4");
				comboBox.addItem("5");
				comboBox.addItem("6");
				comboBox.addItem("7");
				comboBox.addItem("8");
				comboBox.setEditable(true);
				jp1.add(comboBox);
				
				JButton btn = new JButton("确定");
				btn.setFont(new Font("微软雅黑",Font.PLAIN,20));
				btn.setBounds(690,200,90,30);
				jp1.add(btn);
				
				btn.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						Connect ct = new Connect();
						String course[] = ct.getcourse(Username, comboBox.getSelectedItem().toString());
						lbm.setText(course[3]);
						lben.setText(course[4]);
						lbio.setText(course[5]);
						lbmc.setText(course[6]);
						lbja.setText(course[7]);
						lbjav.setText(course[8]);
					}
				});
				
//				final JComboBox listerm = new JComboBox();
//				for(int i = 1; i<=6; i++){
//					listerm.addItem(i);
//				}
//				listerm.setBounds(580,200,100,40);
//				jp1.add(listerm);
//				listerm.addActionListener(new ActionListener(){
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// TODO 自动生成的方法存根
//						String term = (String)listerm.getSelectedItem();
//						System.out.println(term);
//						Connect ct = new Connect();
//						String course[] = ct.getcourse(Username, term);
//						//lbna,lbm,lben,lbio,lbmc,lbja,lbjav
//						lbnum.setText(course[0]);
//						lbna.setText(course[1]);
//						lbm.setText(course[3]);
//						lben.setText(course[4]);
//						lbio.setText(course[5]);
//						lbmc.setText(course[6]);
//						lbja.setText(course[7]);
//						lbjav.setText(course[8]);
//					}
//				});
				
				JLabel lb1 = new JLabel("查询个人课程成绩");
				lb1.setBounds(520,20,400,80);
				lb1.setFont(new Font("微软雅黑",Font.BOLD,36));
				jp1.add(lb1);
				
				JLabel lbid = new JLabel("学号:");
				lbid.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbid.setBounds(450,100,100,40);
				jp1.add(lbid);
				

				lbnum.setText(course[0]);
				lbnum.setBounds(580,100,400,40);
				lbnum.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbnum);
				
				JLabel lbname = new JLabel("姓名:");
				lbname.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbname.setBounds(450,150,100,40);
				jp1.add(lbname);
				

				lbna.setText(course[1]);
				lbna.setBounds(580,150,400,40);
				lbna.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbna);
				
				JLabel lbma = new JLabel("文学:");
				lbma.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbma.setBounds(450,250,100,40);
				jp1.add(lbma);
				

				lbm.setText(course[3]);
				lbm.setBounds(580,250,400,40);
				lbm.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbm);
				
				JLabel lbe = new JLabel("高等数学:");
				lbe.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbe.setBounds(400,300,200,40);
				jp1.add(lbe);
				
	
				lben.setText(course[4]);
				lben.setBounds(580,300,400,40);
				lben.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lben);
				
				JLabel lbi = new JLabel("英语:");
				lbi.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbi.setBounds(450,350,100,40);
				jp1.add(lbi);
				

				lbio.setText(course[5]);
				lbio.setBounds(580,350,400,40);
				lbio.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbio);
				
				JLabel lbme = new JLabel("物联网:");
				lbme.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbme.setBounds(435,400,120,40);
				jp1.add(lbme);
				

				lbmc.setText(course[6]);
				lbmc.setBounds(580,400,400,40);
				lbmc.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbmc);
				
				JLabel lbj = new JLabel("健康:");
				lbj.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbj.setBounds(450,450,100,40);
				jp1.add(lbj);
				

				lbja.setText(course[7]);
				lbja.setBounds(580,450,400,40);
				lbja.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbja);
				
				JLabel lbav = new JLabel("Java:");
				lbav.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbav.setBounds(435,500,120,40);
				jp1.add(lbav);
				

				lbjav.setText(course[8]);
				lbjav.setBounds(580,500,400,40);
				lbjav.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbjav);
				
				JButton jbexit = new JButton("返回");
				jbexit.setBounds(650,550,100,50);
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
				
				JLabel lb1 = new JLabel("修改个人密码");
				lb1.setBounds(520,40,400,80);
				lb1.setForeground(Color.red);
				lb1.setFont(new Font("微软雅黑",Font.BOLD,40));
				jp1.add(lb1);
				
				JLabel lbid = new JLabel("学号:");
				lbid.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbid.setBounds(450,110,100,40);
				jp1.add(lbid);
				
				Connect ct = new Connect();
				String bases[] = ct.getstubase(Username);
				
				JLabel lbnum = new JLabel();
				lbnum.setText(bases[0]);
				lbnum.setBounds(580,110,400,40);
				lbnum.setFont(new Font("微软雅黑",Font.BOLD,26));
				jp1.add(lbnum);
				
				JLabel lbname = new JLabel("姓名:");
				lbname.setFont(new Font("微软雅黑",Font.BOLD,26));
				lbname.setBounds(450,165,100,40);
				jp1.add(lbname);
				
				JLabel lbna = new JLabel();
				lbna.setText(bases[1]);
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
				
				JButton jbadd = new JButton("添加");
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
// 		？？？？
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
		Loin lo = new Loin("202106104113");
		lo.setVisible(true);
	}
}
