#include <stdio.h>
// 利用add函数求两个复数2+3i和4+5i的和。（要求用结构体来定义复数）
typedef struct
{
    double re,im;
}complex;

void inComplex(complex *p)
{
    scanf("%lf%lf",&p->re,&p->im);
}

complex addComplex(complex *p, complex *sp)
{
    complex Complex;
    Complex.re=p->re+sp->re;
    Complex.im=p->im+sp->im;
    return Complex;
}

int main()
{
    complex a,b,result;
    printf("Enter the first complex number:");
    inComplex(&a);
    printf("Enter the second complex number:");
    inComplex(&b);
    result=addComplex(&a,&b);
    printf("The sum of two complex numbers is %g+%gi",result.re,result.im);
}