#define MAXLEN = 1024

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
        return index+1;/
    else
        return index;
}
