package unit4;
//��4-5 Circle���ʵ��
public class CircleApp{
	public static void main(String[] args){
		double s, p;
		Circle1 insCircle = new Circle1(1,2,6);
		s = insCircle.area();
		p = insCircle.perimeter();
		System.out.println("Բ�İ뾶Ϊ:"+insCircle.radius);
		System.out.println("Բ�����Ϊ:"+s);
		System.out.println("Բ���ܳ�Ϊ:"+p);
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
	double area(){//�����
		double s;
		s = Math.PI * radius * radius;
		return s;
	}
	double perimeter(){//���ܳ�
		double p;
		p = Math.PI * 2 * radius;
		return p;
	}
	void move(double destX, double destY){//Բ��λ�øı�
		xPos = destX;
		yPos = destY;
	}
}