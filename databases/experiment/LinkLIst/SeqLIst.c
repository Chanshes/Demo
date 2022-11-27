#include <stdio.h>

#define MAXLEN 100
// 顺序线性表的建立、插入及删除
typedef int DataType;
typedef struct
{
    DataType data[MAXLEN];
    int Length;
}SeqList;

void InitList(SeqList *L)
{
    L->Length=0;
}
//建立
void CreateList(SeqList *L,int n)
{
    int i;
    printf("请输入%d个整数：",n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&L->data[i]);
    }
    L->Length=i;
}
//查找
int GetElem(SeqList *L,int i,DataType *x)
{
    if(i<1 || i>L->Length)
        return 0;
    else
    {
        *x = L->data[i-1];
        return 1;
    }
}
//按值查找
int Locate(SeqList *L, DataType x)
{
    int i=0;
    while(i<L->Length && L->data[i]!=x)
        i++;
    if(i>=L->Length)
        return 0;
    else
        return i+1;
}
//插入
int InsElem(SeqList *L,int i,DataType x)
{
    int j;
    if(L->Length>=MAXLEN)
    {
        printf("顺序表已满！");
        return -1;
    }
    if(i<1 || i>L->Length+1)
    {
        printf("插入位置出错！");
        return 0;
    }
    if(i ==L->Length+1)
    {
        L->data[i-1]=x;
        L->Length++;
        return 1;
    }
    for(j=L->Length-1;j>=i-1;j--)
        L->data[j+1]=L->data[j];
    L->data[i-1]=x;
    L->Length++;
    return 1;
}
//删除
int DelElem(SeqList *L,int i,DataType *x)
{
    int j;
    if(L->Length==0)
    {
        printf("顺序表为空！");
        return 0;
    }
    if(i<1||i>L->Length)
    {
        printf("不存在第%d个元素！",i);
        return 0;
    }
    *x=L->data[i-1];
    for(j=i;j<L->Length;j++)
        L->data[j-1]=L->data[j];
    L->Length--;
    return 1;
}
//输出表中元素
void DispList(SeqList *L)
{
    int i;
    for(i=0;i<L->Length;i++)
    {
        printf("%5d ",L->data[i]);
    }
}
//菜单
void Menu()
{
    printf("\n              顺序表的各种操作");
    printf("\n===================================================");
    printf("\n|            1————建立顺序表                  |");
    printf("\n|            2————插入元素                    |");
    printf("\n|            3————删除元素                    |");
    printf("\n|            4————按位置查找元素              |");
    printf("\n|            5————按元素值查找其在表中位置    |");
    printf("\n|            6————求顺序表的长度              |");
    printf("\n|            0————退出                        |");
    printf("\n===================================================");
    printf("\n请输入菜单号（0~6）:");
}
//主函数
int main()
{
    SeqList L;
    DataType x;
    int n,i,ch,loc;
    char ch1;
    ch1='y';
    while(ch1=='y'||ch1=='Y')
    {
        Menu();
        scanf("%d",&ch);
        getchar();
        switch (ch)
        {
        case 1:
            InitList(&L);
            printf("请输入建立线性表的个数：");
            scanf("%d",&n);
            CreateList(&L,n);
            printf("建立的线性表为：");
            DispList(&L);
            break;
        case 2:
            printf("请输入要插入的位置：");
            scanf("%d",&i);
            printf("请输入要插入的元素值：");
            scanf("%d",&x);
            if(InsElem(&L,i,x))
            {
                printf("已成功在第%i的位置上插入%d，插入后的线性表为：\n",i,x);
                DispList(&L);
            }
            else
                printf("输入插入的参数错位! ");
            break;
        case 3:
            printf("请输入要删除元素的位置：");
            scanf("%d",&i);
            if(DelElem(&L,i,&x))
            {
                printf("已成功在第%d的位置上删除%d，删除后的线性表为：\n",i,x);
                DispList(&L);
            }
            else
                printf("输入删除的参数错误！");
            break;
        case 4:
            printf("请输入要查看表中元素位置（从1开始）：");
            scanf("%d",&i);
            if(GetElem(&L,i,&x))
                printf("当前线性表的第%d个元素的值为：%d\n",i,x);
            else
                printf("输入的位置错误！");
            break;
        case 5:
            printf("输入要查找的元素值为：");
            scanf("%d",&x);
            loc=Locate(&L,x);
            if(loc)
                printf("查找元素值为%d的位置为： %d\n",x,loc);
            else
                printf("该表中无此元素！\n");
            break;
        case 6:
            printf("当前线性表的长度为：%d\n",L.Length);
            break;
        case 0:
            ch1='n';
            printf("成功退出！");
            break;
        default:
            printf("输入有误，请输入0~6进行选择！\n");
        }
    }
    return 0;
}
