#include <conio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_VERTEX_NUM 20 // ͼ����󶥵���
#define MAXQSIZE 30       // ���е��������
typedef struct ArcNode
{
    int adjvex;              // �û���ָ��Ķ����λ��
    struct ArcNode *nextarc; // ָ����һ������ָ��
} ArcNode;                   // �����
typedef struct
{
    ArcNode *AdjList[MAX_VERTEX_NUM]; // ָ���һ�������ö���Ļ���ָ��
    int vexnum, arcnum;               // ͼ�ĵ�ǰ����ͻ���
    int GraphKind;                    // ͼ�����࣬0---����ͼ��1---����ͼ
} Graph;
typedef struct // ���нṹ
{
    int elem[MAXQSIZE]; // ������
    int front;    // ��ͷָ��
    int rear;           // ��βָ��
} SqQueue;
int visited[MAX_VERTEX_NUM]; // ȫ�ֱ����������ʱ�־����
void CreateGraph(Graph &);    // ����ͼ���ڽӱ�
void DFSTraverse(Graph);      // ���������������ͼ
void DFS(Graph, int);
void BFSTraverse(Graph);         // ���������������ͼ
void Initial(SqQueue &);         // ��ʼ��һ������

int QueueEmpty(SqQueue);        // �ж϶����Ƿ��
int EnQueue(SqQueue &, int);    // ��һ��Ԫ�������
int DeQueue(SqQueue &, int &);  // ��һ��Ԫ�س�����
int FirstAdjVex(Graph, int);     // ��ͼ��ĳһ����ĵ�һ���ڽӶ���
int NextAdjVex(Graph, int, int); // ��ĳһ�������һ���ڽӶ���
int main()
{
    Graph G; // �����ڽӱ�ṹ��ͼ
    char j = 'y';
    printf("��������ʾ����һ��ͼ�����������б���.\n");
    printf("��������Ҫ���ɵ�ͼ������.\n");
    printf("0---����ͼ, 1--����ͼ\n");
    printf("֮������ͼ�Ķ������ͻ�����\n��ʽ��������������������:4,3\n");
    printf("�����������(��β����ͷ).\n����:\n1,2\n1,3\n2,4\n");
    printf("���������һ��ͼ��������������Ⱥ͹�ȱ���.\n");
    printf("��ȱ���:1->2->4->3\n��ȱ���:1->2->3->4\n");
    while (j != 'N' && j != 'n')
    {
        printf("������Ҫ���ɵ�ͼ������(0/1):");
        scanf("%d", &G.GraphKind); // ����ͼ������
        printf("�����붥�����ͻ�����");
        scanf("%d,%d", &G.vexnum, &G.arcnum); // ����ͼ�Ķ������ͻ���
        CreateGraph(G);                       // �����ڽӱ�ṹ��ͼ
        DFSTraverse(G);                       // ���������������ͼ
        BFSTraverse(G);                       // ���������������ͼ
        printf("ͼ������ϣ�����������?(Y/N)");
        scanf(" %c", &j);
        return 0;
    }
}
void CreateGraph(Graph &G)
{ // �����ڽӱ�ṹ��ͼG
    int i;
    int start, end;
    ArcNode *s;
    for (i = 1; i <= G.vexnum; i++)
        G.AdjList[i] = NULL; // ��ʼ��ָ������
    for (i = 1; i <= G.arcnum; i++)
        {
            scanf("%d,%d", &start, &end);           // ���뻡�������յ�
            s = (ArcNode *)malloc(sizeof(ArcNode)); // ����һ�������
            s->nextarc = G.AdjList[start];          // ���뵽�ڽӱ���
            s->adjvex = end;
            G.AdjList[start] = s;
            if (G.GraphKind == 0) // ��������ͼ���ٲ��뵽�յ�Ļ�����
            {
                s = (ArcNode *)malloc(sizeof(ArcNode));
                s->nextarc = G.AdjList[end];
                s->adjvex = start;
                G.AdjList[end] = s;
            }
        }
}
void DFSTraverse(Graph G)
{ // ������ȱ���ͼG
    int i;
    printf("DFSTraverse:");
    for (i = 1; i <= G.vexnum; i++)
        visited[i] = 0; // ���ʱ�־�����ʼ��
    for (i = 1; i <= G.vexnum; i++)
        if (!visited[i])
            DFS(G, i); // ����δ���ʵĶ������DFS
    printf("\b\b \n");
}

void DFS(Graph G, int i)
{ // �ӵ�i����������ݹ����ȱ���ͼG
    int w;
    visited[i] = 1; // ���ʵ�i������
    printf("%d->", i);
    for (w = FirstAdjVex(G, i); w; w = NextAdjVex(G, i, w))
        if (!visited[w])
            DFS(G, w); // ����δ���ʵ��ڽӶ���w����DFS
}
void BFSTraverse(Graph G)
{ // ��������ȷǵݹ�ı���ͼG��ʹ�ø�������Q�ͷ��ʱ�־����visited
    int i, u, w;
    SqQueue Q;
    printf("BFSTreverse:");
    for (i = 1; i <= G.vexnum; i++)
        visited[i] = 1; // ���ʱ�־�����ʼ��
    Initial(Q);             // ��ʼ������
    for (i = 1; i <= G.vexnum; i++)
        if (!visited[i])
        {
            visited[i] = 1; // ���ʶ���i
            printf("%d->", i);
            EnQueue(Q, i);         // �����i�����
            while (!QueueEmpty(Q)) // �����в��գ�����
                {
                    DeQueue(Q, u); // ����ͷԪ�س����в���Ϊu
                    for (w = FirstAdjVex(G, u); w; w = NextAdjVex(G, u, w))
                        if (!visited[w]) // ��u����δ���ʵ��ڽӶ���w���з��ʲ������
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
{ // ��ͼG��Ѱ�ҵ�v������ĵ�һ���ڽӶ���
    if (!G.AdjList[v])
        return 0;
    else
        return (G.AdjList[v]->adjvex);
}
int NextAdjVex(Graph G, int v, int u)
{ // ��ͼG��Ѱ�ҵ�v������������u����һ���ڽӶ���
    ArcNode *p;
    p = G.AdjList[v];
    while (p->adjvex != u)
        p = p->nextarc; // �ڶ���v�Ļ������ҵ�����u
    if (p->nextarc == NULL)
        return 0; // ���������һ�����㣬����0
    else
        return (p->nextarc->adjvex); // ������һ���ڽӶ�������
}
void Initial(SqQueue &Q)
{ // ���г�ʼ��
    Q.front = Q.rear = 0;
}
int QueueEmpty(SqQueue Q)
{ // �ж϶����Ƿ��ѿգ����շ���True,���򷵻�False
    if (Q.front == Q.rear)
        return 1;
    else
        return 0;
}
int EnQueue(SqQueue &Q, int ch)
{ // ����У��ɹ�����True��ʧ�ܷ���False
    if ((Q.rear + 1) % MAXQSIZE == Q.front)
        return 0;
    Q.elem[Q.rear] = ch;
    Q.rear = (Q.rear + 1) % MAXQSIZE;
    return 1;
}
int DeQueue(SqQueue &Q, int &ch)
{ // ������,�ɹ�����True������ch���ظ�Ԫ��ֵ��ʧ�ܷ���False
    if (Q.front == Q.rear)
        return 0;
    ch = Q.elem[Q.front];
    Q.front = (Q.front + 1) % MAXQSIZE;
    return 1; // �ɹ������У�����True
}