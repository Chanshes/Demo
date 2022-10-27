package unit7;

public class yichang {
	@SuppressWarnings("finally")
	public static int mb_method(){
		try{
			return 1;
//		}catch(Throwabel e){
//			return 2;
		}finally{
			return 3;
		}
		
	}
	public static void main(String[] args){
		System.out.println(mb_method());
	}
}
