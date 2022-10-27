package unit3;
//3
public class Volume {
	public static void main(String[] args){
		double circle = 3;
		double height = 6;
		double result;
		result = volume(circle, height);
		System.out.println("圆柱体体积为："+result);
	}
	static double volume(double c, double h){
		return c*c*Math.PI*h;
	}
}
