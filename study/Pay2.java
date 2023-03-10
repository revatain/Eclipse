package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URI;


public class Pay2 extends JFrame{
	private JButton selectedButton;
	private JButton btntime;//�ð��ǹ�ư
	private JButton btnperiod;//�Ⱓ�� ��ư
	private JLabel label;//����̹���
	private JLabel label2;
	Desktop desktop = Desktop.getDesktop();
	private JLabel payresult;
	

	private JButton btntime1;
	private JButton btntime2;
	private JButton btntime4;
	private JButton btntime6;
	private JButton btntime9;
	private JButton btntime12;
	
	private JButton btncardpay;
	private JButton btncashpay;
	private JButton back;
	
	ImageIcon img=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image/image_exitButton.jpg");
	ImageIcon img2=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image/image_exitButton2.jpg");
	ImageIcon imgtime=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image/time.jpg");
	ImageIcon imageperiod=new ImageIcon("C:\\Users\\dita810\\Desktop\\FSCTeam\\FamilyStudycafe\\src\\img\\Button_image/time2.jpg");
	
	Font font=new Font("맑은 고딕", Font.PLAIN, 17);
	private static Pay2 instance = null;
	
	public static Pay2 getInstance(String memberTel) {
        if (instance == null) {
            instance = new Pay2(memberTel);
        }
        return instance;
        }
	private Pay2(String membertel) {
		setTitle("시간제");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		System.out.println("Pay2:"+membertel);
		
		// panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        payUI(panel);
		
		
		//initGUI
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
        //배경이미지
        label = new JLabel();
//        label.setIcon(new ImageIcon("C:\\Java\\eclipse-workspace\\myjava\\study\\family.jpg"));
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
        
        //시간권버튼
        
        btntime.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Pay pay=Pay.getInstance(membertel);
				pay.setVisible(true);
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
				    	remainplus.remainTimeplus7(membertel);
				    	pay.payadd("7",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime2))
				    {
				    	remainplus.remainTimeplus8(membertel);
				    	pay.payadd("8",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime4))
				    {
				    	remainplus.remainTimeplus9(membertel);
				    	pay.payadd("9",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime6))
				    {
				    	remainplus.remainTimeplus10(membertel);
				    	pay.payadd("10",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime9))
				    {
				    	remainplus.remainTimeplus11(membertel);
				    	pay.payadd("11",membertel);
				    	PayEnter enter=PayEnter.getInstance(membertel);
		                enter.setVisible(true);
		                dispose();
				    }
				    else if (selectedButton.equals(btntime12))
				    {
				    	remainplus.remainTimeplus12(membertel);
				    	pay.payadd("12",membertel);
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
		btntime1.setText(charge.payName("7"));
		btntime1.setBounds(0,167,367,196);
		btntime1.setBackground(Color.yellow);
		btntime1.setFocusPainted(false);
		btntime1.setFont(font);
		panel.add(btntime1);
		btntime1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				String str=charge.pay("7");
				payresult.setText("가격:"+str);
			}
		});
		
		btntime2=new JButton();
		btntime2.setText(charge.payName("8"));
		btntime2.setBounds(367,167,367,196);
		btntime2.setBackground(Color.yellow);
		btntime2.setFocusPainted(false);
		btntime2.setFont(font);
		panel.add(btntime2);
		btntime2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("8");
				payresult.setText("가격:"+str);
			}
		});
		
		btntime4=new JButton();
		btntime4.setText(charge.payName("9"));
		btntime4.setBounds(734,167,367,196);
		btntime4.setBackground(Color.yellow);
		btntime4.setFocusPainted(false);
		btntime4.setFont(font);
		panel.add(btntime4);
		btntime4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("9");
				payresult.setText("가격:"+str);
			}
		});
		
		btntime6=new JButton();
		btntime6.setText(charge.payName("10"));
		btntime6.setBounds(0,363,367,196);
		btntime6.setBackground(Color.yellow);
		btntime6.setFocusPainted(false);
		btntime6.setFont(font);
		panel.add(btntime6);
		btntime6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("10");
				payresult.setText("가격:"+str);
			}
		});
		
		btntime9=new JButton();
		btntime9.setText(charge.payName("11"));
		btntime9.setBounds(367,363,367,196);
		btntime9.setBackground(Color.yellow);
		btntime9.setFocusPainted(false);
		btntime9.setFont(font);
		panel.add(btntime9);
		btntime9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				String str=charge.pay("11");
				payresult.setText("가격:"+str);
				
			}
		});

		btntime12=new JButton();
		btntime12.setText(charge.payName("12"));
		btntime12.setBounds(734,363,367,196);
		btntime12.setBackground(Color.yellow);
		btntime12.setFocusPainted(false);
		btntime12.setFont(font);
		panel.add(btntime12);
		btntime12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=charge.pay("12");
				payresult.setText("가격:"+str);
			}
		});
		
		btncardpay=new JButton("카드결제");
		btncardpay.setBounds(800,560,300,100);
		btncardpay.setBackground(Color.red);
		btncardpay.setFont(font);
		panel.add(btncardpay);
		
		btncashpay=new JButton("현금결제");
		btncashpay.setBounds(500,560,300,100);
		btncashpay.setBackground(Color.cyan);
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
		
	}
	
	

}