// N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
// N개의 자연수 중에서 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다.

const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const [n, m] = input[0].split(" ").map(Number);
const list = input[1]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

let temp = [];
let result = [];
let check = Array(9).fill(false);

function recurNum(k, n, m, s) {
  if (k === m) {
    result.push(temp.join(" "));
    return;
  }
  for (let i = s; i < n; i++) {
    if (!check[i]) {
      check[k] = true;
      temp[k] = list[i];
      recurNum(k + 1, n, m, i + 1);
      check[k] = false;
    }
  }
}

recurNum(0, n, m, 0);
console.log(result.join("\n"));
