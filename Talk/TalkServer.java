package Talk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class TalkServer {
	public static final int PORT = 8003;
	ServerSocket server;
	Vector<ClientThread2> vc;

	public TalkServer() {
		try {
			server = new ServerSocket(PORT);
			vc = new Vector<ClientThread2>();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Error in Server");
			System.exit(1);
		}
		System.out.println("******Talk Server 1.0*******");
		System.out.println("Ŭ���̾�Ʈ ������ ��ٸ��� �ֽ��ϴ�");
		System.out.println("************************");
		try {
			while (true) {
				Socket sock = server.accept();
				ClientThread2 ct = new ClientThread2(sock);
				ct.start();
				// ������ Ŭ���̾�Ʈ Socket ��ü�� Vector ����
				vc.addElement(ct);
			}
		} catch (Exception e) {
//		e.printStackTrace();
			System.err.println("Error in Socket");
		}
	}

	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			ClientThread2 ct = vc.get(i);
			ct.sendMessage(msg);
		}
	}

	public void removeClient(ClientThread2 ct) {
		vc.remove(ct);
	}

	// ���ӵ� ��� ������ ����Ʈ ����
	public String getIdList() {
		String list = "";
		for (int i = 0; i < vc.size(); i++) {
			ClientThread2 ct = vc.get(i);
			list += ct.id + ";";
		}
		return list;
	}

	// ���� ������, �ӼӸ� ���̵�� Ŭ���̾�Ʈ Ž��
	public ClientThread2 findClient(String id) {
		ClientThread2 ct = null;
		for (int i = 0; i < vc.size(); i++) {
			ct = vc.get(i);
			if (ct.id.equals(id)) // �Ű����� id�� ct�� id�� �����ϴٸ�.
				break;
		}
		return ct;
	}

	class ClientThread2 extends Thread {
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;

		public ClientThread2(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(), true);
				sock.toString();
				System.out.println(sock.toString() + " ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				sendMessage("����Ͻ� ���̵� �Է��ϼ���");
				while (true) {
					String line = in.readLine();
					if (line == null)
						break;
					else
						routine(line);
				}
			} catch (Exception e) {
				removeClient(this);
				System.err.println(sock + "[" + id + "] ������...");
			}
		}

		public void routine(String line) {
			int idx = line.indexOf(':');
			String cmd = line.substring(0, idx);
			String data = line.substring(idx + 1);
			if (cmd.equals(TalkProtocol.ID)) {
				id = data;
				sendAllMessage(TalkProtocol.CHATLIST + TalkProtocol.MODE + getIdList());
				sendAllMessage(TalkProtocol.CHATALL + TalkProtocol.MODE + "[" + id + "]���� �����Ͽ����ϴ�");
			} else if (cmd.equals(TalkProtocol.CHATALL)) {
				sendAllMessage(TalkProtocol.CHATALL + TalkProtocol.MODE + "[" + id + "]" + data);
			} else if (cmd.equals(TalkProtocol.CHAT)) {
				idx = data.indexOf(';');
				cmd = data.substring(0, idx);
				data = data.substring(idx + 1);
				ClientThread2 ct = findClient(cmd);
				if (ct != null) {
					// id : bbb�� ���� Ŭ���̾�Ʈ �˻�
					ct.sendMessage(TalkProtocol.CHAT + TalkProtocol.MODE + "[" + id + "(S)]" + data); // bbb���� ����
					sendMessage(TalkProtocol.CHAT + TalkProtocol.MODE + "[" + id + "(S)]" + data); // �ڽſ��� ����
				} else {
					// �ڽſ��� ������ �޼���
					sendMessage(TalkProtocol.CHAT + TalkProtocol.MODE + "[" + cmd + "]���� �����ڰ� �ƴմϴ�");
				}
			} else if (cmd.equals(TalkProtocol.MESSAGE)) {
				idx = data.indexOf(';');
				cmd = data.substring(0, idx);
				data = data.substring(idx + 1);
				ClientThread2 ct = findClient(cmd);
				if (ct != null) {
					ct.sendMessage(TalkProtocol.MESSAGE + TalkProtocol.MODE + id + ";" + data);
				} else {
					sendMessage(TalkProtocol.CHAT + TalkProtocol.MODE + "[" + cmd + "]���� �����ڰ� �ƴմϴ�");
				}
			}
		}

		public void sendMessage(String msg) {
			out.println(msg);
		}

	}

	public static void main(String[] args) {
		new TalkServer();
//		String str = "CHATALL:������ ������Դϴ�.";
//		int idx = str.indexOf(':');
//		System.out.println(str.substring(0, idx));
//		System.out.println(str.substring(idx + 1));
	}
}
