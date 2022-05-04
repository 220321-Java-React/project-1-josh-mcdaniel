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

public class UserDAO {
	
	UserRoleDAO urDAO = new UserRoleDAO();
	
	public boolean login(String username, String password) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			User login = new User(username, password);
			
			String sql = "select * from ers_users where ers_username = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User loginCheck = new User(rs.getString("ers_username"), rs.getString("ers_password"));
				
				if(login.getUsername().equals(loginCheck.getUsername()) && login.getPassword().equals(loginCheck.getPassword())) {
					return true;
				}else {
					return false;
				}
			}
			
			
		} catch(SQLException e) {
			System.out.println("Something went wrong fetching user login");
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<User> getUsersAllInfo() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ArrayList<User> fullList = new ArrayList<>();
			
			String sql = "select * from ers_users full outer join ers_user_roles;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				User u = new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"), rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), null);
				
				int userFK = rs.getInt("user_role_id_fk");
				
				UserRole ur = urDAO.getUserRoleByID(userFK);
				
				u.setUserRole(ur);
				
				fullList.add(u);
			}
			
			return fullList;
			
		}catch(SQLException e) {
			System.out.println("Something went wrong fetching user login");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public User getUserByName(String firstName, String lastName) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_users where user_first_name = ? and user_last_name = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User u = new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"), rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), null);
				
				int userFK = rs.getInt("user_role_id_fk");
				
				UserRole ur = urDAO.getUserRoleByID(userFK);
				
				u.setUserRole(ur);
				
				return u;
			}
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong fetching user");
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserByID(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_users where ers_users_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User u = new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"), rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), null);
				
				int userFK = rs.getInt("user_role_id_fk");
				
				UserRole ur = urDAO.getUserRoleByID(userFK);
				
				u.setUserRole(ur);
				
				return u;
			}
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong fetching user");
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserByEmail(String email) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from ers_users where user_email = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User u = new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"), rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), null);
				
				int userFK = rs.getInt("user_role_id_fk");
				
				UserRole ur = urDAO.getUserRoleByID(userFK);
				
				u.setUserRole(ur);
				
				return u;
			}
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong fetching user");
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertNewUser(User user) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ers_users (ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id_fk) values (?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getUserRole().getRoleID());
			
			ps.executeUpdate();
			
			System.out.println("User successfully added.");
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong adding user");
			e.printStackTrace();
		}
		
	}
	
	public void removeExistingUser(User user) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from ers_users where ers_user_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getUserID());
			
			ps.executeUpdate();
			
			System.out.println("User successfully removed.");
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong removing user");
			e.printStackTrace();
		}
		
	}
	
	public void updateExistingUser(User user, int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update ers_users set ers_username = ? where ers_users_id = ?; update ers_users set ers_password = ? where ers_users_id = ?;"
					+ " update ers_users set user_first_name = ? where ers_users_id = ?; update ers_users set user_last_name = ? where ers_users_id = ?;"
					+ " update ers_users set user_email = ? where ers_users_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.setString(2, user.getUsername());
			ps.setInt(3, id);
			ps.setString(4, user.getPassword());
			ps.setInt(5, id);
			ps.setString(6, user.getFirstName());
			ps.setInt(7, id);
			ps.setString(8, user.getLastName());
			ps.setInt(9, id);
			ps.setString(10, user.getEmail());

			
			ps.executeUpdate();
			
			System.out.println("User successfully altered.");
			
			
		}catch(SQLException e) {
			System.out.println("Something went wrong altering user");
			e.printStackTrace();
		}
		
	}
	
	

}
