package unit5;
//例5-6 猜数游戏。
import java.util.Scanner;
public class GuessNumber {
	public static void main(String[] args){
		//定义并初始化变量
		int count = 0;
		int inputNumber = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//产生10以内的正整数
		int number = (int)(Math.random()*10+1);
		System.out.println("产生的随机数在1~10之间，请猜出该数！");
		while(inputNumber != number){
			inputNumber = scanner.nextInt();
			count++;
			if(inputNumber > number)
				System.out.println("您猜大了，请继续猜");
			else if(inputNumber < number)
				System.out.println("您猜小了，请继续猜");
		}
		System.out.println("恭喜您猜中了！共猜了"+ count +"次");
	}
}
