
package sxxy.jkxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");// �������ݿ�������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// ͨ���������ݿ��URL����ȡ���ݿ����Ӷ���
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test",
					"root", "123456");
			Statement stmt = con.createStatement();//����statement����
			ResultSet res = stmt.executeQuery("select * from information_1046");//ִ�и�����SQL��䣬���ص���ResultSet����
			while (res.next()) { // �����ǰ��䲻�����һ���������ѭ��
				String id = res.getString("id"); // ��ȡ������id���ֶ�ֵ
				String name = res.getString("name"); // ��ȡ������name���ֶ�ֵ
				String age = res.getString("age"); // ��ȡ������age���ֶ�ֵ
				System.out.print("���:" + id); // ����ֵ���
				System.out.print("	����: " + name);
				System.out.print("	����: " + age);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
