package unit5;
//例5-12 使用双重循环计算从1到10的阶乘和。
public class FactorialSum1 {
	public static void main(String[] args){
		int sum = 0;
		int result = 1;
		for(int i = 1; i<=10; i++){
			//1.求i的阶乘
			for(int j = 1; j <= i; j++)
				result = result * j;
			//2.将阶乘值加入到sum中
			sum += result;
			//3.result重新被赋值为1，，用于求下一个数的阶乘
			result = 1;
		}
		System.out.println("从一到10的阶乘和为: " + sum);
	}
}
