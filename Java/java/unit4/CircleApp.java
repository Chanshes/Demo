package unit4;
//例4-5 Circle类的实现
public class CircleApp{
	public static void main(String[] args){
		double s, p;
		Circle1 insCircle = new Circle1(1,2,6);
		s = insCircle.area();
		p = insCircle.perimeter();
		System.out.println("圆的半径为:"+insCircle.radius);
		System.out.println("圆的面积为:"+s);
		System.out.println("圆的周长为:"+p);
	}
	
}

class Circle1{
	double radius;
	double xPos;
	double yPos;
	Circle1(double r, double x, double y){
		radius = r;
		xPos = x;
		yPos = y;
	}
	double area(){//求面积
		double s;
		s = Math.PI * radius * radius;
		return s;
	}
	double perimeter(){//求周长
		double p;
		p = Math.PI * 2 * radius;
		return p;
	}
	void move(double destX, double destY){//圆的位置改变
		xPos = destX;
		yPos = destY;
	}
}