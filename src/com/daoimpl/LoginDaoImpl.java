package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.LoginBean;
import com.dao.LoginDao;
import com.dbconnection.DbConnection;


public class LoginDaoImpl implements LoginDao{

	@Override
	public int insertv(LoginBean loginBean) {
		
		int row=0;
		Connection conn=null;
				
		try {
		conn=DbConnection.get_connection();
		
					PreparedStatement pst=conn.prepareStatement("insert into Crud values(?,?,?)");
					
					pst.setInt(1, loginBean.getId());
					pst.setString(2, loginBean.getName());
					pst.setString(3, loginBean.getMobile());
					pst.executeUpdate();
					pst.close();
					
					
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		
		return row;
	}

	@Override
	public List<LoginBean> fetch() {
		
		List<LoginBean> list=null;
		
		
		try {
			Connection conn=DbConnection.get_connection();
			PreparedStatement slt=conn.prepareStatement("select * from crud");
			ResultSet rs= slt.executeQuery();
			list=new ArrayList<LoginBean>();
			while(rs.next()) {
			LoginBean lb = new LoginBean();
			lb.setId(rs.getInt(1));
			lb.setName(rs.getString(2));
			lb.setMobile(rs.getString(3));
			list.add(lb);
			
			
			}} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public void update(LoginBean loginBean) {
		
		Connection conn= DbConnection.get_connection();
		try {
			PreparedStatement upt=conn.prepareStatement("update crud set user_name=?, user_mobile=? where user_id=?");
			
			upt.setString(1, loginBean.getName());
			upt.setString(2, loginBean.getMobile());
			upt.setInt(3, loginBean.getId());
			
			upt.executeUpdate();
			upt.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(LoginBean loginBean) {
		
		Connection conn=DbConnection.get_connection();
		
		try {
			PreparedStatement del=conn.prepareStatement("delete from crud where user_id=?");
			del.setInt(1, loginBean.getId());

			del.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
