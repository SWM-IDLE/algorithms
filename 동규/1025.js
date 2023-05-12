const fs = require("fs");
const path = process.platform === "linux" ? "/dev/stdin" : "example.txt";
const input = fs.readFileSync(path).toString().trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const numMap = input.slice(1, N + 1).map((el) => el.split(""));

function check(num) {
  return Number(num) === Math.pow(Math.floor(Math.sqrt(Number(num))), 2)
    ? true
    : false;
}

let answer = -1;

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    for (let k = -N; k < N; k++) {
      for (let l = -M; l < M; l++) {
        let temp = "";
        let tmpA = i;
        let tmpB = j;

        while (1) {
          if (k === 0 && l === 0) break;
          if (tmpA < 0 || tmpB < 0 || tmpA >= N || tmpB >= M) break;
          temp += numMap[tmpA][tmpB];

          if (check(temp)) {
            answer = Math.max(answer, Number(temp));
          }

          tmpA += k;
          tmpB += l;
        }
      }
    }
  }
}

console.log(answer);
