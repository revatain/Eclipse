package ch07;

//추상클래스 : 도형
abstract class Shape{
	
	int x, y;
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	abstract void draw();
}

//삼각형
class Triangle extends Shape{
	@Override
	void draw() { System.out.println("삼각형 그리기");
	}
}
//사각형
class Rectangle extends Shape{
	@Override
	void draw() { System.out.println("사각형 그리기");
	}
}
//원
class Circle extends Shape{
	@Override
	void draw() { System.out.println("원 그리기");
	}
}


public class AbstractEx4 {

	public static void main(String[] args) {

	}

}
