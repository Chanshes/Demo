#include <stdio.h>

#define M 100

typedef int DataType;
typedef struct
{
	DataType data[M];
	int Length;//ʵ�ʳ���
}Sqlist;

Sqlist L;

void InitList(Sqlist* L)
 {
	L->Length = 0;
 }

typedef int KeyType;
typedef struct
{
	KeyType key;
}LineList;
int SeqSearch(LineList r[], int n, KeyType k)
{
	int i = n;
	r[i].key = k;
	while (r[i].key != k)
	{
		i--;
	}
	return(i);
}
void CreatList(Sqlist*L)
{
	srand((unsigned int)time(NULL));
	L->data[M] =  0 ;
	for (int i = 0; i < 9999; i++)
	{
		while (1)
		{
			int x = rand() % 100000;
			int flag = 0;
			for (int j = 0; j < i; j++)
			{
				if (L->data[j]==x)
				{
					flag = 1; break;
				}
			}
			if (flag == 0)
			{
				L->data[i] = x;
				break;
			}

		}
	}
	for (int i = 0; i < 9999; i++)
			{
				printf("%8d", L[i]);
			}
}
void bubble_sort( Sqlist*L, int n)
{//ð�������㷨  int m,ij;  RedType x;  //����ʱ��ʱ�洢  for(m=1;m<=n-1;m++){//�ܹ���m��
	int m,j,flag=1;
	int x;
	for (m = 1; m <= n - 1; m++)
	{
		flag = 0;
		for (j = 1; j <= n - m; j++)
		{
			if (L->data[j]>L->data[j + 1])
			{//��������
				flag = 1;
				x =L->data[j]; 
				L->data[j] = L->data[j + 1];
				L->data[j + 1] = x;//����  } //endif
			}//for	
		}
	}
}
