package unit2;
//1
import java.util.Scanner;

public class circle {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		double result1,result2;
		System.out.print("请输入半径:");
		double radius = sc.nextDouble();
		System.out.print("请输入高:");
		double height = sc.nextDouble();
		result1 = area(radius);
		result2 = volume(radius,height);
		System.out.println("圆面积为："+result1);
		System.out.println("圆柱体体积为："+result2);
	}
	static double area(double r){
		return Math.PI * r * r;
	}
	static double volume(double r,double h){
		return area(r) * h;
	}
}
