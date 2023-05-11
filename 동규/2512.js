/* 
    2512번: 예산
    지방의 수 N, 지방예산 요청 N개 만큼, 총 예산 M
*/
const fs = require("fs");
const input = fs.readFileSync("example.txt").toString().trim().split("\n");
const [N, money, M] = [+input[0], input[1].split(" ").map(Number), +input[2]];

money.sort((a, b) => a - b);

let left = 0;
let right = money[N - 1];
let result = 0;

while (money) {
  const mid = Math.floor((left + right) / 2);
  let temp = 0;

  for (const k of money) {
    if (k > mid) temp += mid;
    else temp += k;
  }

  // 총 예산이 가능 예산의 합산보다 크거나 같을때 루프
  if (M >= temp) {
    if (left > right) {
      result = mid;
      break;
    }
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(result);
