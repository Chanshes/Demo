#include <stdio.h>

struct student
{
	/* data */
	int id;
	char name[10];
	int Chinese;
	int Math;
	int English;
	double average;
	};

int main()
{
	// һ��������30��ѧ����ÿ��ѧ����������Ϊһ����¼��ÿ����¼����ѧ�š����������ſγ̼�ƽ���ɼ�,Ҫ���ӡ���ſγ�ƽ���ɼ���߷ֵ�ѧ����¼
	int i, j;
	struct student stu[30];
	int amax = 0;
	int index = 0;
	for(i = 1; i <= 30; i++){
		printf("�������%d��ѧ������Ϣ: (����+ѧ��+�ɼ�)\n",i);
		scanf("%s%d%d%d%d", &stu[i].name, &stu[i].id, &stu[i].Chinese, &stu[i].Math, &stu[i].English);
		printf("ѧ��:%s, ѧ��: %d\n",stu[i].name, stu[i].id);
		printf("Chinese: %d , Math: %d, English: %d \n",stu[i].Chinese,stu[i].Math,stu[i].English);
		stu[i].average = (stu[i].Chinese+stu[i].Math+stu[i].English)/3;
		printf("ƽ���ɼ�: %f\n", stu[i].average);
		if(stu[i].average > amax){
			amax = stu[i].average;
			index = i;
		}
	}
	printf("ƽ������߷�Ϊ%d",amax);
	printf("ѧ����%s,ѧ��: %d\n",stu[index].name, stu[index].id);
	printf("Chinese: %d , Math: %d, English: %d \n",stu[index].Chinese,stu[index].Math,stu[index].English);
	return 0;
}