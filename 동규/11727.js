const fs = require("fs");
const input = fs.readFileSync("example.txt");

const num = Number(input);
const dp = Array(1000).fill(0);

dp[0] = 1;
dp[1] = 1;

for (let i = 2; i < num + 1; i++) {
  dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
}

console.log(dp[num]);
