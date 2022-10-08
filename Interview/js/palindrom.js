/**
 * 验证回文串
 * 回文串：一个字符串忽略大小写和非字母数字，正着读和反着读都是一样的
 * 例如： A man a plan a canal panama
 */
var isPalindrome = function(s) {
   const isValid = (c)  => (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
   let i = 0, j = s.length - 1;
   while(j>=1){
        const left = s[i].toLowerCase(), 
        right = s[j].toLowerCase();
        if(!isValid(left)){
            i++;
        } else if (!isValid(right)){
            j--;
        } else if(left == right){
            i++;
            j--;
        } else {
            return false;
        }
   }
   return true;
};

console.log(isPalindrome('passap'));
console.log(isPalindrome('re er'));
console.log(isPalindrome('it ti t'));
console.log(isPalindrome('pass pass'));