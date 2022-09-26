# include <stdio.h>
# include <string.h>
# include <windows.h>
# define N 10
typedef struct ss
{
    char num[10];
    int s;
}STU;

void fun(STU a[],STU *s)
{
    int i;
    strcpy(s->num,a[0].num);
    s->s=a[0].s;
    for(i=0;i<N;i++)
    {
        if(s->s>a[i].s)
        {
            strcpy(s->num,a[i].num);
            s->s=a[i].s;
         }
    }
}

main()
{
    STU a[N] = {{"A01",81},{"A02",89},{"A03",66},
                {"A04",87},{"A05",77},{"A06",90},
                {"A07",79},{"A08",61},{"A09",80},
                {"A10",71}
                },m;
    int i;
    printf("******************\n");
    for(i=0;i<N;i++)
        printf("=%s =%d\n",a[i].num,a[i].s);
    fun(a,&m);
    printf("********************\n");
    printf(":%s,%d\n",m.num,m.s);
    system("pause");
}