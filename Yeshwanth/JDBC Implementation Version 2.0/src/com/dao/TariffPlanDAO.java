package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.TariffPlan;

public class TariffPlanDAO {

	public static final String JDBC_URL="jdbc:derby:C:\\Users\\2088497\\MyDB;create=true";
	public static final String USERNAME="test";
	public static final String PASSWORD="test";
	
	public Connection con=null;
	public ResultSet rs=null;
	
	public boolean registerTariffPlan(TariffPlan plan){
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String insertQuery="insert into tbl_TariffPlan values(?,?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			
			ps.setInt(1, plan.getId());
			ps.setString(2, plan.getPlanName());
			ps.setString(3, plan.getTypeOfPlan());
			ps.setDouble(4, plan.getTariffRate());
			ps.setInt(5, plan.getValidity());
			ps.setBoolean(6, plan.isRental());
			
			int count=ps.executeUpdate();
			
			if(count>0){
				return true;
			}
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
		
		return false;
		
	}
	
}
