package cn.realty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FJ_OF_Month {
	
	
	//����סլ�ֻ�ķ��������·ݵ�ƽ���۸�
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
//				bean.setLB("סլ���ֻ�");
//				bean.setQy("����԰��");
				list.add(bean);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("����ƽ�������쳣");
		}	
		return list;	
	}
	
	//�������ݿ�month_avgprice����
	public void insertToPrice(){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<FWLBBean> list = avgZZ_GH();
		for(int i =0;i<list.size();i++){
			System.out.println(list.get(i).getAvgFJ());
			double avgFJ = list.get(i).getAvgFJ();
			String year = list.get(i).getMonth();
			String LB = "סլ���ֻ�";
			String QY = "����԰��";
			System.out.println(avgFJ+year+LB);
			String sql = "insert into year_avgprice_zz_gh(avg_price,year,lb,qy) values("+avgFJ+",'"+year+"','"+LB+"','"+QY+"')";
			
			conn.insert(sql);
		}
	}
	
	//��dl_year__avgprice_zz_gh���в�ѯ��ʱ��仯��ƽ������������У�������double[]����
	public double[] return_DL_Avgprice(){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<Double> list = new ArrayList<Double>();
		try{
			//���ط���ȥ��2017���
		String sql = "select avg_price from dl_year_avgprice_zz_gh where year between 2007 and 2015 order by year asc";
		ResultSet rs = conn.query(sql);
		while(rs.next()){
			double value = rs.getDouble(1);
			list.add((Double)value);
		}
		}catch(SQLException e){
			System.out.println("��ѯƽ�������쳣");
		}
		double list_array[] = new double[list.size()];
		for(int i=0;i<list.size();i++){
			list_array[i] = list.get(i);
		}
		return list_array;
	}
	
	//�õ�2016��12���·ݵĴ����з��۵�����
		public double[] return_DL_2016Avgprice(){
			JDBCConnection conn = new JDBCConnection();
			conn.getConnection();
			ArrayList<Double> list = new ArrayList<Double>();
			try{
				//���ط���ȥ��2017���
			String sql = "select avg_price from dl2016_month_avgprice_zz_gh where month between 01 and 11 order by month asc";
			System.out.println("sql:"+sql);
			ResultSet rs = conn.query(sql);
			while(rs.next()){
				double value = rs.getDouble(1);
				list.add((Double)value);
			}
			}catch(SQLException e){
				System.out.println("��ѯƽ�������쳣");
			}
			double list_array[] = new double[list.size()];
			for(int i=0;i<list.size();i++){
				list_array[i] = list.get(i);
			}
			return list_array;
		}
	//�õ������ȵķ�����Ϣ
		public double[] return_DL_quarter_Avgprice(String start,String end){
			JDBCConnection conn = new JDBCConnection();
			conn.getConnection();
			ArrayList<Double> list = new ArrayList<Double>();
			try{
		   //���ط���ȥ��2017���
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
				System.out.println("��ѯƽ�������쳣");
			}
			double list_array[] = new double[list.size()];
			for(int i=0;i<list.size();i++){
				list_array[i] = list.get(i);
			}
			return list_array;
		}
		

	//�õ�2016��12���·ݵķ�������
	public double[] return_GXYQ_2016Avgprice(String start,String end){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<Double> list = new ArrayList<Double>();
		try{
	   //���ط���ȥ��2017���
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
			System.out.println("��ѯƽ�������쳣");
		}
		double list_array[] = new double[list.size()];
		for(int i=0;i<list.size();i++){
			list_array[i] = list.get(i);
		}
		return list_array;
	}
	
	//��gxyqyear__avgprice_zz_gh���в�ѯ��ʱ��仯��ƽ������������У�������double[]����
	public double[] return_Avgprice(){
		JDBCConnection conn = new JDBCConnection();
		conn.getConnection();
		ArrayList<Double> list = new ArrayList<Double>();
		try{
			//���ط���ȥ��2017���
		String sql = "select avg_price from gxyq_year_avgprice_zz_gh where year between 2008 and 2016 order by year asc";
		ResultSet rs = conn.query(sql);
		while(rs.next()){
			double value = rs.getDouble(1);
			list.add((Double)value);
		}
		}catch(SQLException e){
			System.out.println("��ѯƽ�������쳣");
		}
		double list_array[] = new double[list.size()];
		for(int i=0;i<list.size();i++){
			list_array[i] = list.get(i);
		}
		return list_array;
	}

}
