package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;


//로그인이벤트
public class UserLoginEvent {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time=new Date();
	String time1=format1.format(time);
	//로그인
	public int userLogin(String memberTel, String memberPw) {
		String test = null;
		
		String queryLogin = "select memberPw from member where memberTel = ?";
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(queryLogin);
			pstmt.setString(1, memberTel);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				test = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("잘못입력");
			e.printStackTrace();	
		}
		if(memberPw.equals(test)){
			return 1;
		}else{
			return 0;
		}
	
	}
	
	

	//가입
	public void userJoin(String num,String pass)
	{	
        String sql = "INSERT INTO member VALUES (?,?,?,?)";
		try {
 
            con=DBconnect.getConnection();
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.setString(2, pass);
            pstmt.setString(3, time1);
            pstmt.setString(4, "000:00:00");
            int rs = pstmt.executeUpdate();

	    if(pstmt != null) 
	    	pstmt.close();
	    if(con != null) 
	    	con.close();
	    
	    if (rs==1)
	    {
	    	JOptionPane.showMessageDialog(null, "회원 가입 완료");
	    	Pay pay=Pay.getInstance(num);
        	pay.setVisible(true);
        	JOptionPane.showMessageDialog(null, "로그인을 환영합니다.");
	    }
	    else {
	    	JOptionPane.showMessageDialog(null, "회원 가입 실패");
	    }
            
        } 

		catch(SQLException e) 
		
		{
		e.printStackTrace();
		}
		
	}
	
	public String userRemain(String id) {
		//시간
		String time=null;
		String queryLogin = "select remainTime from member where memberTel = ?";
		try {
			con=DBconnect.getConnection();
			pstmt = con.prepareStatement(queryLogin);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				time = rs.getString(1);
			}
			

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.print("잘못입력");
			e.printStackTrace();	
		}
		return time;
	
	}
	
	public void remainTimeplus1(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+1;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void remainTimeplus2(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+2;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus3(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+4;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus4(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+6;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus5(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+8;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus6(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);
	
			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+12;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus7(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+24;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus8(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+72;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus9(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+168;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus10(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+240;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus11(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+360;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void remainTimeplus12(String id)
	{
		String remaintime1 = "Update member SET remainTime='";
		String remaintime2="'WHERE memberTel=?";
		
		try {
			con=DBconnect.getConnection();
			String retime=userRemain(id);

			String[] st=retime.split(":");
			int stime=Integer.parseInt(st[0])+720;
			remaintime1=remaintime1+stime+st[1]+st[2];
			remaintime1+=remaintime2;

			pstmt=con.prepareStatement(remaintime1);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void main(String[] args) {
	}

}