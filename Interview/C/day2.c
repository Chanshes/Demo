#include <stdio.h>

/**题目21：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天早上都吃了前一天剩下 的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。 */
int peach()
{
    int i;
    int n = 1;
    for (i = 1; i < 10; i++)
    {
        n = (n + 1) * 2;
    }
    printf("第一天共摘了%d个桃子\n", n);
    return 0;
}

/**题目22：两个乒乓球队进行比赛，各出三人，甲队为 a、b、c 三人，乙队为 x、y、z 三人。
 * 抽签决定比赛名单，有人向队员打听比赛的名单：a 说他不和 x 比，c 说他不和 x、z 比，请编写代码找出三队赛手的名单。 */
int pingpong()
{
    char a, b, c;
    for (a = 'x'; a <= 'z'; a++)
    {
        for (b = 'x'; b <= 'z'; b++)
        {
            if (a == b)
                continue;
            for (c = 'x'; c <= 'z'; c++)
            {
                if (a == c || b == c)
                    continue;
                if (a != 'x' && c != 'x' && c != 'z')
                {
                    printf("a和%c比，b和%c比，c和%c比\n", a, b, c);
                }
            }
        }
    }
    return 0;
}

/**题目23：打印出如下图案（菱形） */
int printDiamond()
{
    int i, j, k;
    for (i = 0; i < 4; i++)
    {
        for (j = 0; j < 3 - i; j++)
        {
            printf(" ");
        }
        for (k = 0; k < 2 * i + 1; k++)
        {
            printf("*");
        }
        printf("\n");
    }
    for (i = 0; i < 3; i++)
    {
        for (j = 0; j <= i; j++)
        {
            printf(" ");
        }
        for (k = 0; k < 5 - 2 * i; k++)
        {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}

/**题目24：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和 */
int sumFraction()
{
    int i;
    double a = 2;
    double b = 1;
    double t;
    double sum = 0;
    for (i = 1; i <= 20; i++)
    {
        sum += a / b;
        t = a;
        a = a + b;
        b = t;
    }
    printf("前20项之和为：%lf\n", sum);
    return 0;
}

/**题目25：求1+2!+3!+...+20!的和 */
int sumFactorial()
{
    int i;
    int j;
    int sum = 0;
    int fac = 1;
    for (i = 1; i <= 20; i++)
    {
        fac = 1;
        for (j = 1; j <= i; j++)
        {
            fac *= j;
        }
        sum += fac;
    }
    printf("1+2!+3!+...+20!=%d\n", sum);
    return 0;
}

/**题目26：利用递归方法求5! */
int factorial(int n)
{
    if (n == 1)
    {
        return 1;
    }
    else
    {
        return n * factorial(n - 1);
    }
}

/**题目27：利用递归函数调用方式，将所输入的5个字符，以相反顺序打印出来。 */
int printReverse()
{
    char c;
    if (scanf("%c", &c) != 1)
    {
        printf("输入错误\n");
        return 0;
    }
    if (c != '\n')
    {
        printReverse();
        printf("%c", c);
    }
    return 0;
}

/**题目28：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。
 * 问第4个人岁数，他说比第3个人大2岁。
 * 问第三个人，又说比第2人大两岁。
 * 问第2个人，说比第一个人大两岁。
 * 最后问第一个人，他说是10岁。请问第五个人多大？ */
int age()
{
    int age = 10;
    int i;
    for (i = 1; i < 5; i++)
    {
        age += 2;
    }
    printf("第五个人%d岁\n", age);
    return 0;
}

/**题目29：给一个不多于5位的正整数，要求：
 * 一、求它是几位数，
 * 二、逆序打印出各位数字。 */
int reverse()
{
    int n;
    int i = 0;
    int a[5];
    printf("请输入一个正整数：");
    if (scanf("%d", &n) != 1)
    {
        printf("输入错误\n");
        return 0;
    }
    while (n)
    {
        a[i++] = n % 10;
        n /= 10;
    }
    printf("这是%d位数，逆序打印出各位数字：", i);
    for (n = 0; n < i; n++)
    {
        printf("%d", a[n]);
    }
    printf("\n");
    return 0;
}

/**题目30：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。 */
int palindrome()
{
    int n;
    int a[5];
    int i = 0;
    printf("请输入一个5位数：");
    if (scanf("%d", &n) != 1)
    {
        printf("输入错误\n");
        return 0;
    }
    while (n)
    {
        a[i++] = n % 10;
        n /= 10;
    }
    if (a[0] == a[4] && a[1] == a[3])
    {
        printf("是回文数\n");
    }
    else
    {
        printf("不是回文数\n");
    }
    return 0;
}

/**题目31：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。 */
int week()
{
    char c1, c2;
    printf("请输入星期几的第一个字母：");
    if (scanf("%c", &c1) != 1)
    {
        printf("输入错误\n");
        return 0;
    }
    if (c1 >= 'a' && c1 <= 'z')
    {
        c1 -= 32;
    }
    switch (c1)
    {
    case 'M':
        printf("Monday\n");
        break;
    case 'T':
        printf("请输入第二个字母：");
        if (scanf("%c", &c2) != 1)
        {
            printf("输入错误\n");
            return 0;
        }
        if (c2 >= 'a' && c2 <= 'z')
        {
            c2 -= 32;
        }
        if (c2 == 'U')
        {
            printf("Tuesday\n");
        }
        else if (c2 == 'H')
        {
            printf("Thursday\n");
        }
        else
        {
            printf("输入错误\n");
        }
        break;
    case 'W':
        printf("Wednesday\n");
        break;
    case 'F':
        printf("Friday\n");
        break;
    case 'S':
        printf("请输入第二个字母：");
        if (scanf("%c", &c2) != 1)
        {
            printf("输入错误\n");
            return 0;
        }
        if (c2 >= 'a' && c2 <= 'z')
        {
            c2 -= 32;
        }
        if (c2 == 'A')
        {
            printf("Saturday\n");
        }
        else if (c2 == 'U')
        {
            printf("Sunday\n");
        }
        else
        {
            printf("输入错误\n");
        }
        break;
    default:
        printf("输入错误\n");
    }
    return 0;
}

/**题目32：删除一个字符串中的指定字母，如：字符串 "aca"，删除其中的 a 字母。 */
int deleteChar()
{
    char str[100];
    char c;
    int i, j;
    printf("请输入一个字符串：");
    if (scanf("%s", str) != 1)
    {
        printf("输入错误\n");
        return 0;
    }
    printf("请输入要删除的字母：");
    if (scanf(" %c", &c) != 1)
    {
        printf("输入错误\n");
        return 0;
    }
    for (i = 0, j = 0; str[i] != '\0'; i++)
    {
        if (str[i] != c)
        {
            str[j++] = str[i];
        }
    }
    str[j] = '\0';
    printf("删除后的字符串：%s\n", str);
    return 0;
}

/**题目33：判断一个数字是否为质数。*/
int isPrime()
{
    int n;
    int i;
    printf("请输入一个数字：");
    if (scanf("%d", &n) != 1)
    {
        printf("输入错误\n");
        return 0;
    }
    for (i = 2; i * i <= n; i++)
    {
        if (n % i == 0)
        {
            printf("不是质数\n");
            return 0;
        }
    }
    printf("是质数\n");
    return 0;
}

/**题目24：练习函数调用。*/
void hello_world(void) { printf("Hello, world!\n"); }
void three_hellos(void)
{
    int counter;
    for (counter = 1; counter <= 3; counter++)
        hello_world(); /*调用此函数*/
}

/**题目35：字符串反转。*/
void reverseString(char *str)
{
    if (*str)
    {
        reverseString(str + 1);
        printf("%c", *str);
    }
}

/**题目36：求100之内的素数。 */
int prime100()
{
    int i, j;
    for (i = 2; i <= 100; i++)
    {
        for (j = 2; j < i; j++)
        {
            if (i % j == 0)
            {
                break;
            }
        }
        if (j == i)
        {
            printf("%d ", i);
        }
    }
    printf("\n");
    return 0;
}

/**题目37：对10个数进行排序。*/
int sort()
{
    int a[10];
    int i, j, t;
    printf("请输入10个数：");
    for (i = 0; i < 10; i++)
    {
        if (scanf("%d", &a[i]) != 1)
        {
            printf("输入错误\n");
            return 0;
        }
    }
    for (i = 0; i < 9; i++)
    {
        for (j = 0; j < 9 - i; j++)
        {
            if (a[j] > a[j + 1])
            {
                t = a[j];
                a[j] = a[j + 1];
                a[j + 1] = t;
            }
        }
    }
    printf("排序后：");
    for (i = 0; i < 10; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");
    return 0;
}

/**题目38：求一个3*3矩阵对角线元素之和 */
int sumDiagonal()
{
    int a[3][3];
    int i, j;
    int sum = 0;
    printf("请输入一个3*3矩阵：");
    for (i = 0; i < 3; i++)
    {
        for (j = 0; j < 3; j++)
        {
            if (scanf("%d", &a[i][j]) != 1)
            {
                printf("输入错误\n");
                return 0;
            }
        }
    }
    for (i = 0; i < 3; i++)
    {
        sum += a[i][i];
    }
    printf("对角线元素之和：%d\n", sum);
    return 0;
}

/**题目39：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。 */
int insert()
{
    int a[11] = {1, 4, 6, 9, 13, 16, 19, 28, 40, 100};
    int n;
    int i, j;
    printf("原始数组：");
    for (i = 0; i < 10; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");
    printf("请输入一个数：");
    if (scanf("%d", &n) != 1)
    {
        printf("输入错误\n");
        return 0;
    }
    for (i = 0; i < 10; i++)
    {
        if (n < a[i])
        {
            for (j = 9; j >= i; j--)
            {
                a[j + 1] = a[j];
            }
            a[i] = n;
            break;
        }
    }
    printf("插入后的数组：");
    for (i = 0; i < 11; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n");
    return 0;
}

/**题目40：将一个数组逆序输出。 */
int reverseArray()
{
    int a[10];
    int i;
    printf("请输入10个数：");
    for (i = 0; i < 10; i++)
    {
        if (scanf("%d", &a[i]) != 1)
        {
            printf("输入错误\n");
            return 0;
        }
    }
    printf("逆序输出：");
    for (i = 9; i >= 0; i--)
    {
        printf("%d ", a[i]);
    }
    printf("\n");
    return 0;
}
