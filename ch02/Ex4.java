package ch02;

public class Ex4 {

	public static void main(String[] args) {
		char a1 = 'A';
		char a2 = 65;
		char a3 = '\u0041';
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		
		char b1 = '가';
		char b2 = 44032;
		char b3 = '\uac00';
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
}