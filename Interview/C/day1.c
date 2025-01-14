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

/**题目10：打印楼梯，同时在楼梯上方打印两个笑脸。 */
int printStairs(){
    int i,j;
    printf("\1\1\n"); /*输出两个笑脸*/
    for(i=1;i<11;i++)
    {
        for(j=1;j<=i;j++)
            printf("%c%c",219,219);
        printf("\n");
    }
    return 0;
}

/**题目11： 古典问题（兔子生崽）：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * （输出前40个月即可） */
int rabbit(){
    int f1=1,f2=1,i;
    for(i=1;i<=20;i++)
    {
        printf("%12d%12d",f1,f2);
        if(i%2==0) printf("\n");
        f1=f1+f2; /*前两个月加起来赋值给第三个月*/
        f2=f1+f2; /*前两个月加起来赋值给第三个月*/
    }
    return 0;
}

/**题目12：判断101-200之间有多少个素数，并输出所有素数。 */
int prime(){
    int i,j;
    int count = 0;
    for(i=101;i<=200;i++){
        for(j=2;j<i;j++){
            if(i%j==0){
                break;
            }
        }
        if(j==i){
            printf("%d ",i);
            count++;
        }
    }
    printf("\n共有%d个素数\n",count);
    return 0;
}

/**题目13：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数 本身。
 * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。 */
int narcissus(){
    int i,j,k;
    for(i=1;i<=9;i++){
        for(j=0;j<=9;j++){
            for(k=0;k<=9;k++){
                if(i*i*i+j*j*j+k*k*k==i*100+j*10+k){
                    printf("%d\n",i*100+j*10+k);
                }
            }
        }
    }
    return 0;
}

/**题目14：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。 */
int factor(){
    int n,i;
    printf("请输入一个正整数：");
    if(scanf("%d",&n)!=1){
        printf("输入错误\n");
        return 0;
    }
    printf("%d=",n);
    for(i=2;i<=n;i++){
        while(n!=i){
            if(n%i==0){
                printf("%d*",i);
                n = n/i;
            }else{
                break;
            }
        }
    }
    printf("%d\n",n);
    return 0;
}

/**题目15：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，
 * 60分以下的用C表示。 */
int score(){
    int score;
    printf("请输入学生成绩：");
    if(scanf("%d",&score)!=1){
        printf("输入错误\n");
        return 0;
    }
    if(score>=90){
        printf("A\n");
    }else if(score>=60){
        printf("B\n");
    }else{
        printf("C\n");
    }
    return 0;
}

/**题目16：输入两个正整数m和n，求其最大公约数和最小公倍数。 */
int gcd_lcm(){
    int m,n;
    int a,b;
    printf("请输入两个正整数：");
    if(scanf("%d %d",&m,&n)!=2){
        printf("输入错误\n");
        return 0;
    }
    a = m;
    b = n;
    while(m%n!=0){
        int temp = m%n;
        m = n;
        n = temp;
    }
    printf("最大公约数为：%d\n",n);
    printf("最小公倍数为：%d\n",a*b/n);
    return 0;
}

/**题目17：输入一行字符，分别统计出其中英文字母、空格、数字和其他字符的个数。 */
int count(){
    char c;
    int letter = 0;
    int space = 0;
    int digit = 0;
    int other = 0;
    printf("请输入一行字符：");
    while((c=getchar())!='\n'){
        if((c>='a' && c<='z') || (c>='A' && c<='Z')){
            letter++;
        }else if(c==' '){
            space++;
        }else if(c>='0' && c<='9'){
            digit++;
        }else{
            other++;
        }
    }
    printf("英文字母：%d\n",letter);
    printf("空格：%d\n",space);
    printf("数字：%d\n",digit);
    printf("其他字符：%d\n",other);
    return 0;
}

/**题目18：求 s=a+aa+aaa+aaaa+aa...a 的值，其中 a 是一个数字。
 * 例如 2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。 */
int sum(){
    int a,n;
    int sum = 0;
    int i;
    printf("请输入a和n：");
    if(scanf("%d %d",&a,&n)!=2){
        printf("输入错误\n");
        return 0;
    }
    for(i=1;i<=n;i++){
        sum += a;
        a = a*10+a;
    }
    printf("s=%d\n",sum);
    return 0;
}

/**题目19：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1+2+3。
 * 编程找出1000以内的所有完数。 */
int perfect(){
    int i,j;
    for(i=1;i<=1000;i++){
        int sum = 0;
        for(j=1;j<i;j++){
            if(i%j==0){
                sum += j;
            }
        }
        if(sum==i){
            printf("%d\n",i);
        }
    }
    return 0;
}

/**题目20：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？ */
int ball(){
    double height = 100;
    double sum = 100;
    int i;
    for(i=1;i<10;i++){
        height = height/2;
        sum += height*2;
    }
    printf("共经过%f米\n",sum);
    printf("第10次反弹%f米\n",height/2);
    return 0;
}

int main(){
    perfect();
    return 0;
}
