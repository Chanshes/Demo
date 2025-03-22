# Doxygen常用注释命令

@exception <exception-object> {exception description} 对一个异常对象进行注释。

@warning {warning message } 一些需要注意的事情

@todo { things to be done } 对将要做的事情进行注释，链接到所有TODO 汇总的TODO 列表

@bug 缺陷，链接到所有缺陷汇总的缺陷列表

@see {comment with reference to other items } 一段包含其他部分引用的注释，中间包含对其他代码项的名称，自动产生对其的引用链接。

@relates <name> 通常用做把非成员函数的注释文档包含在类的说明文档中。

@since {text} 通常用来说明从什么版本、时间写此部分代码。

@deprecated

@pre { description of the precondition } 用来说明代码项的前提条件。

@post { description of the postcondition } 用来说明代码项之后的使用条件。

@code 在注释中开始说明一段代码，直到@endcode命令。

@endcode 注释中代码段的结束。

@code .. @endcode 包含一段代码

@addtogroup 添加到一个组。

@brief 概要信息

@deprecated 已废弃函数

@details  详细描述

@note 开始一个段落，用来描述一些注意事项

@par 开始一个段落，段落名称描述由你自己指定

@param 标记一个参数的意义

@fn 函数说明

@ingroup 加入到一个组

@return 描述返回意义

@retval 描述返回值意义

@include 包含文件

@var、@enum、@struct、@class 对变量、美剧、结构体、类等进行标注
