#include <stdio.h>
#include <malloc.h>

typedef char DataType;
typedef struct tnode
{
    DataType data;
    struct tnode *Lchild,*Rchild;
}BTree;

//先序遍历二叉树
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
//中序遍历二叉树
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
//后续遍历二叉树
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
//建立二叉树,以先序序列输入结点的值，创建二叉链表
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
        printf("请输入%c结点的左孩子结点: ",t->data);
        t->Lchild=CreateBTree();
        printf("请输入%c结点的右孩子结点: ",t->data);
        t->Rchild=CreateBTree();
    }
    return t;
}
