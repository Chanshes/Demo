package unit4;
//��4-10 ���ط�����ʹ��
public class GraphicArea {
	double area(double r){
		return(Math.PI*r*r);
	}
	double area(double width, double height){
		return(width * height);
	}
	double area(double x, double y, double z){
		return(z * (x + y) / 2);
	}
	public static void main(String args[]){
		GraphicArea area1 = new GraphicArea();
		System.out.println("Բ�����Ϊ: "+area1.area(3.0));
		System.out.println("�����ε����Ϊ: "+area1.area(3.0, 2.0));
		System.out.println("���ε����Ϊ: "+area1.area(4.0,8.0,6.0));
	}
}
