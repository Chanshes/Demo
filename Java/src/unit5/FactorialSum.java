package unit5;
//例5-11 计算从 1到10的阶乘和。
public class FactorialSum {
	//求变量number的阶乘
	public static int factorial(int n){
		int result = 1;
		for(int i = 1;i<=n;i++)
			result = result *i;
		return result;
	}
	public static void main(String[] args){
		int sum = 0;
		for(int i = 1;i<=10;i++)
			sum = sum + factorial(i);
		System.out.println("从1到10的阶乘和为：" + sum);
	}
}
