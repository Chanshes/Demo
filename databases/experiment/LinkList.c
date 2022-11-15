#include <stdio.h>
#include<malloc.h>

//链式线性表的建立、插入及删除。
typedef int DataType;
typedef struct Linknode
{
    DataType data;
    struct linknode *next;
}LinkList;
//初始化链表函数
LinkList *InitList()
{
    LinkList *head;
    head=(LinkList *)malloc(sizeof(LinkList));/*动态分配一个结点空间*/
    head->next=NULL;
    return head;/*头文件L指针域为空，表示空链表*/
}
//头插法建立链表函数
void CreateListH(LinkList *head,int n)
{
    LinkList *s;
    int i;
    printf("请输入%d个整数：",n);
    for(i=0;i<n;i++)
    {
        s=(LinkList *)malloc(sizeof(LinkList));/*生成新结点*/
        scanf("%d",&s->data);/*读入新结点的数据域*/
        s->next=head->next;/*将新结点的指针域存放头结点的指针域*/
        head->next=s;/*将新结点插入头结点之后*/
    }
    printf("建立的链表操作成功！");
}
//尾插法建表
void CreateListL(LinkList *head,int n)
{
    LinkList *s, *last;
    int i;
    last=head;/*last始终指向尾结点，开始时指向头结点*/
    printf("请输入%d个整数：",n);
    for(i=0;i<n;i++)
    {
        s=(LinkList *)malloc(sizeof(LinkList));/*生成新结点*/
        scanf("%d",&s->data);/*读入新结点的数据域*/
        s->next=NULL;/*将新结点的指针域为空*/
        last->next=s;/*将新结点插入表尾*/
        last=s;/*将last指针指向表尾结点*/
    }
    printf("建立链表操作成功！");
}
//求表长操作
int LengthList(LinkList *head)
{
    LinkList *p=head->next;
    int j=0;
    while(p!=NULL)/*当p不指向链表尾时*/
    {
        p=p->next;
        j++;
    }
    return j;
}
//查找操作
//按值查找
void Locate(LinkList *head,DataType x)
{
    int j=1;/*计数器*/
    LinkList *p;
    p=head->next;
    while(p!=NULL && p->data!=x)/*查找及定位*/
    {
        p=p->next;
        j++;
    }
    if(p!=NULL)
        printf("在表的第%d位找到值为%d的结点！",j,x);
    else
        printf("未找到值为%d的结点！",x);
}
//按序号查找
int SearchList(LinkList *head,int i)
{
    LinkList *p;
    int j=0;
    p=head;
    if(i>LengthList(head))
        return 0;
    while(p->next!=NULL && j<i)
    {
        p=p->next;
        j++;
    }
    if(j==i)
        return 1;
}
//插入操作
int InsList(LinkList *head,int i,DataType x)
{
    int j=0;
    LinkList *p,*s;
    p=head;
    while(p->next!=NULL && j<i-1) /*定位插入点*/
    {
        p=p->next;
        j++;
    }
    if(p!=NULL)/*p不为空则将新结点插到p后*/
    {
        s=(LinkList *)malloc(sizeof(LinkList));/*生成新结点s*/
        s->data=x;/*将数据x放入到新结点的数据域*/
        s->next=p->next;/*将新结点s的指针域与p结点后面的元素相连*/
        p->next=s;/*将p与新结点s链接*/
        return 1;
    }
    else
        return 0;
}
//删除操作
int DelList(LinkList *head,int i)
{
    int j=0;
    DataType x;
    LinkList *p=head,*s;
    while(p->next!=NULL && j<i-1)/*定位插入点*/
    {
        p=p->next;
        j++;
    }
    if(p->next!=NULL && j==i-1)
    {
        s=p->next;/*q为要删除结点*/
        x=s->data;/*将要删除的数据放入指针变量x中*/
        p->next=s->next;/*将p结点的指针域与q结点后面的元素相连*/
        free(s);
        return 1;
    }
    else
        return 0;
}
//单链表的输出
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
//菜单
void Menu()
{
    printf("\n              单链表的各种操作");
    printf("\n===================================================");
    printf("\n|            1————建立单链表                  |");
    printf("\n|            2————插入元素                    |");
    printf("\n|            3————删除元素                    |");
    printf("\n|            4————按位置查找元素              |");
    printf("\n|            5————按元素值查找其在表中位置    |");
    printf("\n|            6————求单链表的长度              |");
    printf("\n|            0————退出                        |");
    printf("\n===================================================");
    printf("\n请输入菜单号（0~6）:");
}
//主函数
int main()
{
    LinkList L;
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
            InitList(&L);
            printf("请输入建立线性表的个数：");
            scanf("%d",&n);
            CreateList(&L,n);
            printf("建立的线性表为：");
            DispList(&L);
            break;
        case 2:
            printf("请输入要插入的位置：");
            scanf("%d",&i);
            printf("请输入要插入的元素值：");
            scanf("%d",&x);
            if(InsList(&L,i,x))
            {
                printf("已成功在第%i的位置上插入%d，插入后的单链表为：\n",i,x);
                DispList(&L);
            }
            else
                printf("插入元素失败！");
            break;
        case 3:
            printf("请输入要删除元素的位置：");
            scanf("%d",&i);
            if(DelElem(&L,i))
            {
                printf("已成功在第%d的位置上删除%d，删除后的线性表为：\n",i,x);
                DispList(&L);
            }
            else
                printf("删除结点位置错误，删除失败！");
            break;
        case 4:
            printf("请输入要查看表中元素位置（从1开始）：");
            scanf("%d",&i);
            if(SearchList(&L,i))
                printf("当前线性表的第%d个元素的值为：%d\n",i,x);
            else
                printf("位置错误，链表中没有该位置！");
            break;
        case 5:
            printf("输入要查找的元素值为：");
            scanf("%d",&x);
            Locate(&L,x);
            break;
        case 6:
            printf("当前线性表的长度为：%d\n",LengthList(&L));
            break;
        case 0:
            ch=0;
            printf("成功退出！");
            break;
        default:
            printf("输入有误，请输入0~6进行选择！\n");
        }
    }
}