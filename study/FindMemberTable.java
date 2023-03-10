package study;

import java.awt.Color;
//의자정보(seat테이블) 가져오기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Member(회원)테이블 검색
public class FindMemberTable {	
	
	//회원 남은시간 확인- 회원 전화번호로 찾기
	public String findRemainTime(String membertel) throws SQLException //매니저 이름 찾기
	{
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String remtime=null;
		String queryFindremTime = "select remainTime from member "
				+ "where memberTel = ?";

		try {
			con=DBconnect.getConnection();
			pstmt=con.prepareStatement(queryFindremTime);
			pstmt.setString(1, membertel);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				remtime = rs.getString("remainTime");
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
		return remtime;
	}
	
	//remTime(남은시간) 계산
	public String remtimeC(String remaintime,
			String usetime) throws ParseException
	{
		String remtime;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
//		// 비교할 시간 (문자열) 
//		String checkinTime = "";
//		String checkoutTime = "";
		
		// 문자열 -> Date 
		Date remaintimedate = sdf.parse(remaintime);
		Date usetimedate = sdf.parse(usetime);
		
		// Date -> 밀리세컨즈 
		long remaintimeMil =  remaintimedate.getTime();
		long usetimeMil = usetimedate.getTime();
		
		// 비교 
		long diff = remaintimeMil - usetimeMil;
		
		int diffTime = (int) (diff/ (1000 * 60 * 60));
		
		int diffMin = (int) (diff / (1000 * 60)-(diffTime*60));
		
		int diffSec = (int) (diff / 1000 -(diffTime*3600) -(diffMin*60));
		
				
		remtime = diffTime+":"+diffMin+":"+diffSec;
		
		return remtime;
	}
	
	//회원 남은시간 업데이트
	public void updateRemainTime
	(String usetime, String membertel) throws SQLException, ParseException
	{
		Connection con=null;
		PreparedStatement pstmt = null;
		String frt = findRemainTime(membertel);//전화번호로 남은시간 찾아옴
		System.out.println("updateRemainTime-frt:"+frt);
		String crt = remtimeC(frt, usetime);//찾아온 남은시간 - 사용시간 계산
		System.out.println("updateRemainTime-crt:"+crt);
		
		String queryFindremTime = "update member set remainTime = ?"
				+ "where memberTel = ?";

		try {
			con=DBconnect.getConnection();
			pstmt=con.prepareStatement(queryFindremTime);
			pstmt.setString(1, crt);
			pstmt.setString(2, membertel);
			pstmt.execute();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			pstmt.close();
			con.close();
		}
	}
}