#include <stdio.h>
#define MAX 1024
// ����һ���ַ�����������ַ��а������ٸ����ʣ�����֮���ÿո�ָ���
int main()
{
    char string[MAX];
    int i,num=0,word=0;
    char c,s;
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
            word=1;
            num++;
            }
        }
    }
    printf("There are %d words in the line.\n",num);
    return 0;
}