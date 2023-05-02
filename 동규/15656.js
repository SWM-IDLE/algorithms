let n, m;
let input = [];
let temp = [];
let result = [];

function recurNum(k, n, m, s) {
  if (k === m) {
    result.push(temp.join(" "));
    return;
  }
  for (let i = s; i < n; i++) {
    temp[k] = input[i];
    recurNum(k + 1, n, m, s);
  }
}

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  [n, m] = input[0].split(" ").map(Number);
  input = input[1]
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);

  recurNum(0, n, m, 0);
  console.log(result.join("\n"));
});
