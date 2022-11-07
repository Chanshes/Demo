#include <stdio.h>
#include <windows.h>
// 一个班上有30名学生，每个学生的数据作为一个记录，每个记录包括学号、姓名、三门课程及平均成绩,要求打印三门课程平均成绩最高分的学生记录
typedef struct
{
	int id;
	char name[10];
	int Chinese;
	int Math;
	int English;
	double average;
}student;

int main()
{
	int i, j;
	student stu[30];
	double amax = 0;
	int index = 0;
	for(i = 1; i <= 30; i++){
		if(i==1)
			printf("Please enter the 1st information: (name+id+score[Chinese, Math,English])\n");
		else if(i==2)
			printf("Please enter the 2nd information: (name+id+score[Chinese, Math,English])\n");
		else if(i==3)
			printf("Please enter the 3rd information: (name+id+score[Chinese, Math,English])\n");
		else
			printf("Please enter the %dth information: (name+id+score[Chinese, Math,English])\n",i);
		scanf("%s%d%d%d%d", &stu[i].name, &stu[i].id, &stu[i].Chinese, &stu[i].Math, &stu[i].English);
		getchar();
		printf("Name:%s, ID: %d\n",stu[i].name, stu[i].id);
		printf("Chinese: %d, Math: %d, English: %d \n",stu[i].Chinese,stu[i].Math,stu[i].English);
		stu[i].average = (stu[i].Chinese+stu[i].Math+stu[i].English)/3;
		printf("Average score: %.2f\n", stu[i].average);
		if(stu[i].average > amax){
			amax = stu[i].average;
			index = i;
		}
	}
	printf("\nHighest average score is %.2f\n",amax);
	printf("Name:%s,ID: %d\n",stu[index].name, stu[index].id);
	printf("Chinese: %d , Math: %d, English: %d \n",stu[index].Chinese,stu[index].Math,stu[index].English);
	system("pause");
	return 0;
}