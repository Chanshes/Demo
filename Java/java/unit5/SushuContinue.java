package unit5;
//例5-14 带标号的continue语句的应用。
public class SushuContinue {
	public static void main(String[] args){
		System.out.println("100以内的素数为：");
		loop:
			for(int i = 2; i < 100; i++){
				for(int j = 2; j < i/2; j++){
					if(i %j == 0)
						continue loop;
					}
				System.out.print(" "+ i);
				}
			}
}
