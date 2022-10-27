package sxxy.jkxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connectsql {
    Connection con = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "123456";
    ResultSet rs = null;
    Statement st = null;
   
    public Connectsql() {
       try {
         Class.forName(driver);
          con = DriverManager.getConnection(url,user,password);
          st = con.createStatement();
         
       } catch (ClassNotFoundException e) {
          // TODO Auto-generated catch block
         System.out.println("Sorry,can`t find the Driver!");  
         e.printStackTrace();
       } catch (SQLException e) {
          // TODO Auto-generated catch block
         e.printStackTrace();
       } catch (Exception e) {
         e.printStackTrace();
       }
    }
   
    public boolean compare(String name,String pass) {
       boolean b = false;
       String sql = "select * from account_student where username='"+name+"'";
       try {
          rs = st.executeQuery(sql);
         if(rs.next()) {
             @SuppressWarnings("unused")
			String na = rs.getString("username");
             String pa = rs.getString("password");
           // System.out.println(na+","+pa);
            //System.out.println(pa+" "+pass);
            if(pa.equals(pass)){
                b = true;
               //JOptionPane.showMessageDialog(null, "密码正确！");
             }else {
               JOptionPane.showMessageDialog(null, "密码错误！");
             }
          }else {
            JOptionPane.showMessageDialog(null, "用户名不存在！");
          }
         rs.close();
         con.close();
         //st.close();
          } catch (SQLException e) {
             // TODO Auto-generated catch block
            e.printStackTrace();
          }
       return b;
    }
}