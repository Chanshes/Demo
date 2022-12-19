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
void InitialSqList(SqList &);         // ��ʼ�������
void ShellSort(SqList &, int[], int); // ϣ������
void ShellInsert(SqList &, int);      // һ��ϣ������
void PrintSqList(SqList);       // ��ʾ���е�����Ԫ��
int main()
{
    SqList L; // ������L
    char j = 'y';
    int dlta[3] = {5, 3, 1}; // ϣ�������������У����������5��3��1����
    int t = 3;               // ϣ���������������������ĸ���
    printf("��������ʾϣ������Ĳ�����\n��������Ϊ5��3��1��\n");
    while (j != 'n' && j != 'N')
    {
        InitialSqList(L);      // �������г�ʼ��
        ShellSort(L, dlta, t); // ϣ������
        PrintSqList(L);        // ��ʾϣ��������
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
void ShellSort(SqList &L, int dlta[], int t)
{ // ����������dlta[0..t-1]��˳���L��ϣ������
    for (int k = 0; k < t; ++k)
        ShellInsert(L, dlta[k]); // һ������Ϊdlta[k]�Ĳ�������
}
void ShellInsert(SqList &L, int dk)
{ // ��˳���L��һ��ϣ���������򡣱��㷨�Ǻ�һ��ֱ�Ӳ���������ȣ����������޸�
    // 1. ǰ���¼��������dk��������1
    // 2. 0�ŵ�Ԫֻ���ݴ浥Ԫ�������ڱ�����j<=0ʱ������λ�����ҵ�
    int i, j;
    for (i = dk + 1; i <= L.count; i++)
        if (L.elemword[i] < L.elemword[i - dk]) //"<",�轫L.elemword[i]���������ӱ�
        {
            L.elemword[0] = L.elemword[i]; // �ݴ���0�ŵ�Ԫ
            for (j = i - dk; j > 0 && L.elemword[0] < L.elemword[j]; j -= dk)
                L.elemword[j + dk] = L.elemword[j]; // ��¼���ƣ����Ҳ���λ��
            L.elemword[j + dk] = L.elemword[0];     // ���뵽��ȷ��λ��
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
