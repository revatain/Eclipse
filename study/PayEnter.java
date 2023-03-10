package study;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PayEnter  extends JFrame{

	private JPanel payenterPanel;
	private JTextField textField;
	private static PayEnter instance = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayEnter window = new PayEnter("-test-");
					window.setTitle("FSC_PayEnter");
					window.setVisible(true);
					window.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static PayEnter getInstance(String userText) {
        if (instance == null) {
            instance = new PayEnter(userText);
        }
        return instance;
        }

	private PayEnter(String membertel) {
		setTitle("FamilyStudyCafe_PayEnter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1056,570);
		this.setResizable(false);
		this.setVisible(true);
		System.out.println("PayEnter:"+membertel);
		
		payenterPanel = new JPanel();
		payenterPanel.setBounds(100, 100, 1056, 570);
		payenterPanel.setLayout(null);
		setContentPane(payenterPanel);
		
		Button button1 = new Button("시간제 & 기간제 결제하기");
		button1.setBounds(0, 20, 528, 510);
		button1.setBackground(new Color(143, 188, 143));
		button1.setPreferredSize(new Dimension(216, 0));
		payenterPanel.add(button1);
		// 시간제 결제하기 버튼 button1
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if ((Button) obj == button1) {
//					Frame fs = new Frame();
//					fs.setVisible(true);
//					fs.setSize(700, 600);
//					fs.setLocation(200, 200);
//					fs.dispose();
					
					Pay pay=Pay.getInstance(membertel);
					pay.setVisible(true);
					dispose();
				}
			}
		});// 시간제 & 기간제 결제창 실행
		
		Button button2 = new Button("입실하기");
		button2.setBounds(528, 20, 528, 510);
		button2.setBackground(new Color(112, 128, 144));
		button2.setPreferredSize(new Dimension(216, 0));
		payenterPanel.add(button2);
		button2.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                FindMemberTable fmt = new FindMemberTable();
                try {
                    String remtime = fmt.findRemainTime(membertel);
                    String rtsplit[] = remtime.split("");
                    System.out.println("PayEnter_remtime is:" + remtime);
                    System.out.println("PayEnter_rtsplit is:" + rtsplit[0] + rtsplit[1] + rtsplit[2] + rtsplit[3]
                            + rtsplit[4] + rtsplit[5] + rtsplit[6] + rtsplit[7]);
                    // List로 바꿔서 : 제거 후 다시 배열으로
                    List<String> rtList = new ArrayList<>(Arrays.asList(rtsplit));
                    rtList.removeAll(Arrays.asList(":"));
                    rtsplit = rtList.toArray(new String[0]);

                    System.out.println("PayEnter_new rtsplit is:" + rtsplit[0] + rtsplit[1] + rtsplit[2] + rtsplit[3]
                            + rtsplit[4] + rtsplit[5]);
                    if (remtime.equals("00:00:00")) 
                    { //시간이 없으면 안내 메세지 띄움
                        JOptionPane.showMessageDialog(null, "시간 결제 후 이용해주세요");
                    }
                    else 
                    { 
                        {
                            SeatSelect ss = SeatSelect.getInstance(membertel);
                            ss.setTitle("FamilyStudyCafe_SeatSelect");
                            dispose();
                        }

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
		});
		// 입실하기 버튼 button2

		textField = new JTextField();
		textField.setBounds(0, 0, 1040, 20);
		textField.setBackground(new Color(135, 206, 250));
		textField.setText("결제하기, 입실하기 중에서 선택해주세요");
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.CENTER);
		payenterPanel.add(textField);
		textField.setColumns(20);
	}
}