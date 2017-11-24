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
	
	//������ݿ�����
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
	 
	 //��ѯ���ݷ���
	 public ResultSet query(String sql){
		 ResultSet rs = null;
		 try{
			 rs = stmt.executeQuery(sql);
			 return rs;
		 }catch(SQLException e){
			 System.out.println("��ѯ�쳣");
			 return null;
		 }
	 }
	 
	 //��������
	 public boolean insert(String sql){
		 boolean breturn = false;
		 System.out.println("0000000000");
		
			 //conn.setAutoCommit(false);//�����Զ��ύ
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
	 
	 
	 //�ر����ݿ�����
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
