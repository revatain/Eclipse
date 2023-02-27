package study;

//의자정보(seat테이블) 가져오기
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//USE(사용)테이블 검색
public class FindUseTable {	
	
	//사용정보 Insert
	public void insertUse(String checkintime
			, String membertel, int seatnum) throws SQLException
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		String queryinsertUse="insert into `Use` "
				+ "VALUES(null, ?, null, ?, ?, null)";
		FindSeatTable fst = new FindSeatTable();
		try 
		{
			con = DBconnect.getConnection();
			pstmt=con.prepareStatement(queryinsertUse);
			
			pstmt.setString(1, checkintime);
			pstmt.setString(2, membertel);
			pstmt.setInt(3, seatnum);
			
			pstmt.executeUpdate();
			fst.seatUpdate(seatnum, 1);
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
	
	//의자번호로 사용번호 찾기
		public String findUse(int seatnum) throws SQLException
		{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String queryFindUse="select useNum from `use` "
					+ "where seatNum = ?";
			String usenumReturn=null;
			
			try
			{
				con = DBconnect.getConnection();
				pstmt=con.prepareStatement(queryFindUse);
				pstmt.setInt(1, seatnum);
				rs = pstmt.executeQuery();
				if(rs.next()) 
				{
					usenumReturn=rs.getString("useNum");
				}
				else
				{
					usenumReturn="0";
				}
			}
			catch (SQLException e) 
			{ 
				e.printStackTrace();
			} 
			finally 
			{
				rs.close();
				pstmt.close();
				con.close();
			}
			System.out.println("usenumReturn:"+usenumReturn);
			return usenumReturn;
		}
		
		//useNum으로 memberTel찾기
		public String findmemt(int usenum) throws SQLException
		{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String queryFindmemt="select memberTel from `use` "
					+ "where useNum = ?";
			String memtelReturn=null;
			
			try
			{
				con = DBconnect.getConnection();
				pstmt=con.prepareStatement(queryFindmemt);
				pstmt.setInt(1, usenum);
				rs = pstmt.executeQuery();
				if(rs.next()) 
				{
					memtelReturn=rs.getString(1);
				}
				else
				{
					memtelReturn="0";
				}
			}
			catch (SQLException e) 
			{ 
				e.printStackTrace();
			} 
			finally 
			{
				rs.close();
				pstmt.close();
				con.close();
			}
			System.out.println("memtelReturn:"+memtelReturn);
			return memtelReturn;
		}
		
		//USE테이블에서 입실시간 찾아오기
		public String findInTime(String usenum) throws SQLException
		{
			String inTime=null;
			Connection con=null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			String queryFindInTime = "select checkinTime from `USE` "
					+ "where useNum = ?";

			try {
				con=DBconnect.getConnection();
				pstmt=con.prepareStatement(queryFindInTime);
				pstmt.setString(1, usenum);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					inTime = rs.getString("checkInTime");
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
			System.out.println("findInTime:"+inTime);
			return inTime;
		}
		
		//useTime(사용시간) 계산
		public String usetimeC(String checkintime,
				String checkouttime) throws ParseException
		{
			String usetime;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
//			// 비교할 시간 (문자열) 
//			String checkinTime = "";
//			String checkoutTime = "";
			
			// 문자열 -> Date 
			Date checkindate = sdf.parse(checkintime);
			Date checkoutdate = sdf.parse(checkouttime);
			
			// Date -> 밀리세컨즈 
			long cintimeMil = checkindate.getTime();
			long couttimeMil = checkoutdate.getTime();
			
			// 비교 
			long diff = couttimeMil - cintimeMil;
			//System.out.println("diff:"+diff);
			int diffTime = (int) (diff/ (1000 * 60 * 60));
			int diffMin = (int) (diff / (1000 * 60)-(diffTime*60));
			int diffSec = (int) (diff / 1000 - (diffTime*3600)-(diffMin*60));

			
			
			usetime = diffTime+":"+diffMin+":"+diffSec;
			//System.out.println("useTimeC:use time is "+usetime);
			return usetime;
		}
		
		//USE테이블 데이터 UPDATE(checkoutTime, useTime)
			public void updateUse(String checkouttime,
					String usetime, String usenum) throws SQLException
			{
				Connection con = null;
				PreparedStatement pstmt = null;
				String queryupdateUse="update `use` set checkoutTime = ?, "
						+ "useTime = ? where useNum = ?;";
				int seatnum=0;
				try
				{
					con = DBconnect.getConnection();
					pstmt=con.prepareStatement(queryupdateUse);
					pstmt.setString(1, checkouttime);
					pstmt.setString(2, usetime);
					pstmt.setString(3, usenum);
					pstmt.executeUpdate();		
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
			}
			
			//의자번호 검색(사용번호이용)
			public String findSeatNum(int usenum) throws SQLException
			{
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String queryFindSeatNum="SELECT seatNum FROM `use`"
						+ "where useNum = ?";
				String seatnum=null;
				try {
					con = DBconnect.getConnection();
					pstmt=con.prepareStatement(queryFindSeatNum);
					pstmt.setInt(1, usenum);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						seatnum=rs.getString(1);
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
				return seatnum;
			}
}