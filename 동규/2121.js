const input = [];
const graph = [];

const readline = require("readline");
readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    input.push(line);
  })
  .on("close", () => {
    const n = Number(input[0]);
    const [a, b] = input[1].split(" ").map(Number);

    for (let i = 0; i < n; i++) {
      const [x, y] = input[i + 2].split(" ").map(Number);
      graph.push([x, y]);
    }

    let cnt = 0;

    graph.sort((a, b) => graph[a] - graph[b]);

    // 이분탐색 필요

    for (let i = 0; i < n; i++) {
      const x = graph[i][0];
      const y = graph[i][1];
      if (
        graph.find((el) => el[0] === x + a && el[1] === y) &&
        graph.find((el) => el[0] === x && el[1] === y + b) &&
        graph.find((el) => el[0] === x + a && el[1] === y + b)
      ) {
        cnt++;
      }
    }

    console.log(cnt);
  });
