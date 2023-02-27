package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


//매니저로그인
public class ManagerLoginEvent2 {
	
	//로그인
	public int managerLogin2(String managerid, String managerpw) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String test = null;
		String queryManagerLogin = "select managerPw  from manager "
				+ "where managerId = ?";
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(queryManagerLogin);
			pstmt.setString(1, managerid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				test = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();	
		}
		finally 
		{
			rs.close();
			pstmt.close();
			con.close();
		}
		if(managerpw.equals(test)){
			return 1;
		}else{
			return 0;
		}	
	}
	public static void main(String[] args) {
		new ManagerLoginEvent2();
	}
}