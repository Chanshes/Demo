package unit4;
//Բ����Ķ��� 4-1/2/3
public class Circle {//Circle��ͷ����
	//����
	double xPos;
	double yPos;
	double radius;
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
//����Բ�Ķ��� ���ú���
	public static void main(String[] args){
			
		Circle A = new Circle();
		//ȱʡ���췽������ʱ��ϵͳ��ȱʡֵ��ʼ�����������ݳ�ԱP55
		A.radius = 2;
		A.move(2.0,2.0);
		System.out.printf("area=%2.4f\n",A.area());
		System.out.printf("perimeter=%2.4f\n", A.perimeter());
		System.out.printf("x=%2.2f, y=%2.2f\n", A.xPos, A.yPos);
	}
}
