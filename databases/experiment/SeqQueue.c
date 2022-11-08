# include <stdio.h>
# include <malloc.h>

#define MAXLEN 8

typedef int DataType;

typedef struct 
{
    DataType stack[MAXLEN];
    int front, rear;
}SQueue;

//��ʼ������
void initSq (SQueue *q)
{
    q->front=0, q->rear=0;
}

//�жϿն���
int isNullSq(SQueue *q)
{
    //�ն��з���1
    if(q->front==q->rear)
        return 1;
    else
        return 0;
}
//�ж϶���
int isFullSq(SQueue *q)
{
    if((q->rear+1)%MAXLEN==q->front)
        return 1;
    else
        return 0;
}
//��Ӳ���
void inSque(SQueue *q, DataType d)
{
    q->stack[q->front]=d;//���� ��front++
    q->front++;
}
//����
DataType outSque(SQueue *q)
{
    if(isNullSq(q))
    {
        printf("�ն��в��ܳ���");
        return 0;
    }
    else
    {   
        q->rear++;
        return q->rear;
    }
}

//��������
void prinSq(const SQueue *q)
{
    int i;
    for(i=q->rear;i<q->front;i++)
    {
        printf("%d\t",q->stack[i]);
    }
}
//�˵�
void Menu()
{
    printf("\n=========================================================\n");
    printf("|\t\t\t���в���\t\t\t|\n");
    printf("=========================================================\n");
    printf("|\t\t\t\t\t\t\t|\n");
    printf("|\t\t\t1.��ʼ������\t\t\t|\n");
    printf("|\t\t\t2.���\t\t\t\t|\n");
    printf("|\t\t\t3.������\t\t\t|\n");
    printf("|\t\t\t4.��������\t\t\t|\n");
    printf("|\t\t\t0.�˳�\t\t\t\t|\n");
    printf("|_______________________________________________________|\n");
}

int main()
{
    SQueue sq;
    int Scan=1;
    int i,n,x;

    while(Scan!=0)
    {
        Menu();
        printf("�����������");
        scanf("%d",&Scan);
        switch (Scan)
        {
        case 0:
            Scan=0;
            printf("�˳�����!");
            break;
        case 1:
            initSq(&sq);
            printf("��ʼ���ɹ�!");
            break;
        case 2:
            if(isFullSq(&sq))
                printf("�����������!");
            else
            {
                printf("������Ҫ��ӵ�Ԫ�ظ���: ");
                scanf("%d",&n);
                printf("������:");
                for(i=0;i<n;i++)
                {
                    scanf("%d",&x);
                    inSque(&sq,x);
                }
                printf("�����ɣ�");
            }
            break;
        case 3:
            if(isNullSq(&sq))
            {
                printf("�ն��в��ܳ���");
            }
            else
            {
                printf("������Ҫ���Ӷӵ�Ԫ�ظ���:");
                scanf("%d",&n);
                for(i=0;i<n;i++)
                {
                    x=outSque(&sq);
                    printf("%d\t",x);
                }
                printf("������ɣ�");
            }
            break;
        case 4:
            printf("��������:");
            for(i=sq.rear;i<sq.front;i++)
            {
                printf("%d\t",sq.stack[i]);
            }
            break;

        default:
            printf("�����������������룡\n");
            break;
        }
    }
    return 0;
}
