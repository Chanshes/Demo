/* ? 位置该怎样写才能输出true
    var a = ?;
    console.log(
        a == 1 &&
        a == 2 &&
        a == 3
        );
*/

var a = {
    n : 1,
    valueOf: function(){
        return this.n++;
    }
}

console.log(
    a == 1 &&
    a == 2 &&
    a == 3
    );