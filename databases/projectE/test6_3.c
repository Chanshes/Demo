
//这题就是直接用之前通过中序和前序找后序的代码直接改的，就是把输出后序改成了计算高度
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct Node
{
    char data;
    struct Node *lchild;
    struct Node *rchild;
}List;

int h, max;
char pre[30], in[30];

//当前先序序列的区间为[preL, preR], 中序序列区间为[inL, inR],返回根节点的地址
List* Create(int preL, int preR, int inL, int inR)
{
    if(preL > preR)
    {
        return NULL; //先序序列长度小于等于0时，直接返回
    }
    List *root = (List *)malloc(sizeof(List));
    root->data = pre[preL];
    int k;
    for(k = inL; k <= inR; k++)
    {
        if(in[k] == pre[preL]) //在中序序列中找到in[k] == pre[preL]的结点
        {
            break;
        }
    }
    int numLeft = k - inL; //对于当前结点的左子树的结点的个数
    root->lchild = Create(preL+1, preL+numLeft, inL, k-1);
    root->rchild = Create(preL+numLeft+1, preR, k+1, inR);

    return root; //返回根结点地址
}

void Postorder(List *root, int k)
{
    if(root != NULL)
    {
        if(k > max)
            max = k;
       Postorder(root->lchild, k+1);
       Postorder(root->rchild, k+1);
    }


}

int main()
{
    int n;
    while(~scanf("%d", &n))
    {
        printf("输入先序: ");
        scanf("%s", pre);
        printf("\n输入中序: ");
        scanf("%s", in);
        h = strlen(pre);
        max = 0;
        List *root = Create(0, h-1, 0, h-1); //建树
        Postorder(root, 1);
        printf("%d\n", max);
    }
    return 0;
}
