import json
import os
from datetime import datetime, timedelta

# 멤버 이름을 수동으로 정의
MEMBERS = ["jinsongLee", "junWhang", "minjaeYoon", "heongyuKim", "sanggoncha", "jaeyeongPark", "minjaeYun", "eunseopKim"]

# 커밋 데이터 분석
def analyze_commits(commits):
    # 오늘 날짜와 2주 전 날짜 계산
    today = datetime.utcnow().date()
    start_date = today - timedelta(days=13)

    # 출석표 초기화 (2주 동안의 출석 체크)
    attendance = {member: ["⬜" for _ in range(14)] for member in MEMBERS}

    for commit in commits:
        try:
            # 작성자 및 날짜 정보 추출
            author = commit['commit']['author']['name']
            date_str = commit['commit']['author']['date'][:10]  # 날짜 부분만 추출
            commit_date = datetime.strptime(date_str, "%Y-%m-%d").date()

            # 파일 경로에서 멤버 폴더가 포함되어 있는지 확인
            if "files" in commit:
                for file in commit["files"]:
                    for member in MEMBERS:
                        if f"{member}/" in file['filename']:  # 파일 경로에 멤버 이름 포함 여부 확인
                            if start_date <= commit_date <= today:
                                index = (commit_date - start_date).days
                                attendance[member][index] = "🟩"
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

    # 날짜 생성 (2주치)
    today = datetime.utcnow().date()
    dates = [(today - timedelta(days=i)).strftime("%Y-%m-%d") for i in range(13, -1, -1)]
    months = [date.split("-")[1] for date in dates]
    unique_months = list(set(months))

    # Attendance 내용 생성
    attendance_content = ["<!-- Attendance Section -->\n", "# Attendance Check\n\n"]
    attendance_content.append(f"최근 2주 출석 현황:\n\n")

    # 월 표시
    month_row = "| " + " | ".join([unique_months[0] if m == unique_months[0] else " " for m in months]) + " |\n"
    attendance_content.append(month_row)

    # 요일 헤더 생성
    day_row = "| " + " | ".join([datetime.strptime(date, "%Y-%m-%d").strftime("%a") for date in dates]) + " |\n"
    attendance_content.append(day_row)
    attendance_content.append("|" + " --- |" * len(dates) + "\n")

    # 멤버별 출석 현황 추가
    for member, record in attendance.items():
        attendance_content.append(f"| {member} | " + " | ".join(record) + " |\n")

    # 새로운 README 생성
    new_lines = attendance_content + ["\n"] + lines[rules_start:]
    with open("README.md", "w", encoding="utf-8") as file:
        file.writelines(new_lines)

# 메인 함수
def main():
    # 커밋 데이터 읽기
    try:
        with open("commit_history.json", "r", encoding="utf-8") as file:
            commits = json.load(file)
    except FileNotFoundError:
        print("Error: commit_history.json 파일을 찾을 수 없습니다.")
        return

    # 커밋 데이터 분석
    attendance = analyze_commits(commits)

    # README 업데이트
    update_readme(attendance)
    print("README.md 파일이 성공적으로 업데이트되었습니다.")

if __name__ == "__main__":
    main()
