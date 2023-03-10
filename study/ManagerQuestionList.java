package study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManagerQuestionList extends JFrame
implements ActionListener{
	
	String id;
	BufferedReader in;
	PrintWriter out;
	List questionList;
	JButton bt1,bt2;
	String listTitle = "*******질문 명단*******";
	private static ManagerQuestionList instance=null;
	public static synchronized ManagerQuestionList getInstance(BufferedReader in,PrintWriter out,String name) {
	      if (instance == null) {
	         instance = new ManagerQuestionList(in, out, name);
	      }
	      return instance;
	  }
	
	private ManagerQuestionList(BufferedReader in, PrintWriter out, String id) {
		setSize(450, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.in = in;
		this.out = out;
		this.id = id;
		setTitle("채팅방 목록");
		// //////////////////////////////////////////////////////////////////////////////////////////
		questionList = new List();
		questionList.setBackground(new Color(230,239,255));
		questionList.setForeground(Color.BLACK);
		add(BorderLayout.CENTER, questionList);
		// /////////////////////////////////////////////////////////////////////////////////////////
		// ///////////////////////////////////////////////////////////////////////////////////////////
		JPanel p4 = new JPanel();
		bt1 = new JButton("삭제하기");
		bt2 = new JButton("나가기");
		p4.add(bt1);
		p4.add(bt2);
		add(BorderLayout.SOUTH, p4);
		bt2.addActionListener(this);
		bt1.addActionListener(this);
		setVisible(true);
		validate();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt1) {
			if(questionList.getSelectedItem() != null) {
				String str = questionList.getSelectedItem();
				out.println(ChatProtocol2.DELETELIST+ChatProtocol2.MODE+str);
			}
		}else if(obj == bt2) {
			dispose();
		}
	}
	
	public void open() {
		out.println(ChatProtocol2.LISTCHECK+ChatProtocol2.MODE+
				id);
	}
	
	public void removeList(String str) {
		questionList.remove(str);
	}
	
	public void addList(String str) {
		questionList.add(str);
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
