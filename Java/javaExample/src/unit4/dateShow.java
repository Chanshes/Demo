package unit4;
//8
import java.util.Scanner;

public class dateShow {
	public static void main(String[] args){
		int year, month,day = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份:");
		year = sc.nextInt();
		System.out.println("请输入月份:");
		month = sc.nextInt();
		if(month >= 0 && month <= 12){
			switch(month){
			case 1:day = 31;break;
			case 2:day = 28;break;
			case 3:day = 31;break;
			case 4:day = 30;break;
			case 5:day = 31;break;
			case 6:day = 30;break;
			case 7:day = 31;break;
			case 8:day = 31;break;
			case 9:day = 30;break;
			case 10:day = 31;break;
			case 11:day = 30;break;
			case 12:day = 31;break;
			}
			if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
				if(month == 2)
					day++;
			}
			System.out.println("此月有"+day+"天");
		}
		else{
			System.out.println("请正确输入年月份！");
		}
	}
}
