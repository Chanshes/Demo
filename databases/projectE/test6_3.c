
//�������ֱ����֮ǰͨ�������ǰ���Һ���Ĵ���ֱ�Ӹĵģ����ǰ��������ĳ��˼���߶�
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

//��ǰ�������е�����Ϊ[preL, preR], ������������Ϊ[inL, inR],���ظ��ڵ�ĵ�ַ
List* Create(int preL, int preR, int inL, int inR)
{
    if(preL > preR)
    {
        return NULL; //�������г���С�ڵ���0ʱ��ֱ�ӷ���
    }
    List *root = (List *)malloc(sizeof(List));
    root->data = pre[preL];
    int k;
    for(k = inL; k <= inR; k++)
    {
        if(in[k] == pre[preL]) //�������������ҵ�in[k] == pre[preL]�Ľ��
        {
            break;
        }
    }
    int numLeft = k - inL; //���ڵ�ǰ�����������Ľ��ĸ���
    root->lchild = Create(preL+1, preL+numLeft, inL, k-1);
    root->rchild = Create(preL+numLeft+1, preR, k+1, inR);

    return root; //���ظ�����ַ
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
        printf("��������: ");
        scanf("%s", pre);
        printf("\n��������: ");
        scanf("%s", in);
        h = strlen(pre);
        max = 0;
        List *root = Create(0, h-1, 0, h-1); //����
        Postorder(root, 1);
        printf("%d\n", max);
    }
    return 0;
}
