# include <stdio.h>
# include <malloc.h>

#define MAXLEN 8

typedef int DataType;

typedef struct 
{
    DataType stack[MAXLEN];
    int front, rear;
}SQueue;

//初始化链表
void initSq (SQueue *q)
{
    q->front=0, q->rear=0;
}

//判断空队列
int isNullSq(SQueue *q)
{
    //空队列返回1
    if(q->front==q->rear)
        return 1;
    else
        return 0;
}
//判断队满
int isFullSq(SQueue *q)
{
    if((q->rear+1)%MAXLEN==q->front)
        return 1;
    else
        return 0;
}
//入队操作
void inSque(SQueue *q, DataType d)
{
    q->stack[q->front]=d;//先入 后front++
    q->front++;
}
//出队
DataType outSque(SQueue *q)
{
    if(isNullSq(q))
    {
        printf("空队列不能出队");
        return 0;
    }
    else
    {   
        q->rear++;
        return q->rear;
    }
}

//遍历队列
void prinSq(const SQueue *q)
{
    int i;
    for(i=q->rear;i<q->front;i++)
    {
        printf("%d\t",q->stack[i]);
    }
}
//菜单
void Menu()
{
    printf("\n=========================================================\n");
    printf("|\t\t\t队列操作\t\t\t|\n");
    printf("=========================================================\n");
    printf("|\t\t\t\t\t\t\t|\n");
    printf("|\t\t\t1.初始化队列\t\t\t|\n");
    printf("|\t\t\t2.入队\t\t\t\t|\n");
    printf("|\t\t\t3.出队列\t\t\t|\n");
    printf("|\t\t\t4.遍历队列\t\t\t|\n");
    printf("|\t\t\t0.退出\t\t\t\t|\n");
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
        printf("输入操作数：");
        scanf("%d",&Scan);
        switch (Scan)
        {
        case 0:
            Scan=0;
            printf("退出程序!");
            break;
        case 1:
            initSq(&sq);
            printf("初始化成功!");
            break;
        case 2:
            if(isFullSq(&sq))
                printf("队满不能入队!");
            else
            {
                printf("请输入要入队的元素个数: ");
                scanf("%d",&n);
                printf("请输入:");
                for(i=0;i<n;i++)
                {
                    scanf("%d",&x);
                    inSque(&sq,x);
                }
                printf("入队完成！");
            }
            break;
        case 3:
            if(isNullSq(&sq))
            {
                printf("空队列不能出队");
            }
            else
            {
                printf("请输入要出队队的元素个数:");
                scanf("%d",&n);
                for(i=0;i<n;i++)
                {
                    x=outSque(&sq);
                    printf("%d\t",x);
                }
                printf("出队完成！");
            }
            break;
        case 4:
            printf("遍历队列:");
            for(i=sq.rear;i<sq.front;i++)
            {
                printf("%d\t",sq.stack[i]);
            }
            break;

        default:
            printf("输入有误！请重新输入！\n");
            break;
        }
    }
    return 0;
}
