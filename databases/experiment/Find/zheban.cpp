#include <conio.h>
#include <stdio.h>
#define MAX 30 // ����������ұ����󳤶�
typedef struct
{
    char elem[MAX]; // ������ұ�
    int length;     // lengthָʾ��ǰ������ұ�ĳ���
} SSTable;
void initial(SSTable &);  // ��ʼ��������ұ�
int search(SSTable, int); // ��������ұ��в���Ԫ��
void print(SSTable);      // ��ʾ������ұ�������Ԫ��
int main()
{
    SSTable ST; // STΪһ������ұ�
    int ch, loc, flag = 1;
    char j;
    initial(ST); // ��ʼ��������ұ�
    while (flag)
    {
        printf("��ѡ��\n");
        printf("1.��ʾ����Ԫ��\n");
        printf("2.����һ��Ԫ��\n");
        printf("3.�˳�\n");
        scanf(" %c", &j);
        switch (j)
        {
        case '1':
            print(ST);
            break; // ��ʾ����Ԫ��
        case '2':
        {
            printf("������Ҫ���ҵ�Ԫ�أ�");
            scanf("%d", &ch);     // ����Ҫ���ҵ�Ԫ�صĹؼ���
            loc = search(ST, ch); // ����
            if (loc != 0)
                printf("��Ԫ������λ���ǣ�%d\n", loc); // ��ʾ��Ԫ��λ��
            else
                printf("%d ������!\n", ch); // ��ǰԪ�ز�����
            break;
        }
        default:
            flag = 0;
        }
    }
    printf("�������н���!��������˳�!\n");
    return 0;
}
void initial(SSTable &v)
{ // ��ʼ��������ұ�
    int i;
    printf("�����뾲̬���Ԫ�ظ�����"); // ����������ұ��ʼ��ʱ�ĳ���
    scanf("%d", &v.length);
    printf("���С��������%d��Ԫ�أ�����������\n", v.length);
    getchar();
    for (i = 1; i <= v.length; i++)
        scanf("%d", &v.elem[i]); // ���µ�������������ұ�ĸ�Ԫ��
}
int search(SSTable v, int ch)
{ // ��������ұ��в���ch��λ�ã��ɹ�������λ�ã�ʧ�ܷ���0
    int low, high, mid;
    low = 1;
    high = v.length; // �������ֵ
    while (low <= high)
    {
        mid = (low + high) / 2;
        if (v.elem[mid] == ch)
            return mid; // �ҵ�����Ԫ��
        else if (v.elem[mid] > ch)
            high = mid - 1; // ������ǰ��������в���
        else
            low = mid + 1; // �����ں��������в���
    }
    return 0; // �Ҳ���ʱ��iΪ0
}
void print(SSTable v) // ��ʾ��ǰ������ұ�����Ԫ��
{
    int i;
    for (i = 1; i <= v.length; i++)
        printf("%d ", v.elem[i]);
    printf("\n");
}