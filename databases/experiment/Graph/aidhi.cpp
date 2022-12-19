#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_VERTEX_NUM 20 // 图的最大顶点数
#define MAXQSIZE 30       // 队列的最大容量
typedef struct ArcNode
{
    int adjvex;              // 该弧所指向的顶点的位置
    struct ArcNode *nextarc; // 指向下一条弧的指针
} ArcNode;                   // 弧结点
typedef struct
{
    ArcNode *AdjList[MAX_VERTEX_NUM]; // 指向第一条依附该顶点的弧的指针
    int vexnum, arcnum;               // 图的当前顶点和弧数
    int GraphKind;                    // 图的种类，0---无向图，1---有向图
} Graph;
typedef struct // 队列结构
{
    int elem[MAXQSIZE]; // 数据域
    int front;    // 队头指针
    int rear;           // 队尾指针
} SqQueue;
int visited[MAX_VERTEX_NUM]; // 全局变量——访问标志数组
void CreateGraph(Graph &);    // 生成图的邻接表
void DFSTraverse(Graph);      // 深度优先搜索遍历图
void DFS(Graph, int);
void BFSTraverse(Graph);         // 广度优先搜索遍历图
void Initial(SqQueue &);         // 初始化一个队列

int QueueEmpty(SqQueue);        // 判断队列是否空
int EnQueue(SqQueue &, int);    // 将一个元素入队列
int DeQueue(SqQueue &, int &);  // 将一个元素出队列
int FirstAdjVex(Graph, int);     // 求图中某一顶点的第一个邻接顶点
int NextAdjVex(Graph, int, int); // 求某一顶点的下一个邻接顶点
int main()
{
    Graph G; // 采用邻接表结构的图
    char j = 'y';
    printf("本程序将演示生成一个图，并对它进行遍历.\n");
    printf("首先输入要生成的图的种类.\n");
    printf("0---无向图, 1--有向图\n");
    printf("之后输入图的顶点数和弧数。\n格式：顶点数，弧数；例如:4,3\n");
    printf("接着输入各边(弧尾，弧头).\n例如:\n1,2\n1,3\n2,4\n");
    printf("程序会生成一个图，并对它进行深度和广度遍历.\n");
    printf("深度遍历:1->2->4->3\n广度遍历:1->2->3->4\n");
    while (j != 'N' && j != 'n')
    {
        printf("请输入要生成的图的种类(0/1):");
        scanf("%d", &G.GraphKind); // 输入图的种类
        printf("请输入顶点数和弧数：");
        scanf("%d,%d", &G.vexnum, &G.arcnum); // 输入图的顶点数和弧数
        CreateGraph(G);                       // 生成邻接表结构的图
        DFSTraverse(G);                       // 深度优先搜索遍历图
        BFSTraverse(G);                       // 广度优先搜索遍历图
        printf("图遍历完毕，继续进行吗?(Y/N)");
        scanf(" %c", &j);
        return 0;
    }
}
void CreateGraph(Graph &G)
{ // 构造邻接表结构的图G
    int i;
    int start, end;
    ArcNode *s;
    for (i = 1; i <= G.vexnum; i++)
        G.AdjList[i] = NULL; // 初始化指针数组
    for (i = 1; i <= G.arcnum; i++)
        {
            scanf("%d,%d", &start, &end);           // 输入弧的起点和终点
            s = (ArcNode *)malloc(sizeof(ArcNode)); // 生成一个弧结点
            s->nextarc = G.AdjList[start];          // 插入到邻接表中
            s->adjvex = end;
            G.AdjList[start] = s;
            if (G.GraphKind == 0) // 若是无向图，再插入到终点的弧链中
            {
                s = (ArcNode *)malloc(sizeof(ArcNode));
                s->nextarc = G.AdjList[end];
                s->adjvex = start;
                G.AdjList[end] = s;
            }
        }
}
void DFSTraverse(Graph G)
{ // 深度优先遍历图G
    int i;
    printf("DFSTraverse:");
    for (i = 1; i <= G.vexnum; i++)
        visited[i] = 0; // 访问标志数组初始化
    for (i = 1; i <= G.vexnum; i++)
        if (!visited[i])
            DFS(G, i); // 对尚未访问的顶点调用DFS
    printf("\b\b \n");
}

void DFS(Graph G, int i)
{ // 从第i个顶点出发递归地深度遍历图G
    int w;
    visited[i] = 1; // 访问第i个顶点
    printf("%d->", i);
    for (w = FirstAdjVex(G, i); w; w = NextAdjVex(G, i, w))
        if (!visited[w])
            DFS(G, w); // 对尚未访问的邻接顶点w调用DFS
}
void BFSTraverse(Graph G)
{ // 按广度优先非递归的遍历图G，使用辅助队列Q和访问标志数组visited
    int i, u, w;
    SqQueue Q;
    printf("BFSTreverse:");
    for (i = 1; i <= G.vexnum; i++)
        visited[i] = 1; // 访问标志数组初始化
    Initial(Q);             // 初始化队列
    for (i = 1; i <= G.vexnum; i++)
        if (!visited[i])
        {
            visited[i] = 1; // 访问顶点i
            printf("%d->", i);
            EnQueue(Q, i);         // 将序号i入队列
            while (!QueueEmpty(Q)) // 若队列不空，继续
                {
                    DeQueue(Q, u); // 将队头元素出队列并置为u
                    for (w = FirstAdjVex(G, u); w; w = NextAdjVex(G, u, w))
                        if (!visited[w]) // 对u的尚未访问的邻接顶点w进行访问并入队列
                        {
                            visited[w] = 1;
                            printf("%d->", w);
                            EnQueue(Q, w);
                        }
                }
        }
    printf("\b\b \n");
}
int FirstAdjVex(Graph G, int v)
{ // 在图G中寻找第v个顶点的第一个邻接顶点
    if (!G.AdjList[v])
        return 0;
    else
        return (G.AdjList[v]->adjvex);
}
int NextAdjVex(Graph G, int v, int u)
{ // 在图G中寻找第v个顶点的相对于u的下一个邻接顶点
    ArcNode *p;
    p = G.AdjList[v];
    while (p->adjvex != u)
        p = p->nextarc; // 在顶点v的弧链中找到顶点u
    if (p->nextarc == NULL)
        return 0; // 若已是最后一个顶点，返回0
    else
        return (p->nextarc->adjvex); // 返回下一个邻接顶点的序号
}
void Initial(SqQueue &Q)
{ // 队列初始化
    Q.front = Q.rear = 0;
}
int QueueEmpty(SqQueue Q)
{ // 判断队列是否已空，若空返回True,否则返回False
    if (Q.front == Q.rear)
        return 1;
    else
        return 0;
}
int EnQueue(SqQueue &Q, int ch)
{ // 入队列，成功返回True，失败返回False
    if ((Q.rear + 1) % MAXQSIZE == Q.front)
        return 0;
    Q.elem[Q.rear] = ch;
    Q.rear = (Q.rear + 1) % MAXQSIZE;
    return 1;
}
int DeQueue(SqQueue &Q, int &ch)
{ // 出队列,成功返回True，并用ch返回该元素值，失败返回False
    if (Q.front == Q.rear)
        return 0;
    ch = Q.elem[Q.front];
    Q.front = (Q.front + 1) % MAXQSIZE;
    return 1; // 成功出队列，返回True
}