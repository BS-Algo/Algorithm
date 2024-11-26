import json
import os
from datetime import datetime, timedelta

# 디렉토리 이름으로 멤버 가져오기
def get_members(directory):
    return [d for d in os.listdir(directory) if os.path.isdir(os.path.join(directory, d)) and d != "images"]

# 커밋 데이터 분석
def analyze_commits(commits, members):
    # 오늘 날짜와 1주일 전 날짜 계산
    today = datetime.utcnow().date()
    start_date = today - timedelta(days=6)
    
    attendance = {member: ["⬜" for _ in range(7)] for member in members}

    for commit in commits:
        try:
            author = commit['commit']['author']['name']
            date_str = commit['commit']['author']['date'][:10]  # 날짜 부분만 추출
            commit_date = datetime.strptime(date_str, "%Y-%m-%d").date()

            if start_date <= commit_date <= today and author in members:
                index = (commit_date - start_date).days
                attendance[author][index] = "🟩"
        except KeyError:
            continue

    return attendance

# README 파일 업데이트
def update_readme(attendance):
    # 기존 README 읽기
    with open("README.md", "r", encoding="utf-8") as file:
        lines = file.readlines()

    # Attendance와 Rules 섹션 구분
    attendance_start = None
    rules_start = None
    for i, line in enumerate(lines):
        if "<!-- Attendance Section -->" in line:
            attendance_start = i
        if "<!-- Rules Section -->" in line:
            rules_start = i
            break

    # Attendance 내용 생성
    attendance_content = ["<!-- Attendance Section -->\n", "# Attendance Check\n\n"]
    for member, record in attendance.items():
        attendance_content.append(f"**{member}**: {' '.join(record)}\n")

    # 새로운 README 생성
    new_lines = attendance_content + ["\n"] + lines[rules_start:]
    with open("README.md", "w", encoding="utf-8") as file:
        file.writelines(new_lines)

# 메인 함수
def main():
    members = get_members(".")  # 현재 디렉토리에서 멤버 이름 가져오기

    # 커밋 데이터 읽기
    try:
        with open("commit_history.json", "r", encoding="utf-8") as file:
            commits = json.load(file)
    except FileNotFoundError:
        print("Error: commit_history.json 파일을 찾을 수 없습니다.")
        return

    # 커밋 데이터 분석
    attendance = analyze_commits(commits, members)

    # README 업데이트
    update_readme(attendance)
    print("README.md 파일이 성공적으로 업데이트되었습니다.")

if __name__ == "__main__":
    main()
