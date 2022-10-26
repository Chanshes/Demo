# define Max_Strlen 1024
typedef struct
{
    char str[Max_Strlen];
    int Length;
}StringType;

void rnext();
int next[Max_Strlen];
int KMP_index(StringType s,StringType t){
    int k=0,j=0;
    while(k<s.Length && j<t.Length)
    {
        if((j==-1)||(s.str[k]==t.str[j]))
        {
            k++;
            j++;
        }
        else
        {
            j=next[j];
        }
        if(j>=t.Length){
            return(k-t.Length);
        }
        else
        {
            return(-1);
        }
    }
}

void rnext(StringType t,int next[])
{
    int k=1,j=0;
    next[1]=0;
    while(k<t.Length)
    {
        if((j==0)||(t.str[k]==t.str[j]))
        {
            k++;
            j++;
            if(t.str[k]!=t.str[j])
            {
                next[k]=j;
            }
            else
            {
                next[k]=next[j];
            }
        }
        else
        {
            next[j]=j;
        }
    }
}