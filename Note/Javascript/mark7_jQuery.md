## 1. 介绍 

jQuery是JavaScript的工具库，对原生JavaScript中的DOM操作、事件处理、数据处理等进行封装,提供更便捷的方法。

>   要我们用更少的代码完成我们的js操作 类似于python当中的模块
>   jQuery有很多个版本.不一定越新越好.可能有的时候用到的都是旧版本的代码,这时候可以不引入新版本

## 2. 引入

先引入jquery文件，才能使用jquery语法

https://www.bootcdn.cn/
https://jquery.cuishifeng.cn/

## 3. 工厂函数 - $()

"$()"函数用于获取元素节点，创建元素节点或将原生JavaScript对象转换为jquery对象,返回 jQuery 对象。jQuery对象实际是一个类数组对象，包含了一系列 jQuery操作的方法。

原生JavaScript对象与jQuery对象的属性和方法不能混用。可以根据需要，互相转换 :

-   原生JavaScript转换jQuery对象

    >   $(原生对象)，返回 jQuery 对象

-   jQuery对象转换原生JavaScript对象

    >   方法一 : 根据下标取元素,取出即为原生对象
    >   var div = $("div")[0];
    >
    >   方法二 : 使用jQuery的get(index)取原生对象
    >   var div2 = $("div").get(0);



## 4. jQuery获取元素

-   基础选择器

    ```js
    标签选择器：$("div")
    ID 选择器：$("#d1")
    类选择器：$(".c1")
    群组选择器：$("body,p,h1")
    ```

-   层级选择器

    ```js
    后代选择器： $("div .c1")
    子代选择器： $("div>span")
    相邻兄弟选择器： $("h1+p")  匹配选择器1后的第一个兄弟元素,同时要求兄弟元素满足选择器2
    通用兄弟选择器： $("h1~h2") 匹配选择器1后所有满足选择器2的兄弟元素
    ```

-   过滤选择器，需要结合其他选择器使用。

    ```js
    :first
      匹配第一个元素 例:$("p:first")
    :last
      匹配最后一个元素 例:$("p:last")
    :odd
      匹配奇数下标对应的元素
    :even
      匹配偶数下标对应的元素
    :eq(index)
      匹配指定下标的元素
    :lt(index)
      匹配下标小于index的元素
    :gt(index)
      匹配下标大于index的元素
    :not(选择器)
      否定筛选,除()中选择器外,其他元素
    ```

    

## 5. 操作元素内容

```js
html() //设置或读取标签内容,等价于原生innerHTML,可识别标签语法
text() //设置或读取标签内容,等价于innerText,不能识别标签
val()  //设置或读取表单元素的值,等价于原生value属性
```



## 6. 操作标签属性

-   attr("attrName","value")

    >   设置或读取标签属性

-   prop("attrName","value")

    >   设置或读取标签属性
    >   注意 :在设置或读取元素属性时,attr()和prop()基本没有区别;但是在读取或设置表单元素(按钮)的选中状态时,必须用prop()方法,attr()不会监听按钮选中状态的改变,只看标签属性checked是否书写

-   removeAttr("attrName")

    >   移除指定属性



## 7. 操作标签样式

1.  为元素添加id/class属性,对应选择器样式
2.  针对类选择器,提供操作class属性值的方法

```js
addClass("className")	//添加指定的类名
removeClass("className")//移除指定的类型,如果参数省略,表示清空class属性值
toggleClass("className")//结合用户行为,实现动态切换类名.如果当前元素存在指定类名,则移除;不存在则添加
```

3.  操作行内样式

```js
css("属性名","属性值")  //设置行内样式
```

## 8. 元素的创建,添加,删除

1.  创建：使用$("标签语法")，返回创建好的元素

```javascript
var div = $("<div></div>");	//创建元素
div.html("动态创建").attr("id","d1").css("color","red"); //链式调用，设置内容和属性
var h1 = $("<h1 id='d1'>一级标题</h1>");	//创建的同时设置内容，属性和样式
```

2.  作为子元素添加

```javascript
$obj.append(newObj);	//在$obj的末尾添加子元素newObj
$obj.prepend(newObj);	//作为第一个子元素添加至$obj中
```

3.  作为兄弟元素添加

```javascript
$obj.after(newObj);		//在$obj的后面添加兄弟元素
$obj.before(newObj);	//在$obj的前面添加兄弟元素
```

4.  移除元素 

```javascript
$obj.remove();	//移除$obj
```



## 9. 动画效果

1.  显示和隐藏

    ```javascript
    show(speed,callback)/hide(speed,callback)
    ```

    -   speed可选。规定元素从隐藏到完全可见的速度。默认为 "0"。
    -   callback 可选。show 函数执行完之后，要执行的函数

2.  下拉和上推效果，显示隐藏的被选元素（ **只针对块元素** ）

    ```javascript
    slideDown(speed,callback)/slideUp(speed,callback)
    ```

3.  通过使用淡隐淡现方式显示效果，显示隐藏的被选元素

    ```javascript
    fadeOut(speed,callback)/fadeIn(speed,callback)
    ```



## 10. 数据与对象遍历

1.  $(selector).each() 方法规定为每个匹配元素规定运行的函数

    ```javascript
    $(selector).each(function(index,element){})
    ```

    必需。为每个匹配元素规定运行的函数。

    -   *index* - 选择器的 index 位置
    -   element - 当前的元素

2.  $.each()函数是框架提供的一个工具类函数，通过它，你可以遍历对象、数组的属性值并进行处理

    ```javascript
    $.each(Object, function(index, data){});
    ```

    必需。为每个匹配元素规定运行的函数。

    -   *index* - 选择器的 index 位置
    -   data- 当前的数据
