#include <stdio.h>
#include <windows.h>
#include  <time.h>

#define MAX 1024
// ����һ���ַ�����������ַ��а������ٸ����ʣ�����֮���ÿո�ָ���
int main()
{
    char string[MAX];
    int i,num=0,word=0;
    char c,s;
    printf("Please enter a line of characters separated by spaces:\n");
    gets(string);
    for(i=0;(c=string[i])!='\0';i++)
    {
        if(c==' ')
        {
            word=0;
        }
        else
        {
            if(word==0)
            {
                word++;
                num++;
            }
        }
    }
    printf("There are %d words in the line.\n",num);
    system("pause");
    return 0;
}