#include <stdio.h>
#include "BT.h"
#include <windows.h>
int main()
{
    BTree *t;
    printf("��������ڵ㣺");
    t=CreateBTree();
    printf("\n");
    printf("�������Ϊ��");
    PreOrder(t);
    printf("\n");
    system("pause");
    return 0;
}
