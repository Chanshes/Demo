
package sxxy.jkxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动类
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// 通过访问数据库的URL，获取数据库连接对象
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test",
					"root", "123456");
			Statement stmt = con.createStatement();//创建statement对象
			ResultSet res = stmt.executeQuery("select * from information_1046");//执行给定的SQL语句，返回单个ResultSet对象
			while (res.next()) { // 如果当前语句不是最后一条，则进入循环
				String id = res.getString("id"); // 获取列名是id的字段值
				String name = res.getString("name"); // 获取列名是name的字段值
				String age = res.getString("age"); // 获取列名是age的字段值
				System.out.print("编号:" + id); // 将列值输出
				System.out.print("	姓名: " + name);
				System.out.print("	年龄: " + age);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
