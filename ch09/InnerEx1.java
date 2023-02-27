package ch09;
/*내부(중첩)클래스 
 * 1.클래스 안에 선언.(활용 : 100%)
 * 2.클래스안에 선언이지만 static 클래스 선언(활용 : 1%)
 * 3.메서드안에 클래스 선언(활용 : 10%)
 * 4.메서드 안에 선언을하고 선언과 동시 생성 익명클래스(활용 : 100%)
 * */

interface MyInter{
	void prn();
}

class Outer1 {
	
	class Inner1{}
	
	static class Inner2{}
	
	//메서드 안에 메서드 선언 불가
	void prn(){
		class Inner3{
			
		} 
		
		 new MyInter() {
			@Override
			public void prn() {
			}
		};
	}
	
}//---class Inner1

public class InnerEx1 {

	public static void main(String[] args) {

	}
}




