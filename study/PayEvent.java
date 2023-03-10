package study;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



public class PayEvent {
	
	Connection con=null;
	PreparedStatement pstmt=null;
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time=new Date();
	String time1=format1.format(time);
	
	String sql="SELECT payment FROM charge WHERE chargeNum=?";
	String sql2="SELECT payName FROM charge WHERE chargeNum=?";
	String sql3="INSERT INTO pay (memberTel, payment, payDate, timePaid) VALUES (?, ?, ?, ?)";
	String sql4="SELECT payment FROM charge WHERE chargeNum=?";
	String sql5="SELECT chargeTime FROM charge WHERE chargeNum=?";
			
	String str=null;
	String str1="'";
	
	public String pay(String num)
	{
		try 
		{
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return str;
	}
	public String payName(String num)
	{
		try 
		{
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return str;
	}
	
	public int chargeTime(String num)
	{
		//요금받아오기
		int time=0;
		try 
		{
			con=DBconnect.getConnection();
            pstmt=con.prepareStatement(sql4);
            pstmt.setString(1, num);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
            	time = rs.getInt(1);
            }
            
		} 
		catch (Exception e) 
		{
			System.out.print("잘못입력");
			e.printStackTrace();
		}
		return time;
	}
	public String timePaid(String num)
	{
		//시간받아오기
		String timepaid=null;
		try 
		{
			con=DBconnect.getConnection();
            pstmt=con.prepareStatement(sql5);
            pstmt.setString(1, num);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
            	timepaid = rs.getString(1);
            }
            
		} 
		catch (Exception e) 
		{
			System.out.print("잘못입력");
			e.printStackTrace();
		}
		return timepaid;
	}
	public void payadd(String num, String memberTel)
	{	
		
		try {
			String timepaid=timePaid(num);
			int payment=chargeTime(num);
            con=DBconnect.getConnection();
            pstmt=con.prepareStatement(sql3);
            pstmt.setString(1, memberTel);
            pstmt.setInt(2, payment);
            pstmt.setString(3, time1);
            pstmt.setString(4, timepaid);
            pstmt.executeUpdate();
        } 

		catch(SQLException e) 
		{
		e.printStackTrace();
		}
		
	}
	
	
}
	
	
	
	
	
	