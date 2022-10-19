# include <stdio.h>
#include <windows.h>

typedef struct complex{
    double r;
    double i;
}complex;

void complexInput(complex *complex){
    scanf("%lf%lfi",&complex->r,&complex->i);
}

void complexOutput(const complex *complex){
    printf("%g%+gi",complex->r,complex->i);
}

complex ComplexAdd(const complex *x, const complex *y){
   complex p;
    p.r = x->r + y->r;
    p.i = x->i + y->i;
    return p;
}

int main(){
    complex a,b,p;
    complexInput(&a);
    complexInput(&b);
    p = ComplexAdd(&a, &b);
    complexOutput(&p);
    system("pause");
    return 0;
}