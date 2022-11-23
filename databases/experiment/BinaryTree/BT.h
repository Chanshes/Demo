#include <stdio.h>
#include <malloc.h>

typedef char DataType;
typedef struct tnode
{
    DataType data;
    struct tnode *Lchild,*Rchild;
}BTree;

//�������������
void PreOrder(BTree *t)
{
    if(t==NULL)
        return;
    else
    {
        printf("%c",t->data);
        PreOrder(t->Lchild);
        PreOrder(t->Rchild);
    }
}
//�������������
void InOrder(BTree *t)
{
    if(t==NULL)
        return;
    else
    {
        InOrder(t->Lchild);
        printf("%c",t->data);
        InOrder(t->Rchild);
    }
}
//��������������
void PostOrder(BTree *t)
{
    if(t==NULL)
        return;
    else
    {
        PostOrder(t->Lchild);
        PostOrder(t->Rchild);
        printf("%c",t->data);
    }
}
//����������,�����������������ֵ��������������
BTree *CreateBTree()
{
    BTree *t;
    char ch;
    scanf("%c",&ch);
    getchar();
    if(ch=='0')
        t=NULL;
    else
    {
        t=(BTree *)malloc(sizeof(BTree));
        t->data=ch;
        printf("������%c�������ӽ��: ",t->data);
        t->Lchild=CreateBTree();
        printf("������%c�����Һ��ӽ��: ",t->data);
        t->Rchild=CreateBTree();
    }
    return t;
}
