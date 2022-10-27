package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import customize.Base;
import customize.Course;

public class Connect {
	Connection con = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "123456";
    static String sql;
    ResultSet rs = null;
    Statement st = null;
   
    public Connect(){
       try {
         Class.forName(driver);
          con = DriverManager.getConnection(url,user,password);
          st = con.createStatement();
         
       } catch (ClassNotFoundException e) {
        
         System.out.println("CAN NOT FIND THE DRIVER!");  
         e.printStackTrace();
       } catch (SQLException e) {
       
    	   System.out.println("DATABASE ACCESSERROR OR OTHER ERRORS!");
    	   e.printStackTrace();
       } catch (Exception e) {
    	   e.printStackTrace();
       }
    }

    public static boolean compare(String username,String pass,int i) {
       boolean b = false;
//       ResultSet rs = null;
//       Statement st = null;
       if(i == 1){
    	   sql = "select * from account_teacher where username='"+username.trim()+"'";
       }else{
    	    sql = "select * from account_student where username='"+username.trim()+"'";
       }
       try {
    	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
    	   Statement st=con.createStatement();
    	   ResultSet rs;
    	   rs = st.executeQuery(sql);
    	   if(rs.next()) {
    		   String na = rs.getString("username");
    		   String pa = rs.getString("password");
    		   if(pa.equals(pass)&&na.equals(username)){
    			   b = true;
    		   }
    	   }
    	   rs.close();
    	   con.close();	   
       } catch (SQLException e) {   
            e.printStackTrace();
          }
       return b;
    }

    //查找账号是否存在
    @SuppressWarnings("unused")
	public boolean compareuser(String user){
    	try {
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
    		sql = "select * from account_student where username='"+user.trim()+"'";
    		Statement st=con.createStatement();
    		ResultSet rs;
    		rs = st.executeQuery(sql);
            if(rs.next()) {      	 
			String na = rs.getString("username");
			String pa = rs.getString("password");   
			if(na.equals(user))
				return true;
            }
            rs.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}  	
    	return false;
    }
    
