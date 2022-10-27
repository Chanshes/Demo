package unit4;
//例4-10 重载方法的使用
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
		System.out.println("圆的面积为: "+area1.area(3.0));
		System.out.println("长方形的面积为: "+area1.area(3.0, 2.0));
		System.out.println("梯形的面积为: "+area1.area(4.0,8.0,6.0));
	}
}
