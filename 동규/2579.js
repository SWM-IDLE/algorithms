const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = Number(input[0]);
const score = input.slice(1, 1 + N).map(Number);

const dp = [];
dp[0] = score[0];
dp[1] = score[0] + score[1];
dp[2] = Math.max(score[0], score[1]) + score[2];
for (let i = 3; i < N; i++) {
  dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
}

console.log(dp[N - 1]);
