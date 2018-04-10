package nl.hu.curcon.dao.impl;

import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import nl.hu.curcon.dao.BaseDao;
import nl.hu.curcon.dao.UserDao;
import nl.hu.curcon.domain.User;

public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Override
	public User findRoleForUsernameAndPassword(String username, String password) { 
		String role = null;     
		String query = "SELECT role FROM useraccount WHERE username = ? AND password = ?";          
		
		try (java.sql.Connection con = super.getConnection()) {              
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);       
			pstmt.setString(1, username);       
			pstmt.setString(2, password);              
			ResultSet rs = pstmt.executeQuery(); 
			
			rs.close();
			pstmt.close();
	 
		if (rs.next())          
			role = rs.getString("role");          
		} catch (SQLException sqle) {        
			sqle.printStackTrace();      
		}          
		
		return role;   
	}
}
