package unit4;
//4
//�����������һλ������Ȼ���������������Ų����㣬�ж������Ƿ���ȷ,��.�˳���
import java.util.Random;
import java.util.Scanner;

public class Stochastic {
	public static void main(String[] args){
	out:	while(true){
			Random r = new Random();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int ran1 = r.nextInt(21);
			int ran2 = r.nextInt(21);
			int ran3 = r.nextInt(3);
			char Char;
			if(ran3 == 0){
				Char = '+';
			}
			else if(ran3 == 1){
				Char = '-';
			}
		 	else if(ran3 == 2){
				Char = '*';
			}
			else{
				Char = '/';
			}
			if(ran3 == 3 && ran2 == 0){
				continue;
			}
			System.out.printf("%d%c%d=",ran1,Char,ran2);
			String scanner = sc.next();
			if(scanner == "q" || scanner == "Q"){
				break out;
			}
			int str = Integer.parseInt(scanner);
			if(str == Randadd(ran1,ran2,Char)){
				System.out.println("����ȷ��");
			}
			else{
				System.out.println("����");
			}
		}
	}
	static int Randadd(int r1, int r2, char Char){
		if(Char == '+'){
			return r1+r2;
		}
		else if(Char == '-'){
			return r1-r2;
		}
		else if(Char == '*'){
			return r1*r2;
		}
		else{
			return r1/r2;
		}
	}
}
