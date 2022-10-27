package unit4;
//6
public class forFind {
	public static void main(String[] args){
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		int b = 5;
		out: for(int i = 0; i < 3; i++){
			for(int j =0; j < 3; j++){
				if(b == a[i][j]){
					System.out.print(a[i][j]);
					break out;
				}
			}
		}
	}
}
