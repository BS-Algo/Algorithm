const axios = require("axios");
const fs = require("fs");


const today = new Date().toISOString().split("T")[0];


const GITHUB_TOKEN = process.env.GITHUB_TOKEN; // GitHub Personal Access Token
const REPO_OWNER = "BS-BOJ";
const REPO_NAME = "Algorithm";


(async () => {
  try {
    const res = await axios.get(
      `https://api.github.com/repos/${REPO_OWNER}/${REPO_NAME}/commits`,
      {
        headers: { Authorization: `token ${GITHUB_TOKEN}` },
      }
    );

    const commitsToday = res.data.filter((commit) =>
      commit.commit.author.date.startsWith(today)
    );

    // 참여자별 출석 현황 생성
    const users = ["sanggon", "soyoung"]; // 참여자 아이디 리스트
    const attendance = users.map((user) => {
      const isPresent = commitsToday.some(
        (commit) => commit.author && commit.author.login === user
      );
      return `| ${today} | ${user} | ${isPresent ? "✅" : "❌"} |`;
    });

    // README.md 파일 업데이트
    const readmeContent = `
# 알고리즘 스터디 출석 체크

| 날짜        | 사용자명   | 출석 여부 |
| ----------- | -------- | -------- |
${attendance.join("\n")}
    `;

    fs.writeFileSync("README.md", readmeContent, "utf8");
    console.log("Attendance updated successfully!");
  } catch (error) {
    console.error("Error fetching commits:", error.message);
  }
})();
