package unit4;
//圆形类的定义 4-1/2/3
public class Circle {//Circle类头定义
	//域定义
	double xPos;
	double yPos;
	double radius;
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
//构造圆的对象 调用函数
	public static void main(String[] args){
			
		Circle A = new Circle();
		//缺省构造方法对象时，系统用缺省值初始化类对象的数据成员P55
		A.radius = 2;
		A.move(2.0,2.0);
		System.out.printf("area=%2.4f\n",A.area());
		System.out.printf("perimeter=%2.4f\n", A.perimeter());
		System.out.printf("x=%2.2f, y=%2.2f\n", A.xPos, A.yPos);
	}
}
