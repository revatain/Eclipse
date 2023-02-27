package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//채팅 프로그램 서버
public class EchoServer {

	public static final int PORT = 8000;

	public EchoServer() {
		try {
			int cnt = 0; // Client 접속 개수
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("EchoServer Start........");
			while (true) {
				// Client가 접속할때까지 대기 상태
				Socket sock = server.accept();
				EchoThread et = new EchoThread(sock);
				et.start();// 만들어진 소켓들 각 클라이언트에게 보냄
				cnt++;
				System.out.println("Client " + cnt + " Socket");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	BufferedReader in;
	PrintWriter out;
	Socket sock;

	// Client를 대응 관리하기 위한 Thread 상속 내부 클래스 선언
	class EchoThread extends Thread {
		Socket sock;

		public EchoThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				// 클라이언트에 보내는 스트림에 대한 객체가 out임, 클라이언트가 접속 후 서버에게서 처음 받게되는 메세지임
				out.println("Hello Enter BYB to exit");
				while (true) {
					// 클라이언트가 메시지 보낼때까지 대기
					String line = in.readLine();
					if (line == null) // 클라이언트가 접속종료(로그아웃 안하고 컴 끄는 등)
					{
						break;
					} else {
						out.println("Echo : " + line);
						if (line.equalsIgnoreCase("BYB"))
							break;
					}
				} // --while
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		EchoServer server = new EchoServer();
	}
}