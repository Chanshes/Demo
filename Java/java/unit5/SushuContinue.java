package unit5;
//��5-14 ����ŵ�continue����Ӧ�á�
public class SushuContinue {
	public static void main(String[] args){
		System.out.println("100���ڵ�����Ϊ��");
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
