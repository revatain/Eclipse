package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URI;


public class Pay extends JFrame{
	JButton selectedButton=null;
	private JButton btntime;//시간권
	private JButton btnperiod;//기간권
	private JLabel label;//배경이미지
	private JLabel label2;
	private JLabel payresult;
	Desktop desktop = Desktop.getDesktop();
	

	private JButton btntime1;
	private JButton btntime2;
	private JButton btntime4;
	private JButton btntime6;
	private JButton btntime9;
	private JButton btntime12;
	
	private JButton btncardpay;
	private JButton btncashpay;
	private JButton back;
	String num="1";
	private static Pay instance = null;
	
	ImageIcon img=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image/image_exitButton.jpg");
	ImageIcon img2=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image/image_exitButton2.jpg");
	ImageIcon imgtime=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image/time.jpg");
	ImageIcon imageperiod=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image/time2.jpg");
	
	Font font=new Font("맑은 고딕", Font.PLAIN, 17);
	
	public static Pay getInstance(String memberTel) {
        if (instance == null) {
            instance = new Pay(memberTel);
        }
        return instance;
        }
	
	
	
	private Pay(String membertel) {
		setTitle("시간제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		System.out.println("Pay:"+membertel);
		
		// panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        payUI(panel);
		
		
		//initGUI
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
		 //배경이미지
        label = new JLabel();
        label.setBounds(0, 0, 1100, 700);
        panel.add(label);
        
        label2=new JLabel();
        label2.setBounds(0,0,1100,100);
        label2.setOpaque(true); 
        label2.setBackground(Color.pink);
        label2.setText("                                                                            원하는 메뉴를 선택하세요.");
        label2.setFont(font);
        panel.add(label2);

        // add
        getContentPane().add(panel);
       
        // visible
        setVisible(true);
        
        //기간권버튼
        btnperiod.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Pay2 pay2=Pay2.getInstance(membertel);
				pay2.setVisible(true);
				dispose();
				
			}
		});
        
      //뒤로가기버튼
        back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserLogin ui1=UserLogin.getInstance();
				ui1.setVisible(true);
				dispose();
			}
		});
        
        FocusListener focusListener = new FocusListener() {
            public void focusGained(FocusEvent e) {
                selectedButton = (JButton) e.getSource(); // 포커스를 얻은 텍스트 상자 저장
            }
            public void focusLost(FocusEvent e) {}
        };
        btntime1.addFocusListener(focusListener);
        btntime2.addFocusListener(focusListener);
        btntime4.addFocusListener(focusListener);
        btntime6.addFocusListener(focusListener);
        btntime9.addFocusListener(focusListener);
        btntime12.addFocusListener(focusListener);
        
      //현금결제
        btncashpay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?", "결제", JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION) {
				    // 확인 버튼이 눌렸을 때의 액션
				    UserLoginEvent remainplus=new UserLoginEvent();
				    PayEvent pay=new PayEvent();
				    if (selectedButton.equals(btntime1))
				    {
				    	remainplus.remainTimeplus1(membertel);
				    	pay.payadd("1",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime2))
				    {
				    	remainplus.remainTimeplus2(membertel);
				    	pay.payadd("2",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime4))
				    {
				    	remainplus.remainTimeplus3(membertel);
				    	pay.payadd("3",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime6))
				    {
				    	remainplus.remainTimeplus4(membertel);
				    	pay.payadd("4",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime9))
				    {
				    	remainplus.remainTimeplus5(membertel);
				    	pay.payadd("5",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime12))
				    {
				    	remainplus.remainTimeplus6(membertel);
				    	pay.payadd("6",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }  
				}
				
			}
		});
      //카드결제
        btncardpay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URI uri = new URI("C:/Users/dita810/Desktop/FSCTeam/FamilyStudycafe/Button_image/pay.html");
	                desktop.browse(uri);
	                PayEnter enter=PayEnter.getInstance(membertel);
	                enter.setVisible(true);
	                dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
        
        
		
	}
	public void payUI(JPanel panel){
		panel.setLayout(null);
		PayEvent charge=new PayEvent();
		btntime1=new JButton();
		btntime1.setText(charge.payName("1"));
		btntime1.setBounds(0,167,367,196);
		btntime1.setBackground(Color.yellow);
		btntime1.setFont(font);
		btntime1.setFocusPainted(false);

		panel.add(btntime1);
		btntime1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PayEvent charge1=new PayEvent();
		        String str=charge.pay("1");
		        payresult.setText("가격:"+str);
				
				
			}
		});
		
		btntime2=new JButton();
		btntime2.setText(charge.payName("2"));
		btntime2.setBounds(367,167,367,196);
		btntime2.setBackground(Color.yellow);
		btntime2.setFont(font);
		btntime2.setFocusPainted(false);
		panel.add(btntime2);
		btntime2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("2");
				payresult.setText("가격:"+str);
			}
		});
		

		btntime4=new JButton();
		btntime4.setText(charge.payName("3"));
		btntime4.setBounds(734,167,367,196);
		btntime4.setBackground(Color.yellow);
		btntime4.setFont(font);
		btntime4.setFocusPainted(false);
		panel.add(btntime4);
		btntime4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("3");
				payresult.setText("가격:"+str);
			}
		});
		

		btntime6=new JButton();
		btntime6.setText(charge.payName("4"));
		btntime6.setBounds(0,363,367,196);
		btntime6.setBackground(Color.yellow);
		btntime6.setFont(font);
		btntime6.setFocusPainted(false);
		panel.add(btntime6);
		btntime6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("4");
				payresult.setText("가격:"+str);
			}
		});
		btntime9=new JButton();
		btntime9.setText(charge.payName("5"));
		btntime9.setBounds(367,363,367,196);
		btntime9.setBackground(Color.yellow);
		btntime9.setFont(font);
		btntime9.setFocusPainted(false);
		panel.add(btntime9);
		btntime9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("5");
				payresult.setText("가격:"+str);
			}
		});
		btntime12=new JButton();
		btntime12.setText(charge.payName("6"));
		btntime12.setBounds(734,363,367,196);
		btntime12.setBackground(Color.yellow);
		btntime12.setFont(font);
		btntime12.setFocusPainted(false);
		panel.add(btntime12);
		btntime12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("6");
				payresult.setText("가격:"+str);
			}
		});
		
		btncardpay=new JButton("카드결제");
		btncardpay.setBounds(800,560,300,100);
		btncardpay.setBackground(Color.red);
		btncardpay.setFont(font);
		btncardpay.setBorderPainted(false);
		panel.add(btncardpay);
		
		btncashpay=new JButton("현금결제");
		btncashpay.setBounds(500,560,300,100);
		btncashpay.setBackground(Color.cyan);
		btncashpay.setBorderPainted(false);
		btncashpay.setFont(font);
		panel.add(btncashpay);
		
		back = new JButton(img);
		back.setBounds(0, 610, 300, 50);
		back.setRolloverIcon(img2);
		back.setBorderPainted(false);

		panel.add(back);
		
		btntime=new JButton(imgtime);
		btntime.setBounds(0,70, 550,98);
		panel.add(btntime);
		
		btnperiod=new JButton(imageperiod);
		btnperiod.setBounds(550, 70, 550, 98);
		panel.add(btnperiod);
		
		payresult=new JLabel();
		payresult.setText("가격:0");
		payresult.setBounds(330, 618, 100, 50);
		
		payresult.setFont(font);
		panel.add(payresult);
		

	
	}
	public static void main(String[] args) {
		new Pay("test");
		
	}
	
	

}