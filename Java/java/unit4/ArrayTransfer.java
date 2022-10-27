 package unit4;
//例4-9 ArrayTransfer.java的源代码。
//参数引用方式的实例
public class ArrayTransfer {
	void changex(float[] x){
		int i = 0;
		for(i = 0; i < x.length; i++){
			System.out.print("x["+i+"]="+x[i]);
			x[i] *= 2;
		}
		System.out.println();
		for(i = 0; i <  x.length; i++)
			System.out.print("x["+i+"]="+x[i]);
		System.out.println();
	}
	public static void main(String[] args){
		float[] d = new float[2];
		d[0] = 2f;
		d[1] = 5f;
		System.out.print("方法调用前，d[0]为："+d[0]);
		System.out.println(",d[1]为: "+d[1]);
		ArrayTransfer ft = new ArrayTransfer();
		ft.changex(d);
		System.out.print("方法调用后,d[0]为："+d[0]);
		System.out.println(",d[1]为: "+d[1]);
	}
}
