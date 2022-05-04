package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.ConnectionUtil;

public class UserRoleDAO {
	
	public int checkUserRole(User user) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from ers_user_roles where ers_user_role_id = ?;";
			
			int id = user.getUserRole().getRoleID();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				UserRole roleCheck = new UserRole(rs.getInt("ers_user_role_id"), rs.getString("user_role"));
				if(id == roleCheck.getRoleID()) {
					if(id == 1) {
						return 1;
					}else if(id == 2) {
						return 2;
					}else {
						return 0;
					}
				}else {
					return 0;
				}
			}
			
		}catch(SQLException e) {
			System.out.println("Something went wrong fetching user role");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public UserRole getUserRoleByID(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from ers_user_roles where ers_user_role_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new UserRole(rs.getInt("ers_user_role_id"), rs.getString("user_role"));
			}
			
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong fetching user role");
			e.printStackTrace();
		}
		return null;
	}
}
