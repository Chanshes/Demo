package unit3;
public class showArray 
{
  public static void main(String[] args)
  {
	  //���÷���ʱ����һ������
	  int [] arrayDate= {1,2,3};
	  arrayManage(arrayDate);
  }
  public static void arrayManage(int [] data)
  {
	  for(int i=0;i<data.length;i++)
	  {
		  System.out.println(data[i]);
	  }
  }
}
