package net;

public class ChatProtocol3 {
	// ID, CHAT, CHATALL, MESSAGE, CHATLIST
	// {C => S} ID : aaa
	// {S => C} CHATLIST:aaa;bbb;ccc;ȫ�浿;
	public static final String ID = "ID";
	// {C => S} CHAT : �޴¾��̵�; �޼��� ex) CHAT:bbb;�����
	// {S => C} CHAT : ������ ���̵�; �޼��� ex) CHAT:aaa;�����
	public static final String CHAT = "CHAT";
	// {C => S} CHATALL : �޼���
	// {S => C} CHATALL : [������ ���̵�] �޼���
	public static final String CHATALL = "CHATALL";

	// {C => S} MESSAGE : �޴� ���̵�;���� ����
	// {S => C} MESSAGE : ������ ���̵�;���� ����
	public static final String MESSAGE = "MESSAGE";
	// (C->S) MSGLIST:id
	// (S->C) MSGLIST:fid,tid,msg;fid,tid,msg;...
	// (S->C) MSGLIST:aaa,bbb,�����;bbb,ccc,����...
	public static final String MSGLIST = "MSGLIST";
	
	// {S => C} CHATLIST:aaa;bbb;ccc;ȫ�浿;
	public static final String CHATLIST = "CHATLIST";

	public static final String MODE = ":";

	public static void main(String[] args) {

	}

}
