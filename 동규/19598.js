function solution(N, time) {
  let cnt = 0;
  let max = 0;
  const startT = time.map((t) => {
    return { time: +t.start, isStart: 1 };
  });
  const endT = time.map((t) => {
    return { time: +t.end, isStart: -1 };
  });
  const sortedTime = [...startT, ...endT].sort((a, b) =>
    a.time === b.time ? a.isStart - b.isStart : a.time - b.time
  );

  sortedTime.forEach((t) => {
    cnt = t.isStart === 1 ? cnt + 1 : cnt - 1;
    if (max <= cnt) max = cnt;
  });
  return max;
}

const input = [];
require("readline")
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    input.push(line);
  })
  .on("close", () => {
    const N = Number(input[0]);
    const time = input.slice(1, N + 1).map((el) => {
      return { start: el.split(" ")[0], end: el.split(" ")[1] };
    });
    console.log(solution(N, time));
    process.exit();
  });
