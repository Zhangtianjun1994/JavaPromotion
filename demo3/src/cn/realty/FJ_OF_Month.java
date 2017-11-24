package cn.realty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FJ_OF_Month {
	
	
	//计算住宅钢混的房屋随着月份的平均价格
	public ArrayList<FWLBBean> avgZZ_GH(){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<FWLBBean> list = new ArrayList<FWLBBean>();
		try{
			String querysql = "select year,sum(CJ)/sum(JZMJ) from zz_gh group by year";
			ResultSet rs = conn.query(querysql);
			while(rs.next()){
				FWLBBean bean = new FWLBBean();
				bean.setAvgFJ(rs.getDouble(2));
				bean.setMonth(rs.getString(1));
//				bean.setLB("住宅、钢混");
//				bean.setQy("高新园区");
				list.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("计算平均房价异常");
		}	
		return list;	
	}
	
	//插入数据库month_avgprice表中
	public void insertToPrice(){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<FWLBBean> list = avgZZ_GH();
		for(int i =0;i<list.size();i++){
			System.out.println(list.get(i).getAvgFJ());
			double avgFJ = list.get(i).getAvgFJ();
			String year = list.get(i).getMonth();
			String LB = "住宅、钢混";
			String QY = "高新园区";
			System.out.println(avgFJ+year+LB);
			String sql = "insert into year_avgprice_zz_gh(avg_price,year,lb,qy) values("+avgFJ+",'"+year+"','"+LB+"','"+QY+"')";
			
			conn.insert(sql);
		}
	}
	
	//从dl_year__avgprice_zz_gh表中查询随时间变化的平均房价数组队列，并返回double[]数组
	public double[] return_DL_Avgprice(){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<Double> list = new ArrayList<Double>();
		try{
			//返回房价去除2017年的
		String sql = "select avg_price from dl_year_avgprice_zz_gh where year between 2007 and 2015 order by year asc";
		ResultSet rs = conn.query(sql);
		while(rs.next()){
			double value = rs.getDouble(1);
			list.add((Double)value);
		}
		}catch(SQLException e){
			System.out.println("查询平均房价异常");
		}
		double list_array[] = new double[list.size()];
		for(int i=0;i<list.size();i++){
			list_array[i] = list.get(i);
		}
		return list_array;
	}
	
	//得到2016年12个月份的大连市房价的数据
		public double[] return_DL_2016Avgprice(){
			JDBCConnection conn = new JDBCConnection();
			conn.getConnection();
			ArrayList<Double> list = new ArrayList<Double>();
			try{
				//返回房价去除2017年的
			String sql = "select avg_price from dl2016_month_avgprice_zz_gh where month between 01 and 11 order by month asc";
			System.out.println("sql:"+sql);
			ResultSet rs = conn.query(sql);
			while(rs.next()){
				double value = rs.getDouble(1);
				list.add((Double)value);
			}
			}catch(SQLException e){
				System.out.println("查询平均房价异常");
			}
			double list_array[] = new double[list.size()];
			for(int i=0;i<list.size();i++){
				list_array[i] = list.get(i);
			}
			return list_array;
		}
	//得到按季度的房价信息
		public double[] return_DL_quarter_Avgprice(String start,String end){
			JDBCConnection conn = new JDBCConnection();
			conn.getConnection();
			ArrayList<Double> list = new ArrayList<Double>();
			try{
		   //返回房价去除2017年的
			String sql = "select avg_price from dl_quarter where quarter between "+start+" and "+end+" order by quarter asc";
//			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
//			System.out.println("0000000000");
//			ps.setString(1, start);
//			ps.setString(2, end);
//			System.out.println("11111111");
			System.out.println(sql);
			ResultSet rs = conn.query(sql);
			//System.out.println("88888888888");
			while(rs.next()){
				//System.out.println("9999999");
				double value = rs.getDouble(1);
				list.add((Double)value);
			}
			}catch(SQLException e){
				System.out.println("查询平均房价异常");
			}
			double list_array[] = new double[list.size()];
			for(int i=0;i<list.size();i++){
				list_array[i] = list.get(i);
			}
			return list_array;
		}
		

	//得到2016年12个月份的分析数据
	public double[] return_GXYQ_2016Avgprice(String start,String end){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<Double> list = new ArrayList<Double>();
		try{
	   //返回房价去除2017年的
		String sql = "select avg_price from gxyq2016_month_avgprice_zz_gh where month between "+start+" and "+end+" order by month asc";
//		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
//		System.out.println("0000000000");
//		ps.setString(1, start);
//		ps.setString(2, end);
//		System.out.println("11111111");
		System.out.println(sql);
		ResultSet rs = conn.query(sql);
		//System.out.println("88888888888");
		while(rs.next()){
			//System.out.println("9999999");
			double value = rs.getDouble(1);
			list.add((Double)value);
		}
		}catch(SQLException e){
			System.out.println("查询平均房价异常");
		}
		double list_array[] = new double[list.size()];
		for(int i=0;i<list.size();i++){
			list_array[i] = list.get(i);
		}
		return list_array;
	}
	
	//从gxyqyear__avgprice_zz_gh表中查询随时间变化的平均房价数组队列，并返回double[]数组
	public double[] return_Avgprice(){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<Double> list = new ArrayList<Double>();
		try{
			//返回房价去除2017年的
		String sql = "select avg_price from gxyq_year_avgprice_zz_gh where year between 2008 and 2016 order by year asc";
		ResultSet rs = conn.query(sql);
		while(rs.next()){
			double value = rs.getDouble(1);
			list.add((Double)value);
		}
		}catch(SQLException e){
			System.out.println("查询平均房价异常");
		}
		double list_array[] = new double[list.size()];
		for(int i=0;i<list.size();i++){
			list_array[i] = list.get(i);
		}
		return list_array;
	}

}
