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
	// 一个班上有30名学生，每个学生的数据作为一个记录，每个记录包括学号、姓名、三门课程及平均成绩,要求打印三门课程平均成绩最高分的学生记录
	int i, j;
	struct student stu[30];
	int amax = 0;
	int index = 0;
	for(i = 1; i <= 30; i++){
		printf("请输入第%d个学生的信息: (姓名+学号+成绩)\n",i);
		scanf("%s%d%d%d%d", &stu[i].name, &stu[i].id, &stu[i].Chinese, &stu[i].Math, &stu[i].English);
		printf("学生:%s, 学号: %d\n",stu[i].name, stu[i].id);
		printf("Chinese: %d , Math: %d, English: %d \n",stu[i].Chinese,stu[i].Math,stu[i].English);
		stu[i].average = (stu[i].Chinese+stu[i].Math+stu[i].English)/3;
		printf("平均成绩: %f\n", stu[i].average);
		if(stu[i].average > amax){
			amax = stu[i].average;
			index = i;
		}
	}
	printf("平均分最高分为%d",amax);
	printf("学生：%s,学号: %d\n",stu[index].name, stu[index].id);
	printf("Chinese: %d , Math: %d, English: %d \n",stu[index].Chinese,stu[index].Math,stu[index].English);
	return 0;
}