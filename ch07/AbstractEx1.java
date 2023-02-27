package ch07;

import java.awt.Component;

//추상클래스
abstract class Abstract1{
	//추상메서드
	abstract void prn();
}
class Normal1 extends Abstract1{
	@Override
	void prn() {
	}
}
class MComponent extends Component{
	
}

public class AbstractEx1 {
	public static void main(String[] args) {
		Abstract1 a;
		//a = new Abstract1();
		a = new Normal1();
	}
}







