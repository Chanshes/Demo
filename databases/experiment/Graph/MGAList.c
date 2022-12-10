#include <stdio.h>
#include<windows.h>
#include <malloc.h>

#define MAX 100
typedef char VertexType;
typedef struct node         /*����߱���*/
{
    int adjvex;             /*�ڽӵ���*/
    struct  node *next;     /*ָ����һ�ڽӵ��ָ����*/
}EdgeNode;
typedef struct vexnode      /*���嶥�����*/
{
    VertexType data;        /*������*/
    EdgeNode *firstedge;    /*ָ���һ���߽��*/
}VHeadNode;
typedef struct
{
    VHeadNode adjlist[MAX]; /*�ڽӱ�ͷ�������*/
    int n,e;                /*������������*/
}AdjList;                   /*ͼ���ڽӱ�����*/

//��������ͼ���ڽӱ���(direct=0=>����,direct!=0=>����)
void CreateAGraph(AdjList *g,int direct)
{
    /*direction=0 => ����
      direction!=0 => ����*/
    int i,j,k;
    EdgeNode *p;
    if(!direct)
        printf("\n������һ������ͼ��\n");
    else
        printf("\n������һ������ͼ��\n");
    printf("������ͼ�Ķ�������");
    scanf("%d",&g->n);
    printf("������ͼ�ı�����");
    scanf("%d",&g->e);
    printf("\n������ͼ�ĸ������Ϣ��\n");
    for(i=0;i<g->n;i++)
    {
        getchar();
        scanf("\n%c",&(g->adjlist[i].data));
        g->adjlist[i].firstedge=NULL;
    }
    printf("\n������ߵ���Ϣ�������ʽΪ�����1�����2���������Ϊ0��1��2...����");
    for(k=0;k<g->e;k++)
    {
        printf("�������%d���ߣ�",k);
        scanf("\n%d,%d",&i,&j); 
        /*�����Ϊi�Ľ����ӵ��ڽӱ���*/
        p=(EdgeNode *)malloc(sizeof(EdgeNode));
        p->adjvex=j;
        p->next=g->adjlist[i].firstedge;
        g->adjlist[i].firstedge=p;
        /*�����Ϊj�Ľ����ӵ��ڽӱ��У�����ͼ������Ӹý��*/
        if(!direct)
        {
            p=(EdgeNode *)malloc(sizeof(EdgeNode));
            p->adjvex=i;                        /*�ڽӵ����Ϊi*/
            p->next=g->adjlist[j].firstedge;    /*���½��p�嵽����vi��ͷ*/
            g->adjlist[j].firstedge=p;
        }
    }
}

//���ͼ���ڽӱ���
void DispAGraph(AdjList *g)
{
    int i;
    EdgeNode *p;
    printf("\nͼ���ڽӱ��ʾ���£�\n");
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

//������
int main()
{
    AdjList g;
    CreateAGraph(&g,0);
    DispAGraph(&g);
    system("pause");
    return 0;
}