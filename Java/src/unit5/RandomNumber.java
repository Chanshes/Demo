package unit5;
//��5-7 break����ʹ��
public class RandomNumber {
	public static void main(String[] args){
		int number = 0;
		while(true){
			number = (int)(Math.random()*20+1);
			System.out.print(number+"\t");
			if(number == 10)
				break;
		}
	}
}
