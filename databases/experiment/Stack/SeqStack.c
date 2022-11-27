#include <stdio.h>
#define MAXSIZE 8

typedef int DataType;
typedef struct{
    DataType data[MAXSIZE];
    int top;
}SeqStack;

// �ж�ջ�ա�ջ��
int EmptyStack(SeqStack *s)
{
    if(s->top==-1)
        return 1;
    else
        return 0;
}
int FullStack(SeqStack *s)
{
    if(s->top==MAXSIZE-1)
        return 1;
    else
        return 0;
}

//1.��ʼ��˳��ջ
void InitStack(SeqStack *s)
{
    s->top=-1;
    printf("��ʼ����ɣ�");
}
//2.����Ԫ��
void PushStack(SeqStack *s,DataType x)
{
    if(!FullStack(s))
    {
        s->top++;
        s->data[s->top] = x;
    }
    else
    {
        printf("ջ��������ջ��");
    }
}
//3.ɾ��ջ��Ԫ��
DataType DelStack(SeqStack *s)
{
    if(!EmptyStack(s))
    {
        DataType result=s->data[s->top];
        s->top--;
        return result;
    }
    else
        printf("ջ�ѿ��޷�ɾ����");
        return 0;

}
//4.ȡջ��Ԫ��
DataType PopStack(SeqStack *s)
{
    if(!EmptyStack(s))
    {   
        DataType result=s->data[s->top];
        s->top--;
        return result;
    }
    else
    {
        printf("ջ�ѿ��޷�ȡ��!");
        return 0;
    }
}
//5.����˳��ջ
void ErgodicStack(SeqStack *s)
{
    int i;
    for(i=0;i<=s->top;i++)
    {
        printf("%d\t",s->data[i]);
    }
}
//�˵�
void Menu()
{
    printf("\n==========================");
    printf("\n\t��1����ʼ��˳��ջ");
    printf("\n\t��2������Ԫ��");
    printf("\n\t��3��ɾ��ջ��Ԫ��");
    printf("\n\t��4��ȡջ��Ԫ��");
    printf("\n\t��5������˳��ջ");
    printf("\n\t��0���˳�");
    printf("\n==========================\n");
    printf("������˵��ţ�0-6��:");
}
//������
int main()
{
    SeqStack seqstack;
    int judge=1;
    while(judge)
    {
        int scan,n;
        Menu();
        scanf("%d",&scan);
        switch(scan)
        {
            case 1:
                InitStack(&seqstack);
                break;
            case 2:
                printf("������ջԪ�أ�");
                scanf("%d",&n);
                getchar();
                PushStack(&seqstack, n);
                break;
            case 3:
                printf("��ɾ��ջ��Ԫ�أ�%d",DelStack(&seqstack));
                break;
            case 4:
                printf("ȡ��ջ��Ԫ�أ�%d",PopStack(&seqstack));
                break;
            case 5:
                printf("����˳��ջ:\n");
                ErgodicStack(&seqstack);
                break;
            case 0:
                judge=0;
                printf("�˳�����");
                break;
            default:
                printf("����ȷ���룡");
                break;
        }
    }
    return 0;
}