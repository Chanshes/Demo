#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>

#define MAXSIZE 100;

typedef int KeyType;
typedef struct
{
    KeyType key;
}SearchL;

// 顺序查找算法函数，表中元素下标为1到n
int SeqSearch(SearchL r[],int n,KeyType k)
{
    int i=n;
    r[0].key=k;
    while(r[i].key!=k)
        i--;
    return(i); /*返回查找元素下标，当为0时表示查找失败*/
}

int crearat()
{
    return 0;
}

int main()
{
    int a[100];
    int i;
    srand((unsigned int)time(NULL));
    for(i=0; i<100; i++)
    {
        a[i] = rand() % MAXSIZE;
    }
    for(i=0; i<100; i++)
    {
        printf(a[i]);
        printf("\n");
    }
    return 0;
}