#include <stdio.h>
#define MAXSIZE 8

typedef int DataType;
typedef struct{
    DataType data[MAXSIZE];
    int top;
}SeqStack;

// 判断栈空、栈满
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

//1.初始化顺序栈
void InitStack(SeqStack *s)
{
    s->top=-1;
    printf("初始化完成！");
}
//2.插入元素
void PushStack(SeqStack *s,DataType x)
{
    if(!FullStack(s))
    {
        s->top++;
        s->data[s->top] = x;
    }
    else
    {
        printf("栈满不能入栈！");
    }
}
//3.删除栈顶元素
DataType DelStack(SeqStack *s)
{
    if(!EmptyStack(s))
    {
        DataType result=s->data[s->top];
        s->top--;
        return result;
    }
    else
        printf("栈已空无法删除！");
        return 0;

}
//4.取栈顶元素
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
        printf("栈已空无法取出!");
        return 0;
    }
}
//5.遍历顺序栈
void ErgodicStack(SeqStack *s)
{
    int i;
    for(i=0;i<=s->top;i++)
    {
        printf("%d\t",s->data[i]);
    }
}
//菜单
void Menu()
{
    printf("\n==========================");
    printf("\n\t【1】初始化顺序栈");
    printf("\n\t【2】插入元素");
    printf("\n\t【3】删除栈顶元素");
    printf("\n\t【4】取栈顶元素");
    printf("\n\t【5】遍历顺序栈");
    printf("\n\t【0】退出");
    printf("\n==========================\n");
    printf("请输入菜单号（0-6）:");
}
//主函数
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
                printf("输入入栈元素：");
                scanf("%d",&n);
                getchar();
                PushStack(&seqstack, n);
                break;
            case 3:
                printf("已删除栈顶元素：%d",DelStack(&seqstack));
                break;
            case 4:
                printf("取出栈顶元素：%d",PopStack(&seqstack));
                break;
            case 5:
                printf("遍历顺序栈:\n");
                ErgodicStack(&seqstack);
                break;
            case 0:
                judge=0;
                printf("退出程序！");
                break;
            default:
                printf("请正确输入！");
                break;
        }
    }
    return 0;
}