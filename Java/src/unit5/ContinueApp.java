package unit5;
//Àı5¡ª13 continueÓï¾äµÄÓ¦ÓÃ¡£
public class ContinueApp {
	public static void main(String[] args){
		for(int j = 0; j < 8; j++){
			if(j == 5){
				continue;
			}
			System.out.print(j+" ");
		}
	}
}
