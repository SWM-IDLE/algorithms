// 테스트할때는 txt, 백준은 ./dev/stdin 경로에서 입출력
const fs = require("fs");
const input = fs.readFileSync("example.txt").toString().trim();

function setPalindrome(word) {
  let words = new Map();

  // Map에 알파벳 별 갯수 삽입
  for (let i = 0; i < word.length; i++) {
    const alp = word[i];
    if (words.has(alp)) {
      words.set(alp, words.get(alp) + 1);
    } else {
      words.set(alp, 1);
    }
  }

  // 알파벳 순으로 정렬
  words = Object.values([...words]).sort((a, b) => a[0].localeCompare(b[0]));

  let oddChar = "";
  let oddCount = 0;

  for (const [key, value] of words) {
    if (value % 2) {
      oddChar = key;
      oddCount++;
    }
  }

  // 팰린드롬을 만들 수 없으면 리턴
  if (oddCount > 1) return "I'm Sorry Hansoo";

  let leftText = "";

  for (let [key, value] of words) {
    let temp = "";
    for (let i = 0; i < parseInt(value / 2); i++) {
      temp += key;
    }
    leftText += temp;
  }

  // 왼쪽 문자열을 뒤집어서 저장
  const rightText = leftText.split("").reverse().join("");

  // 1개의 홀수 알파벳이 있으면 가운데 삽입
  return oddCount === 1 ? leftText + oddChar + rightText : leftText + rightText;
}

console.log(setPalindrome(input));
