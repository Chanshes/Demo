#include <stdio.h>
#include <windows.h>
#include <malloc.h>

#define MAX 100  /*ͼ����󶥵���*/

typedef struct 
{
    int n,e;                /*������������*/
    char vexs[MAX];         /*��������*/
    int edges[MAX][MAX];    /*�ߵ��ڽӾ���*/
}MGraph;

//ͼ���ڽӾ���������-�����ڽӾ���
void CreateDMGraph(MGraph *G)
{
    int i,j,k;
    char ch1,ch2;
    printf("�����붥������");
    scanf("%d",&G->n);
    printf("�����������");
    scanf("%d",&G->e);
    printf("��������������Ϣ��ÿ�������Իس���Ϊ��������\n");
    for(i=0;i<G->n;i++)
    {
        getchar();
        printf("�����%d�����㣺",i+1);
        scanf("%c",&(G->vexs[i]));
    }
    for(i=0;i<G->n;i++)
    {
        for(j=0;j<G->n;j++)
        {
            G->edges[i][j]=0;   /*���ڽӾ���Ԫ��ȫ��0*/
        }
    }
    for(k=0;k<G->e;k++)
    {
        getchar();
        printf("������%d���ߣ������ʽ������1������2���� ",k+1);
        scanf("%c,%c",&ch1,&ch2);
        for(i=0;i<G->n;i++)
        {
            for(j=0;j<G->n;j++)
            {
                if(ch1==G->vexs[i]&&ch2==G->vexs[j])
                {
                    G->edges[i][j]=1;
                    // G->edges[j][i]=1;   /*���ϸ����Ϊ�����ڽӾ���ȥ����Ϊ�����ڽӾ���*/
                }
            }
        }
    }
}
//ͼ���ڽӾ���������-�����ڽӾ���
void CreateMGraph(MGraph *G)
{
    int i,j,k;
    char ch1,ch2;
    printf("�����붥������");
    scanf("%d",&G->n);
    printf("�����������");
    scanf("%d",&G->e);
    printf("��������������Ϣ��ÿ�������Իس���Ϊ��������\n");
    for(i=0;i<G->n;i++)
    {
        getchar();
        printf("�����%d�����㣺",i+1);
        scanf("%c",&(G->vexs[i]));
    }
    for(i=0;i<G->n;i++)
    {
        for(j=0;j<G->n;j++)
        {
            G->edges[i][j]=0;   /*���ڽӾ���Ԫ��ȫ��0*/
        }
    }
    for(k=0;k<G->e;k++)
    {
        getchar();
        printf("������%d���ߣ������ʽ������1������2���� ",k+1);
        scanf("%c,%c",&ch1,&ch2);
        for(i=0;i<G->n;i++)
        {
            for(j=0;j<G->n;j++)
            {
                if(ch1==G->vexs[i]&&ch2==G->vexs[j])
                {
                    G->edges[i][j]=1;
                    G->edges[j][i]=1;   /*���ϸ����Ϊ�����ڽӾ���ȥ����Ϊ�����ڽӾ���*/
                }
            }
        }
    }
}


//ͼ���ڽӾ����������
void DispMGraph(MGraph G)
{
    int i,j;
    printf("\nͼ���ڽӾ���: \n");
    for(i=0;i<G.n;i++)
    {
        for(j=0;j<G.n;j++)
        {
            printf("%5d",G.edges[i][j]);
        }
        printf("\n");
    }
}
//������
int main()
{
    MGraph G;
    CreateMGraph(&G);
    DispMGraph(G);
    system("pause");
    return 0;
}