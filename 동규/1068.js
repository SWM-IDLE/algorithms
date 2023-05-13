const fs = require("fs");
const path = process.platform === "linux" ? "/dev/stdin" : "example.txt";
const input = fs.readFileSync(path).toString().trim().split("\n");

const N = +input[0];
const nodes = input[1].split(" ").map(Number);
const delNode = +input[2];

let rootNode;
let tree = [];

// -1은 루트노드, 트리에 자식노드 기록
nodes.map((node, idx) => {
  if (node === -1) {
    rootNode = idx;
    return;
  }
  if (!tree[node]) {
    tree[node] = [];
  }
  tree[node].push(idx);
});

let cnt = 0;

function dfs(node) {
  // 루트노드를 삭제할 때
  if (delNode === rootNode) return 0;
  // 리프노드일 때
  if (!tree[node]) {
    cnt += 1;
    return;
  }

  tree[node].map((n) => {
    // 리프노드일 때
    if (tree[node].length === 1) {
      cnt += 1;
      return;
    }
    // 노드를 삭제할 때
    if (n === delNode) {
      return;
    }
    dfs(n);
  });

  return cnt;
}

console.log(dfs(rootNode));
