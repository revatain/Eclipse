package net;

public class ChatProtocol3 {
	// ID, CHAT, CHATALL, MESSAGE, CHATLIST
	// {C => S} ID : aaa
	// {S => C} CHATLIST:aaa;bbb;ccc;홍길동;
	public static final String ID = "ID";
	// {C => S} CHAT : 받는아이디; 메세지 ex) CHAT:bbb;밥먹자
	// {S => C} CHAT : 보내는 아이디; 메세지 ex) CHAT:aaa;밥먹자
	public static final String CHAT = "CHAT";
	// {C => S} CHATALL : 메세지
	// {S => C} CHATALL : [보내는 아이디] 메세지
	public static final String CHATALL = "CHATALL";

	// {C => S} MESSAGE : 받는 아이디;쪽지 내용
	// {S => C} MESSAGE : 보내는 아이디;쪽지 내용
	public static final String MESSAGE = "MESSAGE";
	// (C->S) MSGLIST:id
	// (S->C) MSGLIST:fid,tid,msg;fid,tid,msg;...
	// (S->C) MSGLIST:aaa,bbb,밥먹자;bbb,ccc,하이...
	public static final String MSGLIST = "MSGLIST";
	
	// {S => C} CHATLIST:aaa;bbb;ccc;홍길동;
	public static final String CHATLIST = "CHATLIST";

	public static final String MODE = ":";

	public static void main(String[] args) {

	}

}
