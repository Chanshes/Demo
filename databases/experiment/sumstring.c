#include <stdio.h>
#define MAX 1024
// 输入一行字符，计算该行字符中包含多少个单词，单词之间用空格分隔开
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