//输出多少？
console.log(++[[]][+[]] + [+[]]);
/* 
++[[]][+[]]
    //[].toString() -> ''
    //+'' -> 0
    //[[]].toString() -> 0
    //++[[]][0]
  +
[+[]]
    //+[] -> '0'
    //[+[]].toString() -> '0'
*/
// = 1 + '0'
// console.log(++[[]][+[]] + [+[]]) -> 10