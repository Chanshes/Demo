package unit1;
import java.util.Scanner;
public class TestInputScanner {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner StdinScanner = new Scanner(System.in);
		String testLine;
		System.out.println("ÇëÊäÈë×Ö·û´®£º");
		testLine = StdinScanner.nextLine();
		System.out.println(testLine);
	}
}
