package unit5;
//��5-8 ����ŵ�break����ʹ�á�
public class BreakApp {
	public static void main(String[] args){
		outer: for(int i = 0; i<10; i++){
			System.out.print("i="+i+"\t,j=");
			for(int j = 0; j <= i; j++){
				System.out.print(j+"\t");
				if(i+j == 16){
					System.out.println("�ж�ѭ����");
					break outer;
				}
			}
			System.out.println("���ѭ�����һ��");
		}
	}
}
