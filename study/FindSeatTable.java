package study;

import java.awt.Color;
import java.io.Console;
//��������(seat���̺�) ��������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindSeatTable {	
	//의자번호확인
	public String findSeatNum() throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryFindSeatNum="SELECT seatNum FROM seat"; //의자번호 찾기
		String str=null;
		try {
			con = DBconnect.getConnection();
			pstmt=con.prepareStatement(queryFindSeatNum);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
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
	
	//의자상태확인
	public Integer seatAvail(int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Integer stateInt=null;
		String queryFindSeatAvail="select seatAvail from seat "
				+ "where seatNum = ?";
		
		try {
			con = DBconnect.getConnection();
			pstmt=con.prepareStatement(queryFindSeatAvail);
			pstmt.setInt(1, seatnum);
			 rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				stateInt=rs.getInt("seatAvail");//괄호안에 컬럼명이 들어가야함
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally 
		{
			rs.close();
			pstmt.close();
			con.close();
		}
		return stateInt;
	}
	
	// seatAvail 업데이트
		public void seatUpdate(int seatnum, int seatavail) 
				throws SQLException
		{
			Connection con = null;
			PreparedStatement pstmt = null;
			String queryUpdateSeat="update seat "
					+ "set seatAvail = ? "
					+ "where seatNum = ?";
			try 
			{
				con = DBconnect.getConnection();
				pstmt=con.prepareStatement(queryUpdateSeat);
				System.out.println("seatUpdate:"+seatnum+" "+seatavail);
				pstmt.setInt(1, seatavail);
				pstmt.setInt(2, seatnum);
				
				int cr =pstmt.executeUpdate();
				System.out.println("change rows:"+cr);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				pstmt.close();
				con.close();
			}
			//return;
		}
	
}