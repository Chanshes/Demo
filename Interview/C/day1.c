/**题目：输入某年某月某日，判断这一天是这一年的第几天？ */

#include <stdio.h>

int month[] = {31,28,31,30,31,30,31,31,30,31,30,31};

int main(){
    int i, day, month_input, year;
    int sum = 0;
    printf("请输入年月日：");
    if(scanf("%d %d %d",&year,&month_input,&day)!=3){
        printf("输入错误\n");
        return 0;
    }
    if(year<0 || month_input<1 || month_input>12 || day<1 || day>31){
        printf("输入错误\n");
        return 0;
    }
    if(year%400==0 || (year%4==0 && year%100!=0)){
        month[1] = 29;
    }
    if(day > month[month_input-1]){
        printf("输入错误\n");
        return 0;
    }
    for(i=0;i<month_input-1;i++){
        sum += month[i];
    }
    printf("这一天是这一年的第%d天\n",sum+day);
    return 0;
}
