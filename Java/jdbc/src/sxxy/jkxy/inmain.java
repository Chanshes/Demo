package sxxy.jkxy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class inmain
{
   public static void main(String[] args)
   {
	   JFrame jf=new JFrame();
	   final JTextField jt=new JTextField("lxc");
	   final JPasswordField jp=new JPasswordField("123");
	   JButton jb=new JButton("µÇÂ¼");
	   JLabel text1 = new JLabel("ÕË»§£º");
	   JLabel text2 = new JLabel("ÃÜÂë£º");
	   JLabel jl=new JLabel("ÇëµÇÂ¼~");
	   jl.setForeground(Color.red);
	   

	      
	   jt.setColumns(20);
	   jp.setColumns(20);
	   jp.setEchoChar('*');
	   jf.setSize(300,250);
	   jf.setLayout(new FlowLayout());
	   jf.add(text1);
	   jf.add(jt);
	   jf.add(text2);
	   jf.add(jp);
	   jf.add(jb);
	   jf.add(jl);
	   
	   jf.setVisible(true);
	   jf.setLocationRelativeTo(null);
	   
	   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	   jf.addWindowListener(new WindowAdapter(){
//		   @SuppressWarnings("unused")
//		public void JFClose(WindowEvent w){
//			   System.exit(0);
//		   }
//	   });
	   
	   jb.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {    
	             Connectsql cs = new Connectsql();
	             String n = jt.getText();
	             String p = new String(jp.getPassword());            
	             System.out.println(n+","+p);
	            
	             if(cs.compare(n, p)) {
	                JOptionPane.showMessageDialog(null, "µÇÂ¼³É¹¦£¡");
	             }
	          }
	      });
   }
}
