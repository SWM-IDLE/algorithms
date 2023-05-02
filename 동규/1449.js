// 항승이는 길이가 L인 테이프를 무한개 가지고 있다.
// 항승이는 테이프를 이용해서 물을 막으려고 한다.
// 항승이는 항상 물을 막을 때, 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안 샌다고 생각한다.
// 물이 새는 곳의 위치와, 항승이가 가지고 있는 테이프의 길이 L이 주어졌을 때, 항승이가 필요한 테이프의 최소 개수를 구하는 프로그램을 작성하시오.
// 테이프를 자를 수 없고, 테이프를 겹쳐서 붙이는 것도 가능하다.

// const setTaping = (n, l, list) => {} 백준에서 Syntax 에러남..
function setTaping(n, l, list) {
  // 숫자 크기 순으로 정렬 (예제3)
  list.sort((a, b) => {
    return a - b;
  });

  let cnt = 0;
  let k = 0; // 빵꾸 매꾸고 넘어갈 위치

  for (let i = 0; i < n; i++) {
    if (k < list[i]) {
      cnt++;
      k = list[i] + l - 1; // 좌우로 0.5 간격
    }
  }

  return cnt;
}

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let n, l;
let list;
let input = [];

rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  [n, l] = input[0].split(" ").map((el) => parseInt(el));
  list = input[1].split(" ").map((el) => parseInt(el));
  console.log(setTaping(n, l, list));
  process.exit();
});
