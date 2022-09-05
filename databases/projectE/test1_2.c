# include <stdio.h>
# include <windows.h>
void fun(float *p, float *q, float *s)
{
    float k;
    if(*p<*q)
    {   
        k=*p;
        *p=*q;
        *q=k;
    }
    if(*p<*s)
    {
        k=*s;
        *s=*p;
        *p=k;
    }
    if(*q<*s)
    {
        k=*q;
        *q=*s;
        *s=k;
    }
}
main()
{
    float a,b,c;
    printf("请输入三个小数a、b、和c:");
    scanf("%f%f%f",&a,&b,&c);
    printf("这三个数分别为：");
    printf("a=%4.1f,b=%4.1f,c=%4.1f\n\n",a,b,c);
    fun(&a,&b,&c);
    printf("按从大到小排序后这三个数为：");
    printf("a=%4.1f,b=%4.1f,c=%4.1f\n\n",a,b,c);
    system("pause");
}