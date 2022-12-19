
#include<stdio.h>
#define MAX 10

typedef struct student
{
    char name[8];
    int score;
};

student R[MAX];

int main()
{
    int num, i, j, max, temp;
    printf("\n请输入学生成绩: \n");
    for (i = 0; i < MAX; i++)
    {
        printf("姓名:");
        scanf("%s", &R[i].name);
        scanf("%4d", &R[i].score);
    }
    num = 1;
    for (i = 0; i < MAX; i++)
    {
        max = i;
        for (j = i + 1; j < MAX; j++)
            if (R[j].score > R[max].score)
                max = j;
        if (max != i)
        {
            temp = R[max];
            R[max] = R[i];
            R[i] = temp;
        }
        if ((i > 0) && (R[i].score < R[i - 1].score))
            num = num + 1;
        printf("%4d%s%4d", num, R[i].name, R[i].score);
    }
    return 0;
}