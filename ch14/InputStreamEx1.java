package ch14;

import java.io.IOException;
import java.io.InputStream;

import javax.net.ssl.SSLContext;

public class InputStreamEx1 {

	public static void main(String[] args) {
		InputStream is = System.in;//키보드에 연결된 빨대
		while(true) {
			try {
				int a = is.read();//내부적인 쓰레드 : 입력 전에 대기
				if(a==-1/*ctrl+z*/) break;
				System.out.print((char)a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}