	public boolean adduserAccount(String username, String pass){
		
		String sql = "insert into account_student values(?,?)";
//		sql = "insert into account_student values("+username+", "+pass+")";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			//PrepparedStatement类可以动态的对数据表中原有数据进行修改操作
			ps.setString(1, username);
			ps.setString(2, pass);
			ps.executeUpdate();//更新语句操作
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	//修改指定学生密码
	public boolean changepass(String username, String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动类
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        try{
        		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
//       	  	sql="update studentbase set name="+"'"+name+"'"+",age="+"'"+age+"'"+",sex="+"'"+sex+"'"+",sdept="+"'"+sdept+"'"+",school="+"'"+school+"'"+" where id="+"'"+id+"'";
        		sql = "update account_student set password= ? where username = ?";
        		PreparedStatement ps = con.prepareStatement(sql);
        		ps.setString(1, password);
        		ps.setString(2, username);
        		System.out.println("username="+username+"pa="+password);
        		ps.executeUpdate();   
        		return true;
        	}catch(SQLException e){
        		e.printStackTrace();
        		return false;
        	}
	}
	//得到指定学生姓名
	public String getid(String Username){
		String name = new String("");
		try {
				sql = "select * from studentbase where id='"+Username+"'";
				rs = st.executeQuery(sql);
				if(rs.next()) {      	 
					name = rs.getString("name");  
				}
				rs.close(); 
           
		} catch (SQLException e) {    
			e.printStackTrace();
		}  	
		System.out.println("姓名:"+name);
		System.out.println("学号:"+Username);
		return name;
	}
	
	//select * from studentbase where id='"+username+"
	public String[] getstubase(String username){
    	String[] stubases = new String[6];
    	try {
   			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动类
   		} catch (ClassNotFoundException e1) {
   			e1.printStackTrace();
   		}
        try{
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        	Statement stm=con.createStatement();
        	ResultSet rs;
        	sql = "select * from studentbase where id='"+username+"'";
    		rs = stm.executeQuery(sql);
        	if(rs.next()) {
        			stubases[0] = rs.getString("id");
        			stubases[1] = rs.getString("name");
        			stubases[2] = rs.getString("age");
        			stubases[3] = rs.getString("sex");
        			stubases[4] = rs.getString("sdept");
        			stubases[5] = rs.getString("school");
               }
        	rs.close();
           }catch (SQLException e) {
               
              e.printStackTrace();
            } 
        return stubases;
    }
	
	 //Update studentbase 成功返回true
	public static boolean changebase(String id,String name,String age,String sex,String sdept,String school){
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动类
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        try{
        		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
//       	  	sql="update studentbase set name="+"'"+name+"'"+",age="+"'"+age+"'"+",sex="+"'"+sex+"'"+",sdept="+"'"+sdept+"'"+",school="+"'"+school+"'"+" where id="+"'"+id+"'";
        		sql = "update studentbase set name = ? , age = ?, sex = ?, sdept = ?, school = ? where id = ?";
        		PreparedStatement ps = con.prepareStatement(sql);
        		ps.setString(1, name);
        		ps.setString(2, age);
        		ps.setString(3, sex);
        		ps.setString(4, sdept);
        		ps.setString(5, school);
        		ps.setString(6, id);
        		ps.executeUpdate();   
        		return true;
        	}catch(SQLException e){
        		e.printStackTrace();
        		return false;
        	}
	}
	//addcourse
	public boolean addcourse(String username, String name){
		String sql = "insert into courses values(?,?,?,?,?,?,?,?,?)";
		try{
					PreparedStatement ps = con.prepareStatement(sql);
					//PrepparedStatement类可以动态的对数据表中原有数据进行修改操作
					ps.setString(1, username);
					ps.setString(2, name);
					ps.setString(3, "");
					ps.setString(4, "");
					ps.setString(5, "");
					ps.setString(6, "");
					ps.setString(7, "");
					ps.setString(8, "");
					ps.setString(9, "");
					ps.executeUpdate();//更新语句操作
					return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean addcourses(String username, String name, String term, String Chinese, String Math, String English, String IoT, String Mhe, String Java){
		String sql = "insert into courses values(?,?,?,?,?,?,?,?,?)";
		try{
					PreparedStatement ps = con.prepareStatement(sql);
					//PrepparedStatement类可以动态的对数据表中原有数据进行修改操作
					ps.setString(1, username);
					ps.setString(2, name);
					ps.setString(3, term);
					ps.setString(4, Chinese);
					ps.setString(5, Math);
					ps.setString(6, English);
					ps.setString(7, IoT);	
					ps.setString(8,Mhe);
					ps.setString(9, Java);
					ps.executeUpdate();//更新语句操作
					return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

	//select * from courses where id='"+username+"'
	public String[] getcourse(String username){
    	String[] courses = new String[9];
    	try {
   			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动类
   		} catch (ClassNotFoundException e1) {
   			e1.printStackTrace();
   		}
        try{
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        	Statement stm=con.createStatement();
        	ResultSet rs;
        	sql = "select * from courses where id='"+username+"'";
    		rs = stm.executeQuery(sql);
        	if(rs.next()) {
        			courses[0] = rs.getString("id");
        			courses[1] = rs.getString("name");
        			courses[2] = rs.getString("term");
        			courses[3] = rs.getString("Chinese");
        			courses[4] = rs.getString("Math");
        			courses[5] = rs.getString("English");
        			courses[6] = rs.getString("IoT");
        			courses[7] = rs.getString("Mhe");
        			courses[8] = rs.getString("Java");
               }
        	rs.close();
           }catch (SQLException e) {
               
              e.printStackTrace();
            } 
        return courses;
    }
	//
	//select * from courses where id='"+username+"',term='"+term+"'
	public String[] getcourse(String username, String term){
    	String[] courses = new String[9];
    	try {
   			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动类
   		} catch (ClassNotFoundException e1) {
   			e1.printStackTrace();
   		}
        try{
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        	Statement stm=con.createStatement();
        	ResultSet rs;
        	sql = "select * from courses where id='"+username+"'and term='"+term+"'";
    		rs = stm.executeQuery(sql);
        	if(rs.next()) {
        			courses[0] = rs.getString("id");
        			courses[1] = rs.getString("name");
        			courses[2] = rs.getString("term");
        			courses[3] = rs.getString("Chinese");
        			courses[4] = rs.getString("Math");
        			courses[5] = rs.getString("English");
        			courses[6] = rs.getString("IoT");
        			courses[7] = rs.getString("Mhe");
        			courses[8] = rs.getString("Java");
               }
        	rs.close();
           }catch (SQLException e) {            
              e.printStackTrace();
            } 
        return courses;
    }
	//select * from studentebase
	public Object[][] getCourses(){
		ArrayList<Course> list = new ArrayList<Course>();
		
			PreparedStatement st = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM courses";
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			try{
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
				st = (PreparedStatement) con.prepareStatement(sql);
				rs = st.executeQuery();
				while(rs.next()){
					Course courses = new Course(rs.getString("id"), rs.getString("name"), rs.getString("term"), rs.getString("Chinese"),
							rs.getString("Math"), rs.getString("English"), rs.getString("IoT"), rs.getString("Mhe"), rs.getString("Java"));
					list.add(courses);
//					System.out.print(rs.getString("id")+"\t");
//					System.out.print(rs.getString("name")+"\t");
//					System.out.print(rs.getString("age")+"\t");
//					System.out.print(rs.getString("sex")+"\t");
//					System.out.print(rs.getString("sdept")+"\t");
//					System.out.println(rs.getString("school"));
				}con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			Object[][] objects = new Object[list.size()][9];
			for (int i = 0; i < list.size(); i++) {
				objects[i][0] = list.get(i).getId();
				objects[i][1] = list.get(i).getName();
				objects[i][2] = list.get(i).getTerm();
				objects[i][3] = list.get(i).getChinese();
				objects[i][4] = list.get(i).getMath();
				objects[i][5] = list.get(i).getEnglish();
				objects[i][6] = list.get(i).getIoT();
				objects[i][7] = list.get(i).getMhe();
				objects[i][8] = list.get(i).getJava();
			}
			return objects;
		}
	
	public static boolean changecourse(String id,String name,String term,String ch,String ma,String en, String io, String me, String ja){
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动类
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        try{
        		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        		sql = "update courses set name = ? , Chinese = ?, Math = ?, English = ?, IoT = ?, Mhe = ?, Java = ? where id = ? and term = ?";
        		PreparedStatement ps = con.prepareStatement(sql);
        		ps.setString(1, name);
        		ps.setString(2, ch);
        		ps.setString(3, ma);
        		ps.setString(4, en);
        		ps.setString(5, io);
        		ps.setString(6, me);
        		ps.setString(7, ja);
        		ps.setString(8, id);
        		ps.setString(9, term);
        		
        		ps.executeUpdate();   
        		return true;
        	}catch(SQLException e){
        		e.printStackTrace();
        		return false;
        	}
	}
	
	public boolean addbase(String username, String name){
		String sql = "insert into studentbase values(?,?,?,?,?,?)";
		try{
					PreparedStatement ps = con.prepareStatement(sql);
					//PrepparedStatement类可以动态的对数据表中原有数据进行修改操作
					ps.setString(1, username);
					ps.setString(2, name);
					ps.setString(3, "");
					ps.setString(4, "");
					ps.setString(5, "");
					ps.setString(6, "");
					ps.executeUpdate();//更新语句操作
					return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	//addcourse
	public static  boolean addbases(String id, String name, String age, String sex, String sdept, String school){
		String sql = "insert into studentbase values(?,?,?,?,?,?)";
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
					PreparedStatement ps = con.prepareStatement(sql);
					//PrepparedStatement类可以动态的对数据表中原有数据进行修改操作
					ps.setString(1, id);
					ps.setString(2, name);
					ps.setString(3, age);
					ps.setString(4, sex);
					ps.setString(5, sdept);
					ps.setString(6, school);	
					ps.executeUpdate();//更新语句操作
					con.close();
					return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	//select * from studentebase
		public Object[][] getBase(){
			ArrayList<Base> list = new ArrayList<Base>();
			
			PreparedStatement st = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM studentbase";
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			try{
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
				st = (PreparedStatement) con.prepareStatement(sql);
				rs = st.executeQuery();
				while(rs.next()){
					Base bases = new Base(rs.getString("id"), rs.getString("name"), rs.getString("age"), rs.getString("sex"),
							rs.getString("Sdept"), rs.getString("School"));
					list.add(bases);
//					System.out.print(rs.getString("id")+"\t");
//					System.out.print(rs.getString("name")+"\t");
//					System.out.print(rs.getString("age")+"\t");
//					System.out.print(rs.getString("sex")+"\t");
//					System.out.print(rs.getString("sdept")+"\t");
//					System.out.println(rs.getString("school"));
				}con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			Object[][] objects = new Object[list.size()][6];
			for (int i = 0; i < list.size(); i++) {
				objects[i][0] = list.get(i).getId();
				objects[i][1] = list.get(i).getName();
				objects[i][2] = list.get(i).getAge();
				objects[i][3] = list.get(i).getSex();
				objects[i][4] = list.get(i).getSdept();
				objects[i][5] = list.get(i).getSchool();
			}
			return objects;
		}
	//删除指定学生信息：
	public boolean deletebase(String username){
		String sql =  "delete from studentbase where id='"+username+"'";
		System.out.println( "delete  from studentbase where id='"+username+"'");
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//删除指定学生的课程
	public boolean deletecourse(String username){
		String sql =  "delete from courses where id='"+username+"'";
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	//删除指定学期的课程
	public boolean deletecourse(String username, String term){
		String sql =  "delete from courses where id='"+username+"' and term= '"+term+"'";
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	//删除指定学生的账号
	public boolean deleteacount(String username){
		String sql =  "delete from account_student where username='"+username+"'";
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

}