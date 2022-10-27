package unit5;
//例5-9 用do···while语句实现猜数游戏。
import java.util.Scanner;
public class GuessNumberDoWhile {
	public static void main(String[] args){
		//定义并初始化变量
		int count = 0;
		int inputNumber; //不需要初始化为0
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//产生10以内的正整数
		int number = (int)(Math.random()*10+1);
		//循环判断输入值与随机数大小
		System.out.println("产生的随机数在1~10之间，请猜出该数！");
		do{
			inputNumber = scanner.nextInt();
			count++;
			if(inputNumber > number)
				System.out.println("您猜大了，请继续猜");
			else if(inputNumber < number)
				System.out.println("您猜小了，请继续猜");
		}while(inputNumber != number);
		System.out.println("恭喜您猜中了！共猜了"+count+"次");
	}
}
