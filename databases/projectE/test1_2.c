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
    printf("");
    scanf("%f%f%f",&a,&b,&c);
    printf("");
    printf("a=%4.1f,b=%4.1f,c=%4.1f\n\n",a,b,c);
    fun(&a,&b,&c);
    printf("");
    printf("a=%4.1f,b=%4.1f,c=%4.1f\n\n",a,b,c);
    system("pause");
}