#include <stdio.h>
#include <malloc.h>

//��ʽ���Ա�Ľ��������뼰ɾ����
typedef int DataType;
typedef struct Linknode
{
    DataType data;
    struct Linknode *next;
}LinkList;

//��ʼ��������
LinkList *InitList()
{
    LinkList *head;
    head=(LinkList*)malloc(sizeof(LinkList));/*��̬����һ�����ռ�*/
    head->next=NULL;
    return head;/*ͷ�ļ�Lָ����Ϊ�գ���ʾ������*/
}
//ͷ�巨����������
void CreateListH(LinkList *head,int n)
{
    LinkList *s;
    int i;
    printf("������%d��������",n);
    for(i=0;i<n;i++)
    {
        s=(LinkList *)malloc(sizeof(LinkList));/*�����½��*/
        scanf("%d",&s->data);/*�����½���������*/
        s->next=head->next;/*���½���ָ������ͷ����ָ����*/
        head->next=s;/*���½�����ͷ���֮��*/
    }
    printf("��������������ɹ���");
}
//β�巨����
void CreateListL(LinkList *head,int n)
{
    LinkList *s, *last;
    int i;
    last=head;/*lastʼ��ָ��β��㣬��ʼʱָ��ͷ���*/
    printf("������%d��������",n);
    for(i=0;i<n;i++)
    {
        s=(LinkList *)malloc(sizeof(LinkList));/*�����½��*/
        scanf("%d",&s->data);/*�����½���������*/
        s->next=NULL;/*���½���ָ����Ϊ��*/
        last->next=s;/*���½������β*/
        last=s;/*��lastָ��ָ���β���*/
    }
    printf("������������ɹ���");
}
//�������
int LengthList(LinkList *head)
{
    LinkList *p=head->next;
    int j=0;
    while(p!=NULL)/*��p��ָ������βʱ*/
    {
        p=p->next;
        j++;
    }
    return j;
}
//���Ҳ���
//��ֵ����
void Locate(LinkList *head,DataType x)
{
    int j=1;/*������*/
    LinkList *p;
    p=head->next;
    while(p!=NULL && p->data!=x)/*���Ҽ���λ*/
    {
        p=p->next;
        j++;
    }
    if(p!=NULL)
        printf("�ڱ�ĵ�%dλ�ҵ�ֵΪ%d�Ľ�㣡",j,x);
    else
        printf("δ�ҵ�ֵΪ%d�Ľ�㣡",x);
}
//����Ų���
int SearchList(LinkList *head,int i)
{
    LinkList *p;
    int j=0;
    p=head;
    if(i>LengthList(head) ||  i<1)
        return 0;
    while(p->next!=NULL && j<i)
    {
        p=p->next;
        j++;
    }
    if(j==i)
        return 1;
    else
        return 0;
}

//�������
int InsList(LinkList *head,int i,DataType x)
{
    int j=0;
    LinkList *p,*s;
    p=head;
    while(p->next!=NULL && j<i-1) /*��λ�����*/
    {
        p=p->next;
        j++;
    }
    if(p!=NULL)/*p��Ϊ�����½��嵽p��*/
    {
        s=(LinkList *)malloc(sizeof(LinkList));/*�����½��s*/
        s->data=x;/*������x���뵽�½���������*/
        s->next=p->next;/*���½��s��ָ������p�������Ԫ������*/
        p->next=s;/*��p���½��s����*/
        return 1;
    }
    else
        return 0;
}
//ɾ������
int DelList(LinkList *head,int i)
{
    int j=0;
    DataType x;
    LinkList *p=head,*s;
    while(p->next!=NULL && j<i-1)/*��λ�����*/
    {
        p=p->next;
        j++;
    }
    if(p->next!=NULL && j==i-1)
    {
        s=p->next;/*qΪҪɾ�����*/
        x=s->data;/*��Ҫɾ�������ݷ���ָ�����x��*/
        p->next=s->next;/*��p����ָ������q�������Ԫ������*/
        free(s);
        return 1;
    }
    else
        return 0;
}
//����������
void DispList(LinkList *head)
{
    LinkList *p;
    p=head->next;
    while(p!=NULL)
    {
        printf("%5d",p->data);
        p=p->next;
    }
}
//�˵�
void Menu()
{
    printf("\n              ��ʽ���Ա�ĸ��ֲ���");
    printf("\n===================================================");
    printf("\n|            1����������������                    |");
    printf("\n|            2������������Ԫ��                    |");
    printf("\n|            3��������ɾ��Ԫ��                    |");
    printf("\n|            4����������λ�ò���Ԫ��              |");
    printf("\n|            5����������Ԫ��ֵ�������ڱ���λ��    |");
    printf("\n|            6��������������ĳ���                |");
    printf("\n|            0���������˳�                        |");
    printf("\n===================================================");
    printf("\n������˵��ţ�0~6��:");
}
//������
int main()
{
    LinkList *L;
    DataType x;
    int n,i,loc,ch;
    while (ch)
    {
        Menu();
        scanf("%d",&ch);
        getchar();
        switch (ch)
        {
        case 1:
            L=InitList();
            printf("�����뽨�����Ա�ĸ�����");
            scanf("%d",&n);
            CreateListL(&L,n);
            printf("���������Ա�Ϊ��");
            DispList(&L);
            break;
        case 2:
            printf("������Ҫ�����λ�ã�");
            scanf("%d",&i);
            printf("������Ҫ�����Ԫ��ֵ��");
            scanf("%d",&x);
            if(InsList(&L,i,x))
            {
                printf("�ѳɹ��ڵ�%i��λ���ϲ���%d�������ĵ�����Ϊ��\n",i,x);
                DispList(&L);
            }
            else
                printf("����Ԫ��ʧ�ܣ�");
            break;
        case 3:
            printf("������Ҫɾ��Ԫ�ص�λ�ã�");
            scanf("%d",&i);
            if(DelList(&L,i))
            {
                printf("�ѳɹ��ڵ�%d��λ����ɾ��%d��ɾ��������Ա�Ϊ��\n",i,x);
                DispList(&L);
            }
            else
                printf("ɾ�����λ�ô���ɾ��ʧ�ܣ�");
            break;
        case 4:
            printf("������Ҫ�鿴����Ԫ��λ�ã���1��ʼ����");
            scanf("%d",&i);
            if(SearchList(&L,i))
                printf("��ǰ���Ա�ĵ�%d��Ԫ�ص�ֵΪ��%d\n",i,x);
            else
                printf("λ�ô���������û�и�λ�ã�");
            break;
        case 5:
            printf("����Ҫ���ҵ�Ԫ��ֵΪ��");
            scanf("%d",&x);
            Locate(&L,x);
            break;
        case 6:
            printf("��ǰ���Ա�ĳ���Ϊ��%d\n",LengthList(&L));
            break;
        case 0:
            ch=0;
            printf("�ɹ��˳���");
            break;
        default:
            printf("��������������0~6����ѡ��\n");
        }
    }
}