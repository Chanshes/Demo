#include<stdio.h>
#include<malloc.h>
 
typedef int DataType;
typedef struct linknode {
    DataType data;
    struct linknode *next;
} LinkList;
 
LinkList *InitList() {//初始化链表
    LinkList *head;
    head = (LinkList *) malloc(sizeof(LinkList));//先给链表分配一个头结点所需的内存空间
    head->next = NULL;            //现在头结点为空
    return head;
}

void CreatListH(LinkList *head, int n) {//头插法建立链表函数
    LinkList *s;
    int i;
    printf("请输入%d个整数\n", n);
    for (i = 0; i < n; i++) {
        s = (LinkList *) malloc(sizeof(LinkList));
        scanf("%d", &s->data);
        s->next = head->next;
        head->next = s;
    }
    printf("建表成功\n");
}
 
int LengthList(LinkList *head) {//求链表的长度
    LinkList *p = head->next;
    int j = 0;
    while (p != NULL) {
        p = p->next;
        j++;
    }
    return j;
}
 
int OutList(LinkList *head, int position) {//输出第五个元素
    int i = 0;
    LinkList *p;
    p = head->next;
    while (i < position) {
        p = p->next;
        i++;
    }
    return p->data;
}
 
void DelList(LinkList *head, int position) {//按位置删除链表中元素函数
    int x, j = 0;
    LinkList *p = head, *s;
    while (p->next != 0 && j < position - 1) {
        p = p->next;
        j++;
    }
    if (p->next != NULL && j == position - 1) {
        s = p->next;
        x = s->data;
        p->next = s->next;
        free(s);
        printf("删除第%d位上的元素%d成功\n", position, x);
    } else {
        printf("删除结点位置错误，删除失败");
    }
}
 
void DispList(LinkList *head) {//显示输出链表函数
    LinkList *p;
    p = head->next;
    while (p != NULL) {
        printf("%d ", p->data);
        p = p->next;
    }
    printf("\n");
}
 
void InsList(LinkList *head, int i, DataType x) {  /*按位置插入元素函数*/
    int j = 0;
    LinkList *p, *s;
    p = head;
    while (p->next != NULL && j < i - 1)  /*定位插入点*/
    {
        p = p->next;
        j++;
    }
 
    if (p != NULL)        /*p不为空则将新结点插到p后*/
    {
        s = (LinkList *) malloc(sizeof(LinkList)); /*生成新结点s*/
        s->data = x;               /*将数据x放入新结点的数据域*/
        s->next = p->next;        /*将新结点s的指针域与p结点后面元素相连*/
        p->next = s;               /*将p与新结点s链接*/
        printf("插入元素成功！");
    } else
        printf("插入元素失败");
}
 
void DoupList(LinkList *head) {//显示输出链表函数
    LinkList *p;
    p = head->next;
    while (p != NULL) {
        p->data = 2 * p->data;
        p = p->next;
    }
    printf("\n");
}
 
/*菜单界面*/
void Menu() {
    printf("\n==========================");
    printf("\n\t【1】求表长			");
    printf("\n\t【2】查询指定位置的元素	");
    printf("\n\t【3】向指定位置插入元素	");
    printf("\n\t【4】删除指定位置的元素	");
    // printf("\n\t【5】将链表中的每个元素翻倍");
    printf("\n\t【5】打印当前链表       ");
    printf("\n\t【0】退出					");
    printf("\n==========================\n");
    printf("请输入菜单号（0-6）:");
}
 
int main() {
    LinkList *head;
    DataType x = 0;
    int n, position = 0, ch2, leng;
 
 
    /*创建链表*/
    head = InitList();
    printf("请输入要建立线性表的长度：\n");
    scanf("%d", &n);
    CreatListH(head, n);
    printf("当前链表内容为：");
    DispList(head);
    
    /*进入菜单页面*/
    while (1) {
		Menu();
        scanf("%d", &ch2);
        switch (ch2) {
            case 1://求当前表长
                printf("当前线性表为长度为:%d  \n", LengthList(head));
                break;
 
            case 2://输出指定位置的元素
                printf("请输入您想要查询的位置\n");
                leng = LengthList(head);
                while (1) {
                    printf("请输入 [1 - %d]\n", leng);
                    scanf("%d", &position);
                    if (leng >= position && position > 0)
                        break;
                    printf("输入的位置越界！请重新输入位置~~\n");
                }
                printf("第%d个元素为：%d\n", position, OutList(head, position - 1));
                break;
 
            case 3://向指定位置插入元素
                printf("请输入您想要插入的位置\n");
                leng = LengthList(head);
                while (1) {
                    printf("请输入 [1 - %d]\n", leng);
                    scanf("%d", &position);
                    if (leng + 1 >= position && position > 0)
                        break;
                    printf("输入的位置越界！请重新输入位置~~\n");
                }
                printf("请输入您想要插入的元素\n");
                scanf("%d", &x);
                InsList(head, position, x);
                printf("插入成功！");
                printf("当前链表内容为：");
                DispList(head);
                break;
 
            case 4:  //删除指定位置的元素
                printf("请输入您想删除的位置\n");
                leng = LengthList(head);
                while (1) {
                    printf("请输入 [1 - %d]\n", leng);
                    scanf("%d", &position);
                    if (leng + 1 >= position && position > 0)
                        break;
                    printf("输入的位置越界！请重新输入位置~~\n");
                }
                DelList(head, position);
                printf("当前链表内容为：");
                DispList(head);
                break;
 
            case 6://将链表中的每个元素翻倍
 
                printf("翻倍成功！");
                printf("当前链表内容为：");
                DoupList(head);
                DispList(head);
                break;
 
            case 5://打印当前链表
                printf("当前链表内容为：");
                DispList(head);
                break;
 
            case 0://结束程序
                printf("正在退出......");
                return 0;
            default:
                printf("输入的选项有误，请重新输入~~\n");
        }
    }
}