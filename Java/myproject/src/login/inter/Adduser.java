package login.inter;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import inmain.InMain;
import mysql.Connect;

public class Adduser extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField jt1, jna;
	private JPasswordField jp1,jp2;
	private JLabel name;
	private JLabel lb1,lb2,lb3;
	private JButton jb1,jb2; 
	
	public Adduser(){
		super();
		this.setTitle("◊¢≤·");
		setSize(400,250);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(null);
		
		name = new JLabel();
		name.setText("Í«≥∆");
		name.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,15));
		name.setBounds(50,13,40,20);
		cp.add(name);
		
		jna = new JTextField();
		jna.setBounds(100,10,200,30);
		cp.add(jna);		
		
		lb1 = new JLabel();
		lb1.setText("’À∫≈");
		lb1.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,15));
		lb1.setBounds(50,53,40,20);
		cp.add(lb1);
		
		jt1 = new JTextField();
		jt1.setBounds(100,50,200,30);
		cp.add(jt1);		
		
		lb2 = new JLabel();
		lb2.setText("√‹¬Î");
		lb2.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,15));
		lb2.setBounds(50,93,40,20);
		cp.add(lb2);
		
		lb3 = new JLabel();
		lb3.setText("»∑»œ√‹¬Î");
		lb3.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,14));
		lb3.setBounds(40,133,60,20);
		cp.add(lb3);
		
		jp1 = new JPasswordField();
		jp1.setBounds(100,90,200,30);
		jp1.setEchoChar('*');
		cp.add(jp1);	
		
		jp2 = new JPasswordField();
		jp2.setBounds(100,130,200,30);
		jp2.setEchoChar('*');
		cp.add(jp2);	
		
		jb1 = new JButton();
		jb1.setText("◊¢≤·");
		jb1.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,14));
		jb1.setBounds(100,170,80,30);
		jb1.addActionListener(this);
		cp.add(jb1);
		
		jb2 = new JButton();
		jb2.setText("÷ÿ÷√");
		jb2.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,14));
		jb2.setBounds(200,170,80,30);
		jb2.addActionListener(this);
		cp.add(jb2);
		
	}
	public static void main(String[] args){
		Adduser au = new Adduser();
		au.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO ◊‘∂Ø…˙≥…µƒ∑Ω∑®¥Ê∏˘
		 String Username = jt1.getText();
         String Password1 = new String(jp1.getPassword());
         String Password2 = new String(jp2.getPassword());
         String Name = new String(jna.getText());
         
		if(e.getSource() == jb1){
			System.out.println("’Àªß£∫"+Username);
			System.out.println("√‹¬Î1£∫"+Password1);
			System.out.println("√‹¬Î2£∫"+Password2);
			int i = Username.compareTo("");
			int j = Password1.compareTo("");
			int l = Name.compareTo("");
			System.out.println(i);
			if(l != 0){		
					if(i != 0){
						if(j != 0){
							if(Password1.equals(Password2)){
								Connect co = new Connect();
								if(co.compareuser(Username)){
									JOptionPane.showMessageDialog(null, "’À∫≈“—¥Ê‘⁄!");
								}else{	 
									boolean bo = co.adduserAccount(Username,Password1);
									co.addbase(Username, Name);
									co.addcourse(Username, Name);
									if(bo){
										JOptionPane.showMessageDialog(null, "◊¢≤·≥…π¶£°");
									}
									this.dispose();
									@SuppressWarnings("unused")
									InMain m = new InMain();	
								}
							}else{
								JOptionPane.showMessageDialog(null, "¡Ω¥Œ ‰»Î√‹¬Î≤ª“ª÷¬£°");
							}
						}else{
							JOptionPane.showMessageDialog(null, "√‹¬Î≤ªƒ‹Œ™ø’£°");
						}
					}else{
						JOptionPane.showMessageDialog(null, "’À∫≈≤ªƒ‹Œ™ø’£°");
					}
			}else{
				JOptionPane.showMessageDialog(null, "«Î ‰»ÎÍ«≥∆!");
			}
		}
		
		if(e.getSource() == jb2){
			jna.setText("");
			jt1.setText("");
			jp1.setText("");
			jp2.setText("");
		}
	}
}
