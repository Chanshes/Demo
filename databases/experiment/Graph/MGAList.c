#include <stdio.h>
#include<windows.h>
#include <malloc.h>

#define MAX 100
typedef char VertexType;
typedef struct node         /*定义边表结点*/
{
    int adjvex;             /*邻接点域*/
    struct  node *next;     /*指向下一邻接点的指针域*/
}EdgeNode;
typedef struct vexnode      /*定义顶点表结点*/
{
    VertexType data;        /*顶点域*/
    EdgeNode *firstedge;    /*指向第一条边结点*/
}VHeadNode;
typedef struct
{
    VHeadNode adjlist[MAX]; /*邻接表头结点数组*/
    int n,e;                /*顶点数，边数*/
}AdjList;                   /*图的邻接表类型*/

//生成无向图的邻接表函数(direct=0=>无向,direct!=0=>有向)
void CreateAGraph(AdjList *g,int direct)
{
    /*direction=0 => 无向
      direction!=0 => 有向*/
    int i,j,k;
    EdgeNode *p;
    if(!direct)
        printf("\n将建立一个无向图。\n");
    else
        printf("\n将建立一个有向图。\n");
    printf("请输入图的顶点数：");
    scanf("%d",&g->n);
    printf("请输入图的边数：");
    scanf("%d",&g->e);
    printf("\n请输入图的个点的信息：\n");
    for(i=0;i<g->n;i++)
    {
        getchar();
        scanf("\n%c",&(g->adjlist[i].data));
        g->adjlist[i].firstedge=NULL;
    }
    printf("\n请输入边的信息，输入格式为：序号1，序号2（序号依次为0、1、2...）：");
    for(k=0;k<g->e;k++)
    {
        printf("请输入第%d条边：",k);
        scanf("\n%d,%d",&i,&j); 
        /*将编号为i的结点添加到邻接表中*/
        p=(EdgeNode *)malloc(sizeof(EdgeNode));
        p->adjvex=j;
        p->next=g->adjlist[i].firstedge;
        g->adjlist[i].firstedge=p;
        /*将编号为j的结点添加到邻接表中，有向图不用添加该结点*/
        if(!direct)
        {
            p=(EdgeNode *)malloc(sizeof(EdgeNode));
            p->adjvex=i;                        /*邻接点序号为i*/
            p->next=g->adjlist[j].firstedge;    /*将新结点p插到顶点vi表头*/
            g->adjlist[j].firstedge=p;
        }
    }
}

//输出图的邻接表函数
void DispAGraph(AdjList *g)
{
    int i;
    EdgeNode *p;
    printf("\n图的邻接表表示如下：\n");
    for(i=0;i<g->n;i++)
    {
        printf("%2d [%c]",i,g->adjlist[i].data);
        p=g->adjlist[i].firstedge;
        while(p!=NULL)
        {
            printf("-->[%d]",p->adjvex);
            p=p->next;
        }
        printf("\n");
    }
}

//主函数
int main()
{
    AdjList g;
    CreateAGraph(&g,0);
    DispAGraph(&g);
    system("pause");
    return 0;
}