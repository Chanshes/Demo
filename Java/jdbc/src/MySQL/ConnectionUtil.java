package MySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectionUtil{
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("select*from information_1046");
			while(res.next()){
				String id = res.getString("id");
				String name = res.getString("name");
				String age = res.getString("age");
				System.out.print("id:"+id);
				System.out.print("	name:"+ name);
				System.out.println("	age:"+ age);
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}