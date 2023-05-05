/*
    -1 -2 -3 -4
    5 6 7 8
    9 10 11 12
    -13 -14 -15 -16

    => arr[0][1] ~ arr[2][3] 3x3 정사각형이 최댓값 45를 가짐
    => N이 4일때, 1x1, 2x2, 3x3, 4x4 총 30개의 정사각형
    => 초기 정답은 음수로 설정해야 음수에 대해서도 저장
*/

function solution(n, arr, sum) {
  let ans = Number.MIN_SAFE_INTEGER;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + arr[i][j];
    }
  }

  for (let i = 1; i < n + 1; i++) {
    for (let j = 0; j < n - i + 1; j++) {
      for (let k = 0; k < n - i + 1; k++) {
        let max = sum[j + i][k + i] - sum[j + i][k] - sum[j][k + i] + sum[j][k];
        ans = Math.max(ans, max);
      }
    }
  }

  return console.log(ans);
}

const fs = require("fs");
const input = fs.readFileSync("example.txt").toString().split("\n"); // /dev/stdin
const n = Number(input[0]);
const arr = input.slice(1, 1 + n).map((el) => el.split(" ").map(Number));
const sum = Array.from(Array(n + 1), () => Array(n + 1).fill(0));

solution(n, arr, sum);
