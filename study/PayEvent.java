package study;

import java.text.SimpleDateFormat;
import java.sql.*;



public class PayEvent {
	
	Connection con=null;
	PreparedStatement pstmt=null;
	String num1_1="0010000";
	String num1_2="0020000";
	String num1_3="0040000";
	String num1_4="0060000";
	String num1_5="0080000";
	String num1_6="0120000";
	
	String num2_1="0240000";
	String num2_2="0720000";
	String num2_3="1680000";
	String num2_4="2400000";
	String num2_5="3600000";
	String num2_6="7200000";
	
	String sql="SELECT payment FROM charge WHERE chargeTime=?";
	String str=null;
	
	
	public String pay1()
	{
		try 
		{
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_1);
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
	
	
	
	
	
	public String pay2()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String pay3()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_3);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String pay4()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_4);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String pay5()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_5);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String pay6()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num1_6);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	//�Ⱓ��
	public String payPeriod1()
	{
		
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_1);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String payPeriod2()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String payPeriod3()
	{	
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_3);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String payPeriod4()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_4);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String payPeriod5()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_5);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	public String payPeriod6()
	{
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num2_6);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				str=rs.getString(1);
			}
			pstmt.close();

		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
		return str;
	}
	
	
}