package unit4;
//3
//ʹ��whileѭ������ҳ�100-999֮������Щˮ�ɻ�����ˮ�ɻ�����153=1^3+5^3+3^3

public class AddApp 
{
	public int f(int x,int y)//��x��y�η�
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
			 //��λ
			 int ge=i%10;
			 //ʮλ
			 int shi=i%100/10;
			 //��λ
			 int bai=i/100;
			 if(aa.f(ge,3)+aa.f(shi,3)+aa.f(bai,3)==i)
			 {
				 System.out.println("ˮ�ɻ�����"+i);
			 }
			 i++;
		}
	}
}
