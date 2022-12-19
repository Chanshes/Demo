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
void InitialSqList(SqList &); // 初始化排序表
void InsertSort(SqList &);    // 直接插入排序
void PrintSqList(SqList);     // 显示表中的所有元素
int main()
{
    SqList L; // 声明表L
    char j = 'y';
    printf("本程序将演示直接插入排序的操作。\n");
    while (j != 'n' && j != 'N')
    {
        InitialSqList(L);
        InsertSort(L);
        PrintSqList(L);
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
void InsertSort(SqList &L)
{
    int i, j;
    for (i = 2; i <= L.count; i++)
        if (L.elemword[i] < L.elemword[i - 1]) //"<",需将L.elemword[i]插入有序子表
        {
            L.elemword[0] = L.elemword[i]; // 复制为哨兵
            for (j = i - 1; L.elemword[0] < L.elemword[j]; --j)
                L.elemword[j + 1] = L.elemword[j]; // 记录后移
            L.elemword[j + 1] = L.elemword[0];     // 插入到正确的位置
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