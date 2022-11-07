/*
    将下面的代码转换为普通构造函数的写法
    考察对类的掌握
*/

class Example { 
    constructor(name) {
        this.name = name;
    }
    func() {
        console.log(this.name)
    }
}