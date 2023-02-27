package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Manager(관리자) 테이블 검색
public class FindManagerTable {
	
	public String managerName(String mid) throws SQLException //매니저 이름 찾기
	{
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str=null;
		String queryFindManagerName = "select managerName from manager "
				+ "where managerId = ?";

		try {
			con=DBconnect.getConnection();
			pstmt=con.prepareStatement(queryFindManagerName);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				str = rs.getString("managerName");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			rs.close();
			pstmt.close();
			con.close();
		}
		return str;
	}
	
	//관리자 전화번호불러주기
		public String managerPn()
		{
			Connection con=null;
			PreparedStatement pstmt=null;
			String queryFindmanagerPn="SELECT managerTel FROM manager WHERE managerId=?";
			String str=null;
			try {
				con=DBconnect.getConnection();
				pstmt = con.prepareStatement(queryFindmanagerPn);
				pstmt.setString(1,"family");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					str=rs.getString(1);
				}

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return str;
		}
		
		//관리자 이메일 불러주기
		public String managerEmail()
		{
			Connection con=null;
			PreparedStatement pstmt=null;
			String queryFindmanagerEmail="SELECT managerEmail "
					+ "FROM manager WHERE managerId=?";
			String str=null;
			
			try {
				con=DBconnect.getConnection();
				pstmt = con.prepareStatement(queryFindmanagerEmail);
				pstmt.setString(1,"family");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					str=rs.getString(1);
				}

			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
}