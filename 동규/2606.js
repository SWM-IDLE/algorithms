function solution(n, pair_num) {
  let cnt = 0;
  const graph = [...Array(n + 1)].map(() => []);
  const visited = [...Array(n + 1)].fill(0);

  for (let i = 0; i < pair_num; i++) {
    const a = Number(input[i + 2].split(" ")[0]);
    const b = Number(input[i + 2].split(" ")[1]);
    graph[a].push(b);
    graph[b].push(a);
  }

  function dfs(start) {
    for (let k of graph[start]) {
      if (!visited[k]) {
        visited[k] = 1;
        cnt++;
        dfs(k);
      }
    }
  }

  dfs(1);

  return cnt - 1;
}

let input = [];

const readline = require("readline");
readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    input.push(line);
  })
  .on("close", () => {
    const n = Number(input[0]);
    const pair_num = Number(input[1]);

    console.log(solution(n, pair_num));
  });
