#define MAXLEN 1024
struct StringType
{
    char str[MAXLEN];
    int Len;
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
        {index++,i=index,j=0;}
    }
    if(t[j]=='\0')
        return index+1;//index不是下标
    else
        return index;
}
