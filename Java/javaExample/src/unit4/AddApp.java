package unit4;
//3
//使用while循环编程找出100-999之间有哪些水仙花数。水仙花数：153=1^3+5^3+3^3

public class AddApp 
{
	public int f(int x,int y)//求x的y次方
	{
		int z=1;
		for(int i=1;i<=y;i++)
		{
			z*=x;
		}
		return z;
	}
	public static void main(String[] args)
	{
		AddApp aa=new AddApp();
		int i=100;
		while(i<=999)
		{
			 //个位
			 int ge=i%10;
			 //十位
			 int shi=i%100/10;
			 //百位
			 int bai=i/100;
			 if(aa.f(ge,3)+aa.f(shi,3)+aa.f(bai,3)==i)
			 {
				 System.out.println("水仙花数："+i);
			 }
			 i++;
		}
	}
}
