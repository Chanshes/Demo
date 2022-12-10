#include <stdio.h>
#include <windows.h>
#include <malloc.h>

#define MAX 100  /*图的最大顶点数*/

typedef struct 
{
    int n,e;                /*顶点数，边数*/
    char vexs[MAX];         /*顶点数组*/
    int edges[MAX][MAX];    /*边的邻接矩阵*/
}MGraph;

//图的邻接矩阵建立函数-有向邻接矩阵
void CreateDMGraph(MGraph *G)
{
    int i,j,k;
    char ch1,ch2;
    printf("请输入顶点数：");
    scanf("%d",&G->n);
    printf("请输入边数：");
    scanf("%d",&G->e);
    printf("请输入各顶点的信息（每个顶点以回车作为结束）：\n");
    for(i=0;i<G->n;i++)
    {
        getchar();
        printf("输入第%d个顶点：",i+1);
        scanf("%c",&(G->vexs[i]));
    }
    for(i=0;i<G->n;i++)
    {
        for(j=0;j<G->n;j++)
        {
            G->edges[i][j]=0;   /*将邻接矩阵元素全置0*/
        }
    }
    for(k=0;k<G->e;k++)
    {
        getchar();
        printf("建立第%d条边（输入格式：顶点1，顶点2）： ",k+1);
        scanf("%c,%c",&ch1,&ch2);
        for(i=0;i<G->n;i++)
        {
            for(j=0;j<G->n;j++)
            {
                if(ch1==G->vexs[i]&&ch2==G->vexs[j])
                {
                    G->edges[i][j]=1;
                    // G->edges[j][i]=1;   /*加上该语句为无向邻接矩阵，去掉则为有向邻接矩阵*/
                }
            }
        }
    }
}
//图的邻接矩阵建立函数-无向邻接矩阵
void CreateMGraph(MGraph *G)
{
    int i,j,k;
    char ch1,ch2;
    printf("请输入顶点数：");
    scanf("%d",&G->n);
    printf("请输入边数：");
    scanf("%d",&G->e);
    printf("请输入各顶点的信息（每个顶点以回车作为结束）：\n");
    for(i=0;i<G->n;i++)
    {
        getchar();
        printf("输入第%d个顶点：",i+1);
        scanf("%c",&(G->vexs[i]));
    }
    for(i=0;i<G->n;i++)
    {
        for(j=0;j<G->n;j++)
        {
            G->edges[i][j]=0;   /*将邻接矩阵元素全置0*/
        }
    }
    for(k=0;k<G->e;k++)
    {
        getchar();
        printf("建立第%d条边（输入格式：顶点1，顶点2）： ",k+1);
        scanf("%c,%c",&ch1,&ch2);
        for(i=0;i<G->n;i++)
        {
            for(j=0;j<G->n;j++)
            {
                if(ch1==G->vexs[i]&&ch2==G->vexs[j])
                {
                    G->edges[i][j]=1;
                    G->edges[j][i]=1;   /*加上该语句为无向邻接矩阵，去掉则为有向邻接矩阵*/
                }
            }
        }
    }
}


//图的邻接矩阵输出函数
void DispMGraph(MGraph G)
{
    int i,j;
    printf("\n图的邻接矩阵: \n");
    for(i=0;i<G.n;i++)
    {
        for(j=0;j<G.n;j++)
        {
            printf("%5d",G.edges[i][j]);
        }
        printf("\n");
    }
}
//主函数
int main()
{
    MGraph G;
    CreateMGraph(&G);
    DispMGraph(G);
    system("pause");
    return 0;
}