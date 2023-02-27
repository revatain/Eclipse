package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends MFrame {

	Button btn;
	boolean flag = false;
	
	public MyFrame2() {
		btn = new Button("Button2");
		add(btn, BorderLayout.SOUTH);
		setBackground(Color.GREEN);
		MyAction ma = new MyAction();
		btn.addActionListener(ma);
	}
	
	class MyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(flag)
				setBackground(Color.GREEN);
			else
				setBackground(Color.YELLOW);
			flag=!flag;
		}
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}
}
