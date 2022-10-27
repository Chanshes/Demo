package login.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import mysql.Connect;

public class AddStudentBase extends JFrame implements ActionListener{
	String Username = null;
    private static final long serialVersionUID=1L;
    JLabel JL=new JLabel("��Ӹ�����Ϣ",JLabel.CENTER);
    JLabel JLNumber=new JLabel("ѧ�ţ�");
    JTextField JTNumber;

    JLabel JLName=new JLabel("������");
    JTextField JTName=new JTextField();

    JLabel JLClass=new JLabel("�༶��");
    JTextField JTClass=new JTextField();

    JLabel JLsex=new JLabel("�Ա�");
    ButtonGroup BG=new ButtonGroup();
    JRadioButton JRB1;
    JRadioButton JRB2;

    JLabel JL1=new JLabel("ѧԺ��");
    JTextField JT1=new JTextField();

    JLabel JL2=new JLabel("���䣺");
    JTextField JT2=new JTextField();

    JButton JBAdd=new JButton("���");
    JButton JBNext=new JButton("����");
    JButton JBExit=new JButton("����");

    String sql="";

    public AddStudentBase(){	

    	JPanel jpbg = new JPanel();
		 setContentPane(jpbg);
		 GridLayout gird = new GridLayout(3,0);
		 jpbg.setLayout(gird);
		 ImageIcon img = new ImageIcon("images\\R-C.png");
		 JLabel imgLabel = new JLabel(img);
		 getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		 imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		 getLayeredPane().setLayout(null);
		 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 jpbg.setOpaque(false);
     	
		 JRB1 = new JRadioButton("��");
		 JRB2 = new JRadioButton("Ů");
		 
		 JTNumber=new JTextField();
		 JTNumber.setText("");
		 this.setTitle("���ѧ����Ϣ");
		 this.setLayout(null);

		 JL.setForeground(Color.yellow);
		 JL.setForeground(new Color(0,200,200));
		 JL.setFont(new java.awt.Font("΢���ź�",Font.PLAIN+Font.BOLD,22));
		 JL.setBounds(120,30,200,40);
		 this.add(JL);

        JLNumber.setBounds(100,80,100,20);
        this.add(JLNumber);
        JLNumber.setFont(new java.awt.Font("΢���ź�",Font.BOLD,15));
        JTNumber.setBounds(190,80,100,20);
        this.add(JTNumber);

        JLName.setBounds(100,120,60,20);
        this.add(JLName);
        JLName.setFont(new java.awt.Font("΢���ź�",Font.BOLD,15));
        JTName.setBounds(200,120,80,20);
        this.add(JTName);

        JLsex.setBounds(100,160,100,20);
        JLsex.setFont(new java.awt.Font("΢���ź�",Font.BOLD,15));
        this.add(JLsex);
        JRB1.setBounds(200,160,40,20);
        JRB2.setBounds(250,160,40,20);
        JRB1.setOpaque(false);
        JRB2.setOpaque(false);
        this.add(JRB1);
        this.add(JRB2);
        BG.add(JRB1);
        BG.add(JRB2);

        JL2.setBounds(100,200,80,20);
        JL2.setFont(new java.awt.Font("΢���ź�",Font.BOLD,15));
        this.add(JL2);
        JT2.setBounds(200,200,80,20);
        this.add(JT2);

        JLClass.setBounds(100,240,60,20);
        this.add(JLClass);
        JTClass.setBounds(200,240,80,20);
        this.add(JTClass);

        JL1.setBounds(100,280,60,20);
        JL1.setFont(new java.awt.Font("΢���ź�",Font.BOLD,15));
        this.add(JL1);
        JT1.setBounds(190,280,100,20);
        this.add(JT1);

        JBAdd.setBounds(80,320,90,20);
        this.add(JBAdd);
        JBAdd.addActionListener(this);

        JBNext.setBounds(190,320,90,20);
        this.add(JBNext);
        JBNext.addActionListener(this);

        JBExit.setBounds(300,320,90,20);
        this.add(JBExit);
        JBExit.addActionListener(this);
        
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });


    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==JBAdd)
        { 	
            String id=JTNumber.getText();
            String name=JTName.getText();
            String sex="Ů";
            if(JRB1.isSelected())
                sex="��";
            String age=JT2.getText();
            String school=JTClass.getText();
            String sdept=JT1.getText(); 
            
            int i = id.compareTo("");
            int j = name.compareTo("");
            int k = sex.compareTo("");
            int l = age.compareTo("");
            int o = school.compareTo("");
            int p = sdept.compareTo("");
            if(i==0||j==0||k==0||l==0||o==0||p==0){
            	JOptionPane.showMessageDialog(null, "������������Ϣ");
            }else{
            	boolean cn = Connect.addbases(id, name, age, sex, sdept, school);
            	if(cn == true){
            		JOptionPane.showMessageDialog(null, "��ӳɹ���");
            		setVisible(false);
            		new StuBase().setVisible(true);
            	}else{
            		JOptionPane.showMessageDialog(null, "�˺��Ѵ��ڣ�");
            	}
            }
        }

        if(e.getSource()==JBNext){
        	 JTNumber.setText(null);
    		 JTName.setText(null);
    		 JT2.setText(null);
    		 JT1.setText(null);
    		 JTClass.setText(null);	
        }

        if(e.getSource()==JBExit){
            setVisible(false);  
            new StuBase().setVisible(true);
        }
    }
    
    
    
    public static void main(String args[])
    {
        new AddStudentBase();
    }
}