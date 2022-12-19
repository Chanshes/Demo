#include <conio.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 20 // 排序表的最大容量
typedef struct     // 定义排序表的结构
{
    int elemword[MAXSIZE]; // 数据元素关键字
    int count;             // 表中当前元素的个数
} SqList;
void InitialSqList(SqList &);         // 初始化排序表
void ShellSort(SqList &, int[], int); // 希尔排序
void ShellInsert(SqList &, int);      // 一趟希尔排序
void PrintSqList(SqList);       // 显示表中的所有元素
int main()
{
    SqList L; // 声明表L
    char j = 'y';
    int dlta[3] = {5, 3, 1}; // 希尔排序增量序列，本程序采用5，3，1序列
    int t = 3;               // 希尔排序增量序列中增量的个数
    printf("本程序将演示希尔排序的操作。\n增量序列为5，3，1。\n");
    while (j != 'n' && j != 'N')
    {
        InitialSqList(L);      // 待排序列初始化
        ShellSort(L, dlta, t); // 希尔排序
        PrintSqList(L);        // 显示希尔排序结果
        printf("继续进行下一次排序吗?(Y/N)");
        scanf(" %c", &j);
    }
    printf("程序运行结束!\n按任意键关闭窗口!\n");
    getchar();
    getchar();
    return 0;
}
void InitialSqList(SqList &L)
{ // 表初始化
    int i;
    printf("请输入待排序的记录的个数:");
    scanf("%d", &L.count);
    printf("请输入待排序的记录的关键字(整型数):\n");
    for (i = 1; i <= L.count; i++)
        scanf("%d", &L.elemword[i]);
}
void ShellSort(SqList &L, int dlta[], int t)
{ // 按增量序列dlta[0..t-1]对顺序表L作希尔排序
    for (int k = 0; k < t; ++k)
        ShellInsert(L, dlta[k]); // 一趟增量为dlta[k]的插入排序
}
void ShellInsert(SqList &L, int dk)
{ // 对顺序表L做一趟希尔插入排序。本算法是和一趟直接插入排序相比，作了以下修改
    // 1. 前后记录的增量是dk，而不是1
    // 2. 0号单元只是暂存单元，不是哨兵。当j<=0时，插入位置已找到
    int i, j;
    for (i = dk + 1; i <= L.count; i++)
        if (L.elemword[i] < L.elemword[i - dk]) //"<",需将L.elemword[i]插入有序子表
        {
            L.elemword[0] = L.elemword[i]; // 暂存在0号单元
            for (j = i - dk; j > 0 && L.elemword[0] < L.elemword[j]; j -= dk)
                L.elemword[j + dk] = L.elemword[j]; // 记录后移，查找插入位置
            L.elemword[j + dk] = L.elemword[0];     // 插入到正确的位置
        }
}
void PrintSqList(SqList L)
{ // 显示表所有元素
    int i;
    printf("已排好序的序列如下：\n");
    for (i = 1; i <= L.count; i++)
        printf("%4d", L.elemword[i]);
    printf("\n");
}
