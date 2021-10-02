package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bean.Customer;
import com.bean.Plans;

public class BillDAO {
	
	public static final String JDBC_URL="jdbc:derby:C:\\Users\\2088497\\MyDB;create=true";
	public static final String USERNAME="test";
	public static final String PASSWORD="test";
	
	public Connection con=null;
	public ResultSet rs=null;
	
	public double displayTotalAmount(Plans customerPlans, Customer customer) {
		
		double fee = 0;
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String selectQuery="select fee from tbl_Bill where "
					+ "customerId in (select customerId from tbl_Customers where customerId in "
					+ "(select customerId from tbl_Plans where customerId=?))";
			PreparedStatement ps= con.prepareStatement(selectQuery);
			
/*			ps.setInt(1, customerPlans.getCustomerId());
			ps.setInt(2, customerPlans.getCustomerId());
			ps.setInt(2, customerPlans.getCustomerId());
			ps.setInt(4, customerPlans.getCustomerId());*/
			ps.setInt(1, customer.getCustomerId());
			rs=ps.executeQuery();
			
			fee = rs.getDouble("FEE");
			
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return fee;
	
}

}
