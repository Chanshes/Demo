#include <stdio.h>

/** 题目1：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？ */
int three_digit(){
    int i,j,k;
    int count = 0;
    for(i=1;i<=4;i++){
        for(j=1;j<=4;j++){
            for(k=1;k<=4;k++){
                if(i!=j && j!=k && i!=k){
                    printf("%d%d%d\n",i,j,k);
                    count++;
                }
            }
        }
    }
    printf("共有%d个\n",count);
    return 0;
}

/**题目2：企业发放的奖金根据利润提成。

    利润(I)低于或等于10万元时，奖金可提10%；
    利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
    20万到40万之间时，高于20万元的部分，可提成5%；
    40万到60万之间时高于40万元的部分，可提成3%；
    60万到100万之间时，高于60万元的部分，可提成1.5%；
    高于100万元时，超过100万元的部分按1%提成。
从键盘输入当月利润I，求应发放奖金总数？ */
int bonus(){
    double i;
    double bonus;
    printf("请输入当月利润：");
    if(scanf("%lf",&i)!=1){
        printf("输入错误\n");
        return 0;
    }
    if(i<=100000){
        bonus = i*0.1;
    }else if(i<=200000){
        bonus = 10000+(i-100000)*0.075;
    }else if(i<=400000){
        bonus = 10000+7500+(i-200000)*0.05;
    }else if(i<=600000){
        bonus = 10000+7500+10000+(i-400000)*0.03;
    }else if(i<=1000000){
        bonus = 10000+7500+10000+6000+(i-600000)*0.015;
    }else{
        bonus = 10000+7500+10000+6000+6000+(i-1000000)*0.01;
    }
    printf("应发放奖金总数为：%lf\n",bonus);
    return 0;
}

/**题目3：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？ */
int psquer(){
    int i,j;
    for(i=1;i<100000;i++){
        for(j=1;j<100000;j++){
            if(i*i-100==j*j+168){
                printf("%d\n",i*i-100);
            }
        }
    }
    return 0;
}

/**题目4：输入某年某月某日，判断这一天是这一年的第几天？ */
int isleapyear(){
    int month[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int i,year,month_input,day;
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
    
/**题目5：输入三个整数 x、y、z，请把这三个数由小到大输出。 */
int sort(){
    int x,y,z;
    printf("请输入三个整数：");
    if(scanf("%d %d %d",&x,&y,&z)!=3){
        printf("输入错误\n");
        return 0;
    }
    if(x>y){
        x = x^y;
        y = x^y;
        x = x^y;
    }
    if(x>z){
        x = x^z;
        z = x^z;
        x = x^z;
    }
    if(y>z){
        y = y^z;
        z = y^z;
        y = y^z;
    }
    printf("%d %d %d\n",x,y,z);
    return 0;
}
/**题目6：用*号输出字母C的图案。 */
int printC(){
    printf("  *****\n");
    printf(" *\n");
    printf("*\n");
    printf(" *\n");
    printf("  *****\n");
    return 0;
}
/**题目7：输出特殊图案，请在c环境中运行，看一看，Very Beautiful! */
int printSpecial(){
    char a=176,b=219;
    printf("%c%c%c%c%c\n",b,a,a,a,b);
    printf("%c%c%c%c%c\n",a,b,a,b,a);
    printf("%c%c%c%c%c\n",a,a,b,a,a);
    printf("%c%c%c%c%c\n",a,b,a,b,a);
    printf("%c%c%c%c%c\n",b,a,a,a,b);
    return 0;
}

/**题目8：输出9*9口诀。 */
int print99(){
    int i,j;
    for(i=1;i<=9;i++){
        for(j=1;j<=i;j++){
            printf("%d*%d=%d ",i,j,i*j);
        }
        printf("\n");
    }
    return 0;
}

/**题目9：要求输出国际象棋棋盘。 */
int printChess(){
    int i,j;
    for(i=0;i<8;i++)
    {
        for(j=0;j<8;j++)
            if((i+j)%2==0)
                printf("%c%c",219,219);
            else printf("  ");
        printf("\n");
    }
    return 0;
}

int main(){
    printSpecial();
    printChess();
    return 0;
}
