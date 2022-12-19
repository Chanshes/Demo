#include <conio.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 20 // �������������
typedef struct     // ���������Ľṹ
{
    int elemword[MAXSIZE]; // ����Ԫ�عؼ���
    int count;             // ���е�ǰԪ�صĸ���
} SqList;
void InitialSqList(SqList &); // ��ʼ�������
void InsertSort(SqList &);    // ֱ�Ӳ�������
void PrintSqList(SqList);     // ��ʾ���е�����Ԫ��
int main()
{
    SqList L; // ������L
    char j = 'y';
    printf("��������ʾֱ�Ӳ�������Ĳ�����\n");
    while (j != 'n' && j != 'N')
    {
        InitialSqList(L);
        InsertSort(L);
        PrintSqList(L);
        printf("����������һ��������?(Y/N)");
        scanf(" %c", &j);
    }
    printf("�������н���!\n��������رմ���!\n");
    getchar();
    getchar();
    return 0;
}
void InitialSqList(SqList &L)
{ // ���ʼ��
    int i;
    printf("�����������ļ�¼�ĸ���:");
    scanf("%d", &L.count);
    printf("�����������ļ�¼�Ĺؼ���(������):\n");
    for (i = 1; i <= L.count; i++)
        scanf("%d", &L.elemword[i]);
}
void InsertSort(SqList &L)
{
    int i, j;
    for (i = 2; i <= L.count; i++)
        if (L.elemword[i] < L.elemword[i - 1]) //"<",�轫L.elemword[i]���������ӱ�
        {
            L.elemword[0] = L.elemword[i]; // ����Ϊ�ڱ�
            for (j = i - 1; L.elemword[0] < L.elemword[j]; --j)
                L.elemword[j + 1] = L.elemword[j]; // ��¼����
            L.elemword[j + 1] = L.elemword[0];     // ���뵽��ȷ��λ��
        }
}
void PrintSqList(SqList L)
{ // ��ʾ������Ԫ��
    int i;
    printf("���ź�����������£�\n");
    for (i = 1; i <= L.count; i++)
        printf("%4d", L.elemword[i]);
    printf("\n");
}