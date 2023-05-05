/* 
    arr = [1, 2, 3, 5, 7, 9 , 10, 11 ,12]
    ans = 1+12, 2+11, 3+10 => 3
    끝과 끝 더하고, 오른쪽 한칸 옮기고, 왼쪽 한칸 옮기고 ...
*/

function solution(n, x, arr) {
  let start = 0;
  let end = n - 1;
  let ans = 0;

  while (start != end) {
    let calc = arr[start] + arr[end];
    if (calc == x) {
      ans += 1;
      start += 1;
    } else if (calc > x) {
      end -= 1;
    } else {
      start += 1;
    }
  }

  return console.log(ans);
}

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const n = Number(input[0]);
const list = input[1]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);
const x = Number(input[2]);
solution(n, x, list);
