package study;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.TextListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ManagerLogin extends JFrame
implements ActionListener{
	JTextField selectedField = null;
	
	String host = "113.198.238.101";
	int port = 8002;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	
	 private JButton btnLogin;
	 private JButton btnInit;
	 private JButton btnBack;
	 private JPasswordField managerPwText;
	 private JTextField managerIdText;
	 private JLabel label;
	 private JLabel infoMsgLabel;
	 
	 private JButton btn1;
	 private JButton btn2;
	 private JButton btn3;
	 private JButton btn4;
	 private JButton btn5;
	 private JButton btn6;
	 private JButton btn7;
	 private JButton btn8;
	 private JButton btn9;
	 private JButton btn0;
	 
	 private JButton btnq;
	 private JButton btnw;
	 private JButton btne;
	 private JButton btnr;
	 private JButton btnt;
	 private JButton btny;
	 private JButton btnu;
	 private JButton btni;
	 private JButton btno;
	 private JButton btnp;
	 
	 private JButton btna;
	 private JButton btns;
	 private JButton btnd;
	 private JButton btnf;
	 private JButton btng;
	 private JButton btnh;
	 private JButton btnj;
	 private JButton btnk;
	 private JButton btnl;
	 
	 private JButton btnz;
	 private JButton btnx;
	 private JButton btnc;
	 private JButton btnv;
	 private JButton btnb;
	 private JButton btnn;
	 private JButton btnm;
	 
	 ImageIcon logoIcon= new ImageIcon
				("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image\\family.jpg");
     Image logoImg = logoIcon.getImage(); // ImageIcon 객체에서 Image 추출
 	Image updateLogoImg = logoImg.getScaledInstance(160, 100, Image.SCALE_SMOOTH); // 추출된 Image의 크기 조절하여 새로운 Image 객체 생성
     ImageIcon updateLogoIcon = new ImageIcon(updateLogoImg);  // 새로운 Image 객체로 ImageIcon 객체 생성
	 
	 String arr[]= {"btnq","btnw","btne","btnr","btnt","btny","btnu","btni","btno","btnp"};
	private static ManagerLogin instance = null;
	public static ManagerLogin getInstance() {
	        if (instance == null) {
	            instance = new ManagerLogin();
	        }
	        return instance;
	}
	private ManagerLogin() {
		 // setting
        setTitle("FSC_ManagerLogin");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		// panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
		
		//initGUI
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
        //로고 라벨
        label = new JLabel();
        label.setIcon(updateLogoIcon);
        label.setBounds(0, 560, 160, 100);
        panel.add(label);

        // add
        getContentPane().add(panel);
       
        // visiible
        setVisible(true);
	}
	public void placeLoginPanel(JPanel panel){
        panel.setLayout(null);
        Font font=new Font("맑은 고딕", Font.PLAIN, 17);
        
        JLabel userLabel = new JLabel("ID");
        userLabel.setBounds(427, 229, 80, 25);
        userLabel.setFont(font);
        panel.add(userLabel);
       
        JLabel passLabel = new JLabel("PassWord");
        passLabel.setBounds(427, 259, 80, 25);
        passLabel.setFont(font);
        panel.add(passLabel);
       
        managerIdText = new JTextField(20);
        managerIdText.setBounds(517, 229, 160, 25);
        panel.add(managerIdText);
       
        managerPwText = new JPasswordField(20);
        managerPwText.setBounds(517, 259, 160, 25);
        panel.add(managerPwText);
        
        //뒤로가기 버튼
        btnBack = new JButton();
        btnBack.setIcon(new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image\\back.jpg"));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(new ActionListener()
        		{
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		FirstDisplay fDisplay;
				fDisplay = new FirstDisplay();
				fDisplay.setTitle("FamilyStudyCafe_FirstDisplay");
				fDisplay.setVisible(true);
				dispose(); //이창 닫기 	
        	}
        		});
        btnBack.setBounds(0,0,100,50);
        panel.add(btnBack);
        
       
        btnInit = new JButton("Reset");
        btnInit.setFocusPainted(false);
        btnInit.setBackground(Color.yellow);
        btnInit.setBounds(480, 300, 140, 25);
        panel.add(btnInit);
        
       
        btnLogin = new JButton("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(Color.yellow);
        btnLogin.setBounds(680, 229, 120, 100);
        panel.add(btnLogin);
        btnLogin.addActionListener(this);
        btnInit.addActionListener(this);
        
        infoMsgLabel=new JLabel("아이디와 비밀번호를 입력하세요.");
        infoMsgLabel.setOpaque(true); 
        infoMsgLabel.setBackground(Color.pink);
        infoMsgLabel.setHorizontalAlignment(JLabel.CENTER);
        infoMsgLabel.setFont(font);
        infoMsgLabel.setBounds(400, 180, 300, 20);
        panel.add(infoMsgLabel);
        
        //숫자키패드
        btn0=new JButton("0");
        btn0.setBounds(310,350,50,25);
        btn0.setBackground(Color.yellow);
        btn0.setFocusPainted(false);
        btn0.addActionListener(this);
        panel.add(btn0);
        
        btn1=new JButton("1");
        btn1.setBounds(360,350,50,25);
        btn1.setBackground(Color.yellow);
        btn1.setFocusPainted(false);
        btn1.addActionListener(this);
        panel.add(btn1);
        
        btn2=new JButton("2");
        btn2.setBounds(410,350,50,25);
        btn2.setBackground(Color.yellow);
        btn2.setFocusPainted(false);
        btn2.addActionListener(this);
        panel.add(btn2);
        
        btn3=new JButton("3");
        btn3.setBounds(460,350,50,25);
        btn3.setBackground(Color.yellow);
        btn3.setFocusPainted(false);
        btn3.addActionListener(this);
        panel.add(btn3);
        
        btn4=new JButton("4");
        btn4.setBounds(510,350,50,25);
        btn4.setBackground(Color.yellow);
        btn4.setFocusPainted(false);
        btn4.addActionListener(this);
        panel.add(btn4);
        
        btn5=new JButton("5");
        btn5.setBounds(560,350,50,25);
        btn5.setBackground(Color.yellow);
        btn5.setFocusPainted(false);
        btn5.addActionListener(this);
        panel.add(btn5);
        
        btn6=new JButton("6");
        btn6.setBounds(610,350,50,25);
        btn6.setBackground(Color.yellow);
        btn6.setFocusPainted(false);
        btn6.addActionListener(this);
        panel.add(btn6);
        
        btn7=new JButton("7");
        btn7.setBounds(660,350,50,25);
        btn7.setBackground(Color.yellow);
        btn7.setFocusPainted(false);
        btn7.addActionListener(this);
        panel.add(btn7);
        
        btn8=new JButton("8");
        btn8.setBounds(710,350,50,25);
        btn8.setBackground(Color.yellow);
        btn8.setFocusPainted(false);
        btn8.addActionListener(this);
        panel.add(btn8);
        
        btn9=new JButton("9");
        btn9.setBounds(760,350,50,25);
        btn9.setBackground(Color.yellow);
        btn9.setFocusPainted(false);
        btn9.addActionListener(this);
        panel.add(btn9);
        
        //영문키패드
        btnq=new JButton("q");
        btnq.setBounds(310,375,50,25);
        btnq.setBackground(Color.yellow);
        btnq.setFocusPainted(false);
        btnq.addActionListener(this);
        panel.add(btnq);
        
        btnw=new JButton("w");
        btnw.setBounds(360,375,50,25);
        btnw.setBackground(Color.yellow);
        btnw.setFocusPainted(false);
        btnw.addActionListener(this);
        panel.add(btnw);
        
        btne=new JButton("e");
        btne.setBounds(410,375,50,25);
        btne.setBackground(Color.yellow);
        btne.setFocusPainted(false);
        btne.addActionListener(this);
        panel.add(btne);
        
        btnr=new JButton("r");
        btnr.setBounds(460,375,50,25);
        btnr.setBackground(Color.yellow);
        btnr.setFocusPainted(false);
        btnr.addActionListener(this);
        panel.add(btnr);
        
        btnt=new JButton("t");
        btnt.setBounds(510,375,50,25);
        btnt.setBackground(Color.yellow);
        btnt.setFocusPainted(false);
        btnt.addActionListener(this);
        panel.add(btnt);
        
        btny=new JButton("y");
        btny.setBounds(560,375,50,25);
        btny.setBackground(Color.yellow);
        btny.setFocusPainted(false);
        btny.addActionListener(this);
        panel.add(btny);
        
        btnu=new JButton("u");
        btnu.setBounds(610,375,50,25);
        btnu.setBackground(Color.yellow);
        btnu.setFocusPainted(false);
        btnu.addActionListener(this);
        panel.add(btnu);
        
        btni=new JButton("i");
        btni.setBounds(660,375,50,25);
        btni.setBackground(Color.yellow);
        btni.setFocusPainted(false);
        btni.addActionListener(this);
        panel.add(btni);
        
        btno=new JButton("o");
        btno.setBounds(710,375,50,25);
        btno.setBackground(Color.yellow);
        btno.setFocusPainted(false);
        btno.addActionListener(this);
        panel.add(btno);
        
        btnp=new JButton("p");
        btnp.setBounds(760,375,50,25);
        btnp.setBackground(Color.yellow);
        btnp.setFocusPainted(false);
        btnp.addActionListener(this);
        panel.add(btnp);
        
        btna=new JButton("a");
        btna.setBounds(335,400,50,25);
        btna.setBackground(Color.yellow);
        btna.setFocusPainted(false);
        btna.addActionListener(this);
        panel.add(btna);
        
        btns=new JButton("s");
        btns.setBounds(385,400,50,25);
        btns.setBackground(Color.yellow);
        btns.setFocusPainted(false);
        btns.addActionListener(this);
        panel.add(btns);
        
        btnd=new JButton("d");
        btnd.setBounds(435,400,50,25);
        btnd.setBackground(Color.yellow);
        btnd.setFocusPainted(false);
        btnd.addActionListener(this);
        panel.add(btnd);
        
        btnf=new JButton("f");
        btnf.setBounds(485,400,50,25);
        btnf.setBackground(Color.yellow);
        btnf.setFocusPainted(false);
        btnf.addActionListener(this);
        panel.add(btnf);
        
        btng=new JButton("g");
        btng.setBounds(535,400,50,25);
        btng.setBackground(Color.yellow);
        btng.setFocusPainted(false);
        btng.addActionListener(this);
        panel.add(btng);
        
        btnh=new JButton("h");
        btnh.setBounds(585,400,50,25);
        btnh.setBackground(Color.yellow);
        btnh.setFocusPainted(false);
        btnh.addActionListener(this);
        panel.add(btnh);
        
        btnj=new JButton("j");
        btnj.setBounds(635,400,50,25);
        btnj.setBackground(Color.yellow);
        btnj.setFocusPainted(false);
        btnj.addActionListener(this);
        panel.add(btnj);
        
        btnk=new JButton("k");
        btnk.setBounds(685,400,50,25);
        btnk.setBackground(Color.yellow);
        btnk.setFocusPainted(false);
        btnk.addActionListener(this);
        panel.add(btnk);
        
        btnl=new JButton("l");
        btnl.setBounds(735,400,50,25);
        btnl.setBackground(Color.yellow);
        btnl.setFocusPainted(false);
        btnl.addActionListener(this);
        panel.add(btnl);
        
        btnz=new JButton("z");
        btnz.setBounds(385,425,50,25);
        btnz.setBackground(Color.yellow);
        btnz.setFocusPainted(false);
        btnz.addActionListener(this);
        panel.add(btnz);
        
        btnx=new JButton("x");
        btnx.setBounds(435,425,50,25);
        btnx.setBackground(Color.yellow);
        btnx.setFocusPainted(false);
        btnx.addActionListener(this);
        panel.add(btnx);
        
        btnc=new JButton("c");
        btnc.setBounds(485,425,50,25);
        btnc.setBackground(Color.yellow);
        btnc.setFocusPainted(false);
        btnc.addActionListener(this);
        panel.add(btnc);
        
        btnv=new JButton("v");
        btnv.setBounds(535,425,50,25);
        btnv.setBackground(Color.yellow);
        btnv.setFocusPainted(false);
        btnv.addActionListener(this);
        panel.add(btnv);
        
        btnb=new JButton("b");
        btnb.setBounds(585,425,50,25);
        btnb.setBackground(Color.yellow);
        btnb.setFocusPainted(false);
        btnb.addActionListener(this);
        panel.add(btnb);
        
        btnn=new JButton("n");
        btnn.setBounds(635,425,50,25);
        btnn.setBackground(Color.yellow);
        btnn.setFocusPainted(false);
        btnn.addActionListener(this);
        panel.add(btnn);
        
        btnm=new JButton("m");
        btnm.setBounds(685,425,50,25);
        btnm.setBackground(Color.yellow);
        btnm.setFocusPainted(false);
        btnm.addActionListener(this);
        panel.add(btnm);
        
		FocusListener focusListener = new FocusListener() {
            public void focusGained(FocusEvent e) {
                selectedField = (JTextField) e.getSource(); // 포커스를 얻은 텍스트 상자 저장
            }
            public void focusLost(FocusEvent e) {}
        };
        managerIdText.addFocusListener(focusListener);
        managerPwText.addFocusListener(focusListener);
    }
	
	public void connect() {
		try {
			sock = new Socket(host, port);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true/* auto flush */);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// --connect
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object obj=e.getSource();
			if(obj==btnInit)
			{
//				if(sock==null) 
//				{
//					managerConnect();//처음 시도
//				}
				managerIdText.setText("");
	            managerPwText.setText("");
			}
			else if (obj==btnLogin)
			{
				ManagerLoginEvent2 mLE2=new ManagerLoginEvent2();
				int i = mLE2.managerLogin2((managerIdText.getText()), managerPwText.getText());
				if(i == 1){
					FindManagerTable mgr = new FindManagerTable();
					String name = mgr.managerName(managerIdText.getText());//managerName읽어옴
					if(sock==null) {
						connect();
					}
					ManagerMain managerMain = ManagerMain.getInstance(in, out, name);
					managerMain.setVisible(true);
					dispose();
					managerMain.setTitle("FamilyStudyCafe_ManagerMain");
					managerMain.setResizable(false);
					//managerMain.setVisible(true);
					JOptionPane.showMessageDialog(null, "로그인을 환영합니다.");
					
				} else {
					JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 확인하세요");
				}
			}
			else if(obj.equals(btn0))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn0.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn0.getText());
                }
			}
			else if(obj.equals(btn1))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn1.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn1.getText());
                }
			}
			else if(obj.equals(btn2))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn2.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn2.getText());
                }
			}
			else if(obj.equals(btn3))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn3.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn3.getText());
                }
			}
			else if(obj.equals(btn4))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn4.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn4.getText());
                }
			}
			else if(obj.equals(btn5))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn5.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn5.getText());
                }
			}
			else if(obj.equals(btn6))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn6.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn6.getText());
                }
			}
			else if(obj.equals(btn7))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn7.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn7.getText());
                }
			}
			else if(obj.equals(btn8))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn8.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn8.getText());
                }
			}
			else if(obj.equals(btn9))
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btn9.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btn9.getText());
                }
			}
			else if(obj==btnq)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnq.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnq.getText());
                }
			}
			else if(obj==btnw)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnw.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnw.getText());
                }
			}
			else if(obj==btne)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btne.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btne.getText());
                }
			}
			else if(obj==btnr)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnr.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnr.getText());
                }
			}
			else if(obj==btnt)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnt.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnt.getText());
                }
			}
			else if(obj==btny)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btny.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btny.getText());
                }
			}
			else if(obj==btnu)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnu.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnu.getText());
                }
			}
			else if(obj==btni)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btni.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btni.getText());
                }
			}
			else if(obj==btno)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btno.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btno.getText());
                }
			}
			else if(obj==btnp)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnp.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnp.getText());
                }
			}
			else if(obj==btna)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btna.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btna.getText());
                }
			}
			else if(obj==btns)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btns.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btns.getText());
                }
			}
			else if(obj==btnd)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnd.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnd.getText());
                }
			}
			else if(obj==btnf)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnf.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnf.getText());
                }
			}
			else if(obj==btng)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btng.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btng.getText());
                }
			}
			else if(obj==btnh)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnh.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnh.getText());
                }
			}
			else if(obj==btnj)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnj.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnj.getText());
                }
			}
			else if(obj==btnk)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnk.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnk.getText());
                }
			}
			else if(obj==btnl)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnl.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnl.getText());
                }
			}
			else if(obj==btnz)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnz.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnz.getText());
                }
			}
			else if(obj==btnx)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnx.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnx.getText());
                }
			}
			else if(obj==btnc)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnc.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnc.getText());
                }
			}
			else if(obj==btnv)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnv.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnv.getText());
                }
			}
			else if(obj==btnb)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnb.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnb.getText());
                }
			}
			else if(obj==btnn)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnn.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnn.getText());
                }
			}
			else if(obj==btnm)
			{
				if (selectedField == managerIdText) {
                    managerIdText.setText(managerIdText.getText() + btnm.getText());
                } else if (selectedField == managerPwText) {
                    managerPwText.setText(managerPwText.getText() + btnm.getText());
                }
			}
		}
		catch (Exception e2)
		{

		}
	}
	

	
	public static void main(String[] args) {
		new ManagerLogin();
	}
}