package ch07;

abstract class Abstract2{
	abstract void prn();
}

abstract class Abstract2_1 extends Abstract2{
	abstract void prn2();
}

class Normal2 extends Abstract2_1{

	@Override
	void prn2() {
	}

	@Override
	void prn() {
	}
	
}

public class AbstractEx2 {
	public static void main(String[] args) {
		
	}
}
