package cn.realty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
	
	private Connection conn=null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	//获得数据库连接
	 public void  getConnection()
	 {
	  
	  try {
	   Class.forName("com.mysql.jdbc.Driver");
	  } catch (ClassNotFoundException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  String url="jdbc:mysql://127.0.0.1:3306/realty";
	  try {
	   conn=DriverManager.getConnection(url, "root", "root");
	   stmt= conn.createStatement();
	  } catch (SQLException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }  
	  //return conn;
	 }
	 
	 //查询数据方法
	 public ResultSet query(String sql){
		 ResultSet rs = null;
		 try{
			 rs = stmt.executeQuery(sql);
			 return rs;
		 }catch(SQLException e){
			 System.out.println("查询异常");
			 return null;
		 }
	 }
	 
	 //插入数据
	 public boolean insert(String sql){
		 boolean breturn = false;
		 System.out.println("0000000000");
		
			 //conn.setAutoCommit(false);//不是自动提交
			 try {
				stmt.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("1111111111");
				return false;
			}
			// System.out.println("33333333333");
		 return true;
	 }
	 
	 
	 //关闭数据库连接
	 public void closeConnection()
	 {
	  if(rs!=null)
	   try {
	    rs.close();
	   } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  if(stmt!=null)
	   try {
	    stmt.close();
	   } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  if(conn!=null)
	   try {
	    conn.close();
	   } catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	 }
}
