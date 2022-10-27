package unit5;
//例5-8 带标号的break语句的使用。
public class BreakApp {
	public static void main(String[] args){
		outer: for(int i = 0; i<10; i++){
			System.out.print("i="+i+"\t,j=");
			for(int j = 0; j <= i; j++){
				System.out.print(j+"\t");
				if(i+j == 16){
					System.out.println("中断循环！");
					break outer;
				}
			}
			System.out.println("外层循环最后一句");
		}
	}
}
