package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//ä�� ���α׷� ����
public class EchoServer {

	public static final int PORT = 8000;

	public EchoServer() {
		try {
			int cnt = 0; // Client ���� ����
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("EchoServer Start........");
			while (true) {
				// Client�� �����Ҷ����� ��� ����
				Socket sock = server.accept();
				EchoThread et = new EchoThread(sock);
				et.start();// ������� ���ϵ� �� Ŭ���̾�Ʈ���� ����
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

	// Client�� ���� �����ϱ� ���� Thread ��� ���� Ŭ���� ����
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
				// Ŭ���̾�Ʈ�� ������ ��Ʈ���� ���� ��ü�� out��, Ŭ���̾�Ʈ�� ���� �� �������Լ� ó�� �ްԵǴ� �޼�����
				out.println("Hello Enter BYB to exit");
				while (true) {
					// Ŭ���̾�Ʈ�� �޽��� ���������� ���
					String line = in.readLine();
					if (line == null) // Ŭ���̾�Ʈ�� ��������(�α׾ƿ� ���ϰ� �� ���� ��)
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