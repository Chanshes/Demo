package login.inter;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import login.student.Loin;
import login.teacher.Login;
import mysql.Connect;

public class MainFrame extends JFrame implements ItemListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
		try {
//			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//			 javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			 javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
//			 javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//			 javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
//			 javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
//			 javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//			 javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	private static String Username;
	private static String Password;
	
    private JTextField codeText;
    private JPasswordField pwdText;
    private JTextField nameText;
    private JButton bo;
    JRadioButton rb1, rb2;
    ImageCodePanel imageCode = null;
    
    int i = 0;//标记保存RadioButton事件
    
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public MainFrame() {
        super();
        setTitle("登录");
        this.setSize(440,240);
        setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel jpbg = new JPanel();
		 setContentPane(jpbg);
		 GridLayout gird = new GridLayout(3,0);
		 jpbg.setLayout(gird);
		 ImageIcon img = new ImageIcon("images\\background.png");
		 JLabel imgLabel = new JLabel(img);
		 getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		 imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		 getLayeredPane().setLayout(null);
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 jpbg.setOpaque(false);
        
		 Container cp =getContentPane();
		 cp.setLayout(null);
		 imageCode = new ImageCodePanel();
		 imageCode.setBounds(170, 110, 100, 30);
		 cp.add(imageCode);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (imageCode != null) {
                    imageCode.draw(); // 调用方法生成验证码
                }
            }
        });
        button.setText("换一张");
        button.setBounds(280, 110, 70, 26);
        cp.add(button);
        
        final JLabel label = new JLabel();
        label.setText("教务管理系统");
        label.setBounds(145, 5, 300, 40);
        label.setFont(new Font("宋体",Font.BOLD,26));
        cp.add(label); 
        
        final JLabel label_1 = new JLabel();
        label_1.setText("用户名：");
        label_1.setBounds(29, 60, 66, 18);
        label_1.setFont(new Font("微软雅黑",Font.PLAIN,15));
        cp.add(label_1);
        
        final JLabel label_2 = new JLabel();
        label_2.setText("密   码：");
        label_2.setBounds(29, 85, 66, 18);
        label_2.setFont(new Font("微软雅黑",Font.PLAIN,15));
        cp.add(label_2);
        
        nameText = new JTextField();
        nameText.setBounds(85, 60, 310, 22);
        cp.add(nameText);
        
        pwdText = new JPasswordField();
        pwdText.setBounds(85, 85, 310, 22);
        cp.add(pwdText);
        
        rb1 = new JRadioButton("",true);
        rb2 = new JRadioButton();
        rb1.setText("学生");
        rb1.setBounds(140,140,60,20);
        rb2.setText("老师");
        rb2.setBounds(200,140,60,20);
        rb1.setOpaque(false);
        rb2.setOpaque(false);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        cp.add(rb1);
        cp.add(rb2);
        
        rb1.addItemListener(this);
        rb2.addItemListener(this);
       if(rb1.isSelected()){
    	   i = 0;
       }else if(rb2.isSelected()){
    	   i = 1;
       }
        
        bo = new JButton("注册");
        bo.setBounds(220, 163, 100, 28);
        bo.addActionListener(this);
        cp.add(bo);
        
        final JLabel label_3 = new JLabel();
        label_3.setText("验证码：");
        label_3.setBounds(29, 110, 66, 18);
        label_3.setFont(new Font("微软雅黑",Font.PLAIN,15));
        cp.add(label_3);
        
        codeText = new JTextField();
        codeText.setBounds(85, 110, 77, 22);
        cp.add(codeText);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
 
			public void actionPerformed(final ActionEvent e) {
                 Username =new String(nameText.getText());// 从文本框中获取用户名
                 Password = new String(pwdText.getPassword());// 从密码框中获取密码
                String code = codeText.getText();// 获得输入的验证码
                String info = "";// 用户登录信息
                // 判断用户名是否为null或空的字符串             
                if (Username == null || Username.isEmpty()||Username.length() == 0) {
                    info = "用户名为空！";
                    imageCode.draw();
                }
                
                else if (Password == null || Password.isEmpty()) {
                    info = "密码为空！";
                    imageCode.draw();
                }
 
                else if (code == null || code.isEmpty()) {
                    info = "验证码为空！";
                    imageCode.draw();
                }
               
                else if (!code.equalsIgnoreCase(imageCode.getNum())) {
                    info = "验证码错误！";
                    imageCode.draw();
                }
                else if (Connect.compare(Username, Password,i)) {
                    info = "登录成功!";
                    setVisible(false);
                    if(i == 0){
                    	Loin lo = new Loin(Username);
                    	lo.setVisible(true);
                    }else{
                    	Login lo = new Login();
                    	lo.setVisible(true);
                    }
                } else {
                	info = "用户名或密码错误！";
                	imageCode.draw();
                }
                JOptionPane.showMessageDialog(null, info);// 通过对话框弹出用户登录信息
            }
        });
        button_1.setText("登  录");
        button_1.setBounds(115, 163, 100, 28);
        cp.add(button_1);
        
        final JButton button_1_1 = new JButton();
        button_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                nameText.setText("");
                pwdText.setText("");
                codeText.setText("");
            }
        });
        button_1_1.setText("重置");
        button_1_1.setBounds(350, 110, 50, 26);
        button_1_1.setFont(new Font("微软雅黑",Font.PLAIN,12));
        cp.add(button_1_1);
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自动生成的方法存根
		//选择单选按钮改变，sql语言使切换老师或学生
		if(e.getSource() == rb1){
			i = 0;
		}else{
			i =1;
		}
		
	}
	public static String getid(){
		System.out.println("学号:"+Username);
		return Username;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource() == bo)
		{
			this.setVisible(false);
			Adduser au = new Adduser();
			au.setVisible(true);
		}
	}
    
}