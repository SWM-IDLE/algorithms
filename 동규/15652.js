let n, m;
let input = [];
let temp = [];
let result = "";

function recurNum(k, s) {
  if (k === m) {
    ans = temp.join(" ");
    result += ans + "\n";
    return;
  }
  for (let i = s; i < n; i++) {
    temp.push(i + 1);
    recurNum(k + 1, i);
    temp.pop();
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

  recurNum(0, 0);
  console.log(result);
});
