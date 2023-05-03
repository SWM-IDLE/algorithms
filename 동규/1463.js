// X가 3으로 나누어 떨어지면, 3으로 나눈다. -> X % 3 == 0 : X / 3 + 1
// X가 2로 나누어 떨어지면, 2로 나눈다. -> X % 2 == 0 : X / 2 + 1
// 1을 뺀다.

const fs = require("fs");
const input = fs.readFileSync("example.txt");

const num = Number(input);
const dp = Array(num + 1).fill(0);

for (let i = 2; i <= num; i++) {
  dp[i] = dp[i - 1] + 1;
  if (i % 2 === 0) {
    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
  }
  if (i % 3 === 0) {
    dp[i] = Math.min(dp[i], dp[i / 3] + 1);
  }
}

console.log(dp[num]);
