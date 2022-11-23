#include <stdio.h>
#include "BT.h"
#include <windows.h>
int main()
{
    BTree *t;
    printf("请输入根节点：");
    t=CreateBTree();
    printf("\n");
    printf("先序遍历为：");
    PreOrder(t);
    printf("\n");
    system("pause");
    return 0;
}
