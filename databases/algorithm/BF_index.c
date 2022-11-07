#define MAXLEN 1024
typedef struct 
{
    char str[MAXLEN];
    int Length;
}StringType;

int BF(const char s[],const char t[])
{
    int index=0;
    int i=0,j=0;
    while(s[i]!='\0'&&t[j]!='\0')
    {
        if(s[i]==t[j])
        {   i++;
            j++;}
        else
        {
            index++,i=index,j=0;
        }
    }
    if(t[j]=='\0')
        return index+1;
    else
        return index;
}
//查找主串中是否存在给定字符串 如果有则返回当前相等字串的位置，否则返回-1；
int BF_index(StringType s, StringType t)
{
    int index;
    int i=0,j=0;
    while(i<s.Length && j<t.Length)
    {
        if((i==-1)||(s.str[i]==t.str[j]))
        {
            i++;
            j++;
        }
        else{
            index++;
            i=index;
            j=0;
        }
    }
    if(t.str[j]=='\0')
    {
        return index+1;
    }
    else
    {
        return index;
    }
}