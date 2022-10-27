package unit3;
public class showArray 
{
  public static void main(String[] args)
  {
	  //调用方法时传递一个数组
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
