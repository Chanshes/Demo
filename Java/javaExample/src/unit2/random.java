package unit2;
//3
import java.util.Random;

public class random {
	public static void main(String[] args) {
		Random rd = new Random();
		int i = rd.nextInt();
		long l = rd.nextLong();
		float f = rd.nextFloat();
		double d = rd.nextDouble();
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
	}

}
