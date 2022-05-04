package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ReimbType;
import com.revature.utils.ConnectionUtil;

public class ReimbTypeDAO {

	public ReimbType getReimbTypeByID(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from ers_reimbursement_type where reimb_type_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				return new ReimbType(rs.getInt("reimb_status_id"), rs.getString("reimb_status"));
			}
			
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong fetching reimbursement status");
			e.printStackTrace();
		}
		return null;
	}
	
}
