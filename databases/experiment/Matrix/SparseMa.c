#include <stdio.h>

#define M 3          //稀疏矩阵的行数
#define N 5          //稀疏矩阵的列数
#define MAX_SIZE 128 //稀疏矩阵中非0元素最多的个数
typedef int ElemType;
typedef struct
{
    int row;      // row
    int col;      // column
    ElemType val; // value
} Triple;
typedef struct
{
    int rn;
    int cn;
    int tn;
    Triple data[MAX_SIZE];
} TMatrix;

//从一个二维稀疏矩阵创建其三元组表示,A即为被转化的二维稀疏矩阵
void CreatMat(TMatrix *t, ElemType A[M][N])
{
    t->rn = M;
    t->cn = N;
    t->tn = 0; //行和列直接赋值,非0元素个数初始化为0
    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
            if (A[i][j] != 0)
            { //遍历二维矩阵寻找非0元素,寻找到nums++
                t->data[t->tn].row = i;
                t->data[t->tn].col = j;
                t->data[t->tn].val = A[i][j];
                t->tn++; //赋值
            }
}
//三元组元素的赋值
int Value(TMatrix *t, ElemType x, int i, int j)
{ // i为行编号,j为列编号,x为元素值
    if (i >= t->rn || j >= t->cn)
        return 0; //赋值的行和列编号越界,赋值失败返回false
    int k = 0;
    while (k < t->tn && i > t->data[k].row)
        k++; //由于是行序递增排列,率先查找出大于等于i的行编号
    while (k < t->tn && i == t->data[k].row && j > t->data[k].col)
        k++; //如果查找到的行编号等于i,紧接着查找大于等于j的列编号
    if (t->data[k].row == i && t->data[k].col == j)
        t->data[k].val = x; //查找出的行编号和列编号与i和j相等,说明是对已有的三元组修改
    else
    { //否则对三元组表插入一个新的三元组,将编号大于等于k的元素全部后移一位来插入新的元素
        for (int k1 = t->tn - 1; k1 >= k; k1--)
        { //就是顺序表的元素插入
            t->data[k1 + 1].row = t->data[k1].row;
            t->data[k1 + 1].col = t->data[k1].col;
            t->data[k1 + 1].val = t->data[k1].val;
        }
        t->data[k].row = i;
        t->data[k].col = j;
        t->data[k].val = x;
        t->tn++; //赋值,三元组个数++
    }
    return 1; //赋值成功时返回true
}
//将指定位置的元素值赋给变量
int Assign(TMatrix t, ElemType *x, int i, int j)
{ // i为行编号,j为列编号,x用来存储查找值
    if (i >= t.rn || j >= t.cn)
        return 0; //赋值的行和列编号越界,赋值失败返回false
    int k = 0;
    while (k < t.tn && i > t.data[k].row)
        k++; //如果查找到的行编号等于i,紧接着查找大于等于j的列编号
    while (k < t.tn && i == t.data[k].row && j > t.data[k].col)
        k++; //如果查找到的行编号等于i,紧接着查找大于等于j的列编号
    if (t.data[k].row == i && t.data[k].col == j)
        x = t.data[k].val; //查找成功进行赋值
    else
        x = 0;
    return 1; //查找不成功直接返回0
}

//输出三元组
void DispMat(TMatrix t)
{
    if (t.tn <= 0)
        return;                                 //没有非零元素时返回
    printf("\t%d\t%d\t%d\n", t.rn, t.cn, t.tn); //打印行,列,非0元素个数三个属性
    for (int i = 0; i < t.tn; i++)
        printf("%d\t%d\t%d\n", t.data[i].row, t.data[i].col, t.data[i].val); //打印三元组的三个属性
}

//矩阵转置,转置后矩阵的行等于原本矩阵的列,转置后矩阵的列等于原本矩阵的行,非0元素的个数是一样的
void TranTat(TMatrix t, TMatrix *tb)
{
    tb->rn = t.cn;
    tb->cn = t.rn;
    tb->tn = t.tn;
    int index = 0; // index为转置后新的三元组表的下标
    if (t.tn != 0)
    { //当存在非零元素时进行转置,列i从0递增到最大宽度,在三元组表中寻找列属性与i相等的进行添加
        for (int i = 0; i < t.cn; i++)
            for (int j = 0; j < t.tn; j++)
                if (t.data[j].col == i)
                { //本质就是计数排序
                    tb->data[index].row = t.data[j].col;
                    tb->data[index].col = t.data[j].row;
                    tb->data[index].val = t.data[j].val; //交换赋值
                    index++;
                }
    }
}
