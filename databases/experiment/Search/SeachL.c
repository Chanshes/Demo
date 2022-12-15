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

typedef struct
{
    KeyType key;
    int low,high;
}IdxType;

// 顺序查找算法函数，表中元素下标为1到n
int SeqSearch(SearchL r[],int n,KeyType k)
{
    int i=n;
    r[0].key=k;
    while(r[i].key!=k)
        i--;
    return(i); /*返回查找元素下标，当为0时表示查找失败*/
}


int BinSearch(SearchL r[], int n, KeyType k)
{
    int low,high,mid;
    low=1;
    high=n;
    while(low<=high)
    {
        mid=(low+high)/2;
        if(k==r[mid].key)
            return(mid);
        else if(k<r[mid].key)
            high=mid-1;
        else
            low=mid+1;
    }
    return (0);
}

int BlkSearch(SearchL r[], IdxType idx[], int m, KeyType k)
{
    int low,high,mid,i,j,find=0;
    i=0;
    while(idx[i].key<k)
        i++;
    low=idx[i].low;
    high=idx[i].high;
    while(low<=high&&!find)
    {
        mid=(low+high)/2;
        if(k<idx[mid].key)
            high=mid-1;
        else if(k>idx[mid].key)
            low=mid+1;
        else
        {
            high=mid-1;
            find=1;
        }
    }
    if(low<m)
    {
        i=idx[low].low;
        j=idx[low].high;
    }
    while(i<j && r[i].key!=k)
        i++;
    if(i>=j)
        return(-1);
    else
        return(i);
}

void CreateIdx(SearchL r[],IdxType idx[], int m, int n)
{
    int i,j,k=0;
    KeyType max;
    for(i=0;i<m;i+=n)
    {
        max=r[i].key;
        for(j=i+1;i<i+n&&j<m;j++)
        if(r[j].key>max)
            max=r[j].key;
        idx[k].key=max;
        idx[k].low=i;
        if(i+n-1<=m-1)
            idx[k].high=i+n-1;
        else
            idx[k].high=m-1;
        k++;
    }
        
}