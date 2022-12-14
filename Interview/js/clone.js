/**
 * 深度克隆
 * @param {any} value 任意类型数据
 */
function deepClone(value) {
    // 非原始值的情况  (数组)
    if(Array.isArray(value)){
        var clone = [];
        for(var i = 0; i<value.length; i++){
            clone[i] = deepClone(value[i]);
        }
        return clone;
    }
    if(typeof value === 'object' && value !== null){
        var clone = {};
        for(var key in value) {
            clone[key] = deepClone(value[key]);
        }
        return clone
    }

    return value;
}

var o1 = [1, 2, { a: 1, b: [3, 2, 1]}];
var o2 = deepClone(o1);
var o3 = o1;
console.log('1' === 1)
console.log(deepClone(1))
console.log(o2);
console.log(o2 === o1);
console.log(o2[2] === o1[2]);
console.log(o1 == o3);
