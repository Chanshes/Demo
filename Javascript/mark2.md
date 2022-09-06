## 流程控制语句
    程序的三种流程:
        1.顺序执行:程序代码由上往下依次执行
        2.选择执行:分支语句通过一个个条件走向不同的分支
        3.循环执行:判断条件是否满足,从而把一段代码重复执行n次
    选择执行和循环执行都会涉及到条件判断,这里判断基于boolean类型

## 代码块权限
    在JavaScript中代码块权限是通过大括号表示
    加缩进只是为了看起来好看
    A{
        '内容'
    }
    如果只有一句代码.可以不用加大括号.但是规范起见,最好还是加
        for(let j=1;j<=10;j++)
			    document.write('❤')

		if(判断条件)
				执行语句

## 分支语句(if)
    if语句的作用为'条件判断' --> 根据判断结果执行对应的语句
        if: 如果
        else: 否则
        else if: 或者

    三种分支情况:
        1.单分支:满足条件就执行if里的代码,不满足就无事发生
        2.双分支:如果满足if条件,就执行if里面的代码,否则执行else里面的代码
        3.多分支:逐个判断是否满足if,else if里的条件.满足就执行对应代码.都不满足就执行else代码

    1.单分支语句(如果):
        如果满足if条件,就执行if里面的语句,不满足就无事发生
        语法格式:
            if(判断条件){
                执行语句
            }
        
    2.双分支语句(如果,否则):
        如果满足if条件,就执行if里面的代码,否则执行else里面的代码
        语法格式:
            if{
                执行语句
            }else{
                执行语句
            }

    3.多分支语句(如果,或者,否则):
        逐个判断是否满足if条件,不满足就执行对应else if里面的代码,都不满足执行else里的代码
        语法格式:
            if(判断条件){
                执行语句
            }else if{
                执行语句
            }else{
                执行语句
            }
    
**tips:**

	1.一组分支里面.if和else只能有一个.else if可以有多个
	2.同一件事最好用一组分支,不要用多个if.
	3.在判断中.有值即为真,无值即为假
		0 0.0 null undefined '' 都没有值.视作false

## 选择分支语句(switch)
    switch本质也是进行条件判断.但是它是基于同一件事有多个不同分支时的判断.说白了,switch就是一个选项操作
		case --> 选择,选项
		break --> 结束
		default --> 默认值.如果case都不满足就执行default.类似else

    语法:
        switch(表达式){
            case 情况1:
                执行语句
            break
            case 情况2:
                执行语句
            break
            case 情况3:
                执行语句
            break
            case 情况4:
				执行语句
			break
            default:
                执行语句
            break
        }

    用switch时.括号里放的是表达式.对于数据的要求更加精准.所以不会进行隐式转换
	
	switch跟if的区别主要是体现在: 如果你要进行的判断,是一串连续的,有关联的数据.用switch看着就更加清晰.

	switch的穿透机制: 当你写了case,但没写break的时候,语句会一直执行,直到遇到了break为止.有时可以利用这个机制.判断多个内容

## while与do while循环
    while:
        循环的本质目的就是为了减少代码量和提高运行效率
	    循环语句也会涉及到条件判断.循环条件为真就执行循环,为假就结束循环

	    生活中循环: 单曲循环  跑步  抄作业

	    语法格式:
		    while(循环条件){
			    执行语句
			    更新语句
		    }

		    let num = 1
            while(num<=100){
                console.log(`我是祝伟.这是我抄书的第${num}遍`)
                num++
            }

	    !!! 由于js是运行在浏览器里的.如果写死循环分分钟可能会把浏览器卡死卡崩溃.不要作死

    do while:
        语法格式:
	        do{
		        执行语句
	        }while(循环条件)

	    用法和while类似. do while的执行流程是.先运行一遍执行语句.再判断条件是否满足,是否继续循环.
	    do while --> 会先执行一次,再进行循环判断 -- 登录
	    while循环有可能一次循环都不会执行,do while至少会有一次

## break与continue
	break心软的老六
		循环遇到break时.会直接结束

	  let num = 1
        while(num<=100){
            console.log(`我是老六.这是我抄书的第${num}遍`)
            num++
            if(num == 70){
                console.log('行了行了.不要抄了.')
                break
            }
        }
		
	continue狡猾的老六
		循环遇到continue时.会跳过本次循环
		 let num = 0
        while(num<100){
            num++
            if(num == 70 || num == 40 || num == 77 || num==66 || num==14 ){
                continue // 跳过本次循环
            }
            console.log(`我是老六.这是我抄书的第${num}遍`)
        }

## for循环 
	for循环迭代循环 --> 在循环次数已知的情况下.用for循环会更高效.

	语法格式:
		for(初始化变量;循环条件;更新操作){
			执行语句
		}

		for(let i=1;i<=100;i++){
			console.log(i)
		}
		
		for(let i=1;i<=10;i++){
            for(let j=1;j<=10;j++){
			    document.write('❤')
            }
            document.write('<br>')
		}
	