const fs = require("fs");
const path = process.platform === "linux" ? "/dev/stdin" : "example.txt";
const input = fs.readFileSync(path).toString().trim().split("\n");

const N = +input[0];
const idle = input.slice(1, N + 1).map(Number);
const dp = Array(N + 1).fill(1); // 1 이상

function dpLis() {
  let max = Number.MIN_SAFE_INTEGER;

  for (let i = 1; i < N; i++) {
    for (let j = 0; j < i; j++) {
      if (idle[j] < idle[i]) {
        dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }
    max = Math.max(max, dp[i]);
  }

  return max;
}

console.log(N - dpLis());
