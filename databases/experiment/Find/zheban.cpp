#include <conio.h>
#include <stdio.h>
#define MAX 30 // 定义有序查找表的最大长度
typedef struct
{
    char elem[MAX]; // 有序查找表
    int length;     // length指示当前有序查找表的长度
} SSTable;
void initial(SSTable &);  // 初始化有序查找表
int search(SSTable, int); // 在有序查找表中查找元素
void print(SSTable);      // 显示有序查找表中所有元素
int main()
{
    SSTable ST; // ST为一有序查找表
    int ch, loc, flag = 1;
    char j;
    initial(ST); // 初始化有序查找表
    while (flag)
    {
        printf("请选择：\n");
        printf("1.显示所有元素\n");
        printf("2.查找一个元素\n");
        printf("3.退出\n");
        scanf(" %c", &j);
        switch (j)
        {
        case '1':
            print(ST);
            break; // 显示所有元素
        case '2':
        {
            printf("请输入要查找的元素：");
            scanf("%d", &ch);     // 输入要查找的元素的关键字
            loc = search(ST, ch); // 查找
            if (loc != 0)
                printf("该元素所在位置是：%d\n", loc); // 显示该元素位置
            else
                printf("%d 不存在!\n", ch); // 当前元素不存在
            break;
        }
        default:
            flag = 0;
        }
    }
    printf("程序运行结束!按任意键退出!\n");
    return 0;
}
void initial(SSTable &v)
{ // 初始化有序查找表
    int i;
    printf("请输入静态表的元素个数："); // 输入有序查找表初始化时的长度
    scanf("%d", &v.length);
    printf("请从小到大输入%d个元素（整形数）：\n", v.length);
    getchar();
    for (i = 1; i <= v.length; i++)
        scanf("%d", &v.elem[i]); // 从下到大输入有序查找表的各元素
}
int search(SSTable v, int ch)
{ // 在有序查找表中查找ch的位置，成功返回其位置，失败返回0
    int low, high, mid;
    low = 1;
    high = v.length; // 置区间初值
    while (low <= high)
    {
        mid = (low + high) / 2;
        if (v.elem[mid] == ch)
            return mid; // 找到待查元素
        else if (v.elem[mid] > ch)
            high = mid - 1; // 继续在前半区间进行查找
        else
            low = mid + 1; // 继续在后半区间进行查找
    }
    return 0; // 找不到时，i为0
}
void print(SSTable v) // 显示当前有序查找表所有元素
{
    int i;
    for (i = 1; i <= v.length; i++)
        printf("%d ", v.elem[i]);
    printf("\n");
}