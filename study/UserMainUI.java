package study;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class UserMainUI extends JFrame
implements ActionListener, Runnable{
	JButton bt1, bt2, bt3, bt4;
	JTextField tf1, tf2, tf3;
	TextArea area;
	List list;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String listTitle = "*******질문 명단*******";
	String id;
	String num;
	JLabel picture;
	ChatUI[] QR = new ChatUI[100];
	boolean flag = false;
	int seatnum;
	int rmtime1;
	int rmtime2;
	int rmtime3;
	
	ImageIcon img=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image\\addpay.jpg");
	ImageIcon imgexit=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image\\exit.jpg");

	public UserMainUI(BufferedReader in, PrintWriter out, String id, String num) {
		setSize(850,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.id = id;
		this.in = in;
		this.out = out;
		this.num = num;
		this.seatnum=seatnum;
		this.rmtime1=rmtime1;
		this.rmtime2=rmtime2;
		this.rmtime3=rmtime3;
		
		setTitle(this.id + "님 안녕하세요");
		// //////////////////////////////////////////////////////////////////////////////////////////
		JPanel p1 = new JPanel();
		UserMainUIPanel(p1);
		getContentPane().add(p1);
		// /////////////////////////////////////////////////////////////////////////////////////////
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		list = new List();
		list.add(listTitle);
		p2.add(BorderLayout.CENTER, list);
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		bt2 = new JButton("질문하기");
		bt2.addActionListener(this);
		bt3 = new JButton("답변하기");
		bt3.addActionListener(this);
		p3.add(bt2);
		p3.add(bt3);
		p2.add(BorderLayout.SOUTH, p3);
		add(BorderLayout.EAST, p2);
		// ///////////////////////////////////////////////////////////////////////////////////////////
		
		new Thread(this).start();
		setVisible(true);
		validate();
	}
	
	public void run() {
		System.out.println("클라이언트 run");
		try {
			while(true) {
				String line = in.readLine();
				if(line==null) {
					System.out.println("종료");
					break;}
				else
					routine(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//--run
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
			if(obj == bt2) {// 질문하기
			MyDialog md = new MyDialog(this, "질문을 입력하세요", true);
			//Dialog의 창크기
			int width = 300;
			int height = 200;
			//int x = fx+getWidth()/2-width/2;
			//int y = fy+getHeight()/2-height/2;
			md.setSize(width, height);
			md.setLocationRelativeTo(this);
			//md.setBounds(x, y, width, height);
			md.setVisible(true);
		}else if(obj == bt3) { // 답변하기
			if(list.getSelectedItem()!=null) {
			String str = list.getSelectedItem();
			enterRoom(str);
			}
		}else if(obj == tf3) {
			sendMessage(tf3.getText());
			tf3.setText("");
		}
	}
	
	public void routine(String line) {
		System.out.println("클라이언트 line");
		int idx = line.indexOf(ChatProtocol2.MODE);
		String cmd = line.substring(0, idx);
		String data = line.substring(idx+1);
		if(cmd.equals(ChatProtocol2.ROOMLIST)) {
			addRoomList(data);}
		else if(cmd.equals(ChatProtocol2.ENTERROOM)) {	// ENTERROOM:방이름:유저명;님이 입장하였습니다
			int idx1 = data.indexOf(ChatProtocol2.MODE);
			String Rn = data.substring(0, idx1); //방이름
			String str = data.substring(idx1+1); //유저명;님이 입장하였습니다
			int idx2 = str.indexOf(";");
			String Un = str.substring(0, idx2);	//유저명
			String str1 = str.substring(idx2+1); //님이 입장하였습니다
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(Rn.equals(QR[i].roomName)){
					QR[i].addText("["+Un+"] " + str1);
					}
				}
				
			}
		}else if(cmd.equals(ChatProtocol2.ADDUSER)) {
			// 방이름:방이름:유저명;방이름:유저명;방이름:유저명;...;
			int idx1 = data.indexOf(ChatProtocol2.MODE);
			String Rn = data.substring(0, idx1); //방이름
			String str = data.substring(idx1+1); //방이름:유저명;방이름:유저명;방이름:유저명;...;
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(Rn.equals(QR[i].roomName)){
						QR[i].resetList(str);
						break;
					}
				}

			}


		}else if(cmd.equals(ChatProtocol2.MESSAGE)) { // MESSAGE:방이름:[id]+채팅내용
			System.out.println("메세지진입");
			int idx1 = data.indexOf(ChatProtocol2.MODE);
			String Rn = data.substring(0, idx1); // 방이름
			System.out.println("Rn:"+Rn);
			String msg = data.substring(idx1 + 1);	// [id]:채팅내용
			System.out.println("msg:"+msg);
//			if(Rn.equals(QR[0].roomname)) {
//				QR[0].addText(msg);
//			}
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(Rn.equals(QR[i].roomName)){
					System.out.println("채팅한 방번호 = " + i);
					QR[i].addText(msg);
					}
				}

			}
		}else if(cmd.equals(ChatProtocol2.RESETLIST)) {
			System.out.println("리스트리셋");
			System.out.println(data);
			list.removeAll();
			list.add(listTitle);
			StringTokenizer st = new StringTokenizer(data, ";");
			while(st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
		}else if(cmd.equals(ChatProtocol2.DELETELIST)) {
			list.remove(data);
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(data.equals(QR[i].roomName)){
					System.out.println("채팅한 방번호 = " + i);
					QR[i].addText("*********OWNER EXIT*********");
					QR[i].addText("Leave the room in 3 seconds");
					sendMessage(ChatProtocol2.DELETUSER+ChatProtocol2.MODE+QR[i].roomName);
					try {
						QR[i].addText("3");
						Thread.sleep(1000);
						QR[i].addText("2");
						Thread.sleep(1000);
						QR[i].addText("1");
						Thread.sleep(1000);
						QR[i].dispose();
						QR[i] = null;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
					}
				}

			}
		}else if(cmd.equals(ChatProtocol2.EXIT)) {	//EXIT:방이름
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(data.equals(QR[i].roomName)) {
						QR[i] = null;
						break;
					}
				}
			}
		}
	}//--routine
	
	class MyDialog extends Dialog implements ActionListener{
		Button b1, b2;
		TextField tf;
		TextArea ta;
		public MyDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			setLayout(new BorderLayout());
			tf = new TextField();
			Panel p = new Panel();
			
			b1 = new Button("확인");
			b2 = new Button("취소");
			
			p.add(b1);
			p.add(b2);
			
			add(p,BorderLayout.SOUTH);
			add(tf,BorderLayout.CENTER);
			b1.addActionListener(this);
			b2.addActionListener(this);
			tf.addActionListener(this);//Enter이벤트
		}
		
		public MyDialog(Frame owner, String title, boolean modal, String msg) {
			super(owner, title, modal);
			setLayout(new BorderLayout());
			ta = new TextArea(msg);
			Panel p = new Panel();
			
			b2 = new Button("확인");
			
			p.add(b2);
			
			add(p,BorderLayout.SOUTH);
			add(ta,BorderLayout.CENTER);
			b2.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == b1 || obj == tf) {
				String str = tf.getText().trim();
				sendMessage(ChatProtocol2.ROOMLIST+ChatProtocol2.MODE+id+";"+str);
				creatRoom(str);
				dispose();//사라지는 기능
			}else if(obj == b2) {
				dispose();
			}
		}
	}//--MyDialog
	
	public void creatRoom(String roomname) {
//		QR[0] = new MChatQuestionRoom(roomname, in, out, id);
//		System.out.println(QR[0].roomname);
		int orner = 1;
		String msg = "이미 있는 질문 입니다.";
		for(int i = 0; QR.length > i; i++) {
			if(QR[i] != null) {
				if(roomname.equals(QR[i].roomName)) {
					MyDialog md = new MyDialog(this, "질문을 입력하세요", true, msg);
					//Dialog의 창크기
					int width = 200;
					int height = 200;
					//int x = fx+getWidth()/2-width/2;
					//int y = fy+getHeight()/2-height/2;
					md.setSize(width, height);
					md.setLocationRelativeTo(this);
					//md.setBounds(x, y, width, height);
					md.setVisible(true);
					return;
				}
			}
		}
		for(int i = 0; QR.length > i; i++) {
			if(QR[i] == null) {
				System.out.println("만들어진 방번호 = " + i);
				QR[i] = new ChatUI(roomname, in, out, id, orner);
				QR[i].enterRoom();
				break;
			}
		}
	}
	
	public void enterRoom(String roomname) {
		String msg = "이미 열려있는 방입니다.";
		for(int i = 0; QR.length > i; i++) {
			if(QR[i] != null) {
				if(roomname.equals(QR[i].roomName)) {
					MyDialog md = new MyDialog(this, "질문을 입력하세요", true, msg);
					//Dialog의 창크기
					int width = 300;
					int height = 200;
					//int x = fx+getWidth()/2-width/2;
					//int y = fy+getHeight()/2-height/2;
					md.setSize(width, height);
					md.setLocationRelativeTo(this);
					//md.setBounds(x, y, width, height);
					md.setVisible(true);
					return;
				}
			}
		}
		
		for(int i = 0; QR.length > i; i++) {
			if(QR[i] == null) {
				System.out.println("만들어진 방번호 = " + i);
				QR[i] = new ChatUI(roomname, in, out, id);
				QR[i].enterRoom();
				break;
			}
		}
	}
	
	public void UserMainUIPanel(JPanel panel)
	{
		panel.setLayout(null);
		
		Font font=new Font("맑은 고딕", Font.PLAIN, 17);
		
		JLabel roomNumber=new JLabel("방번호:"+seatnum);
		roomNumber.setBounds(0,0,100,50);
		roomNumber.setFont(font);
		panel.add(roomNumber);
		
		
		//남은시간
		UserLoginEvent remain=new UserLoginEvent();
		String date=remain.userRemain(id);
		String[] arr=date.split(":");
	    rmtime1=Integer.parseInt(arr[0]);
	    rmtime2=Integer.parseInt(arr[1]);
	    rmtime3=Integer.parseInt(arr[2]);
		JLabel remaintime=new JLabel("남은 시간:"+date);
		new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    
                    try {
                        Thread.sleep(1000);
                        if (rmtime3==0)
                        {
                        	if (rmtime2==0)
                        	{
                        		rmtime1=rmtime1-1;
                        		rmtime2=59;
                        		rmtime3=59;
                        	}
                        	else {
                        		rmtime2=rmtime2-1;
                        		rmtime3=59;
                        	}
                        }
                        else {
                        	rmtime3=rmtime3-1;
                        }
                        String dtime=rmtime1+"시"+rmtime2+"분"+rmtime3+"초";
                        remaintime.setText("남은 시간:"+ dtime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
		remaintime.setBounds(400,0,300,50);
		remaintime.setFont(font);
		panel.add(remaintime);
		
		//관리자 전화번호 뜨게하기
		FindManagerTable mgpn=new FindManagerTable();
        String managerphone_str=mgpn.managerPn();
        JLabel ManagerPhone = new JLabel("관리자 연락처:"+managerphone_str);
		ManagerPhone.setBounds(0, 40, 300, 50);
		ManagerPhone.setFont(font);
		panel.add(ManagerPhone);
		
		
		//관리자이메일 뜨게하기
		FindManagerTable mgem=new FindManagerTable();
		String managerEmail_str=mgem.managerEmail();
		JLabel managerEmail=new JLabel("관리자이메일:"+managerEmail_str);
		managerEmail.setBounds(400,40,300,50);
		managerEmail.setFont(font);
		panel.add(managerEmail);
		
		picture = new JLabel();
        picture.setIcon(new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image\\book.jpg"));
        picture.setBounds(0, 100, 900,365);
        panel.add(picture);
        
        JButton addpay=new JButton(img);
        addpay.setBounds(0,465,350,200);
        panel.add(addpay);
        
        JButton exit=new JButton(imgexit);
        exit.setBounds(350,465,350,200);
        panel.add(exit);
        
        
        
        panel.setBackground(new Color(230,239,255));
        
      //추가결제 기능
        addpay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Pay(id);
				dispose();
			}
		});
        
        //퇴실 기능
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0;QR.length > i; i++) {
					if(QR[i] != null) {
						if(QR[i].owner == 1) {
							sendMessage(ChatProtocol2.DELETELIST+ChatProtocol2.MODE+QR[i].roomName);
							sendMessage(ChatProtocol2.EXIT+ChatProtocol2.MODE+QR[i].roomName+ChatProtocol2.MODE+id);
						}else {
							sendMessage(ChatProtocol2.EXIT+ChatProtocol2.MODE+QR[i].roomName+ChatProtocol2.MODE+id);
						}
					}
				}
		
				try {
					FindUseTable fut = new FindUseTable();
					FindMemberTable fmt = new FindMemberTable();
					// 입실시간 찾아오기
					String usenum = fut.findUse(Integer.parseInt(num));
					String inTime = fut.findInTime(usenum);
					LocalDateTime nowDateTime = LocalDateTime.now();
					DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String formatNow = nowDateTime.format(dfm);
					try {
						// USE테이블의 퇴실시간을 현재시간으로 설정, 퇴실시간-입실시간 = 사용시간
						String useTime = fut.usetimeC(inTime, formatNow);
						fut.updateUse(formatNow, useTime, usenum);
						// Member테이블의 남은시간 - 사용시간
						fmt.updateRemainTime(useTime, id);
						// Seat테이블의 SeatAvail 상태 0으로 변경
						FindSeatTable fst = new FindSeatTable();
						fst.seatUpdate(seatnum, 0);
						
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				System.exit(0);
			}
		});
        
		
	}
	
	
	public void addRoomList(String str) {
		list.add(str);
	}
	
	public void sendMessage(String msg) {
		out.println(msg);
	}
	
	public static void main(String[] args) {
	}
}