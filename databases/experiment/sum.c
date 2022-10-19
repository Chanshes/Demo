# include <stdio.h>

typedef struct complex
{
    double re;
    double im;
}COMPLEX;
void ComplexInput(COMPLEX *complex){
   scanf("%lf%lfi",&complex->re,&complex->im); 
}
void ComplexOutput(const COMPLEX *complex){
    printf("%g%+gi",complex->re,complex->im);
}
// 复数加法
COMPLEX ComplexAdd(const COMPLEX *x, const COMPLEX *y)
{
   COMPLEX p;
    p.re = x->re + y->re;
    p.im = x->im + y->im;
    return p;
}
// 复数减法
COMPLEX ComplexSub(const COMPLEX *x, const COMPLEX *y)
{
   COMPLEX q;
    q.re = x->re - y->re;
    q.im = x->im - y->im;
    return q;    
}
// 复数乘法
COMPLEX ComplexMul(const COMPLEX *x, const COMPLEX *y)
{
   COMPLEX r; 
    r.re = (x->re * y->re)-(x->im * y->im);
    r.im = (x->re * y->im)+(x->im * y->re);
   return r; 
}
// 复数除法
COMPLEX ComplexDiv(const COMPLEX *x, const COMPLEX *y)
{
    COMPLEX s;
    if(y->re!=0&&y->im!=0)
    { double w=(y->re * y->re + y->im * y->im);
    s.re = ((x->re * y->re)+(x->im * y->im))/w;
    s.im = -((x->re * y->im)-(x->im * y->re))/w;}
    if(y->re==0&&y->im==0)
    {printf("Divided by zero!\n");
    return *y;}
   return s; 
}

int main()
{
    COMPLEX a, b, p, q, r, s;
    ComplexInput(&a);
    ComplexInput(&b);
    p = ComplexAdd(&a, &b);
    ComplexOutput(&p);
    putchar('\n');
    q = ComplexSub(&a, &b);
    ComplexOutput(&q);
    putchar('\n');
    r = ComplexMul(&a, &b);
    ComplexOutput(&r);
    putchar('\n');
    s = ComplexDiv(&a,&b);
    ComplexOutput(&s);
    putchar('\n');
    return 0;
}
