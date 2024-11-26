import json
from datetime import datetime, timedelta
import re

# 이메일 기반으로 멤버 정의
MEMBERS = {
    "eunseopKim": "subway9852@gmail.com",
    "heongyuKim": "khg6436@naver.com",
    "jaeyeongPark": "pjy980526@naver.com",
    "jinsongLee": "annaring30@naver.com",
    "junWhang": "dmg05135@gmail.com",
    "minjaeYoon": "stylishy62@gmail.com",
    "sanggonCha": "yg9618@naver.com",
}

# 출석 데이터 초기화
def initialize_attendance():
    try:
        # README 파일 읽기
        with open("../README.md", "r", encoding="utf-8") as file:
            lines = file.readlines()
        
        # Attendance Section 추출
        attendance_start = None
        attendance_end = None
        for i, line in enumerate(lines):
            if "<!-- Attendance Section -->" in line:
                attendance_start = i
            if "<!-- Rules Section -->" in line:
                attendance_end = i
                break

        if attendance_start is None or attendance_end is None:
            raise ValueError("Attendance Section을 찾을 수 없습니다.")

        # 기존 출석 데이터 파싱
        attendance = {}
        for line in lines[attendance_start + 4 : attendance_end]:
            if "|" in line and not line.startswith("| ---"):
                parts = line.strip().split("|")
                if len(parts) > 2:
                    member = parts[1].strip()
                    attendance[member] = [cell.strip() for cell in parts[2:-1]]
        
        return attendance
    except FileNotFoundError:
        print("README.md 파일을 찾을 수 없습니다. 초기화된 데이터를 반환합니다.")
        return {member: ["⬜" for _ in range(14)] for member in MEMBERS}

# 커밋 데이터 분석 및 출석 업데이트
def analyze_commits(commits, attendance):
    # 오늘 날짜와 2주 전 날짜 계산
    today = datetime.utcnow().date()
    start_date = today - timedelta(days=13)

    for commit in commits:
        try:
            # 작성자 이메일 및 날짜 추출
            author_email = commit['commit']['author']['email']
            date_str = commit['commit']['author']['date'][:10]  # 날짜 부분만 추출
            commit_date = datetime.strptime(date_str, "%Y-%m-%d").date()

            # 출석 체크 (이메일 매칭)
            if start_date <= commit_date <= today:
                for member, email in MEMBERS.items():
                    if author_email == email:
                        index = (commit_date - start_date).days
                        # 이미 초록색(🟩)인 경우 건너뜀
                        if attendance[member][index] == "⬜":
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
    dates = [(today - timedelta(days=i)) for i in range(13, -1, -1)]
    months = [date.strftime("%b") for date in dates]
    days = [date.strftime("%a") for date in dates]

    # 월 표시 (중복 제거)
    month_row = "| " + " | ".join(
        [months[i] if i == 0 or months[i] != months[i - 1] else " " for i in range(len(months))]
    ) + " |\n"

    # 요일 헤더 생성
    day_row = "| " + " | ".join(days) + " |\n"
    separator_row = "|" + " --- |" * len(dates) + "\n"

    # Attendance 내용 생성
    attendance_content = ["<!-- Attendance Section -->\n", "# Attendance Check\n\n"]
    attendance_content.append("최근 2주 출석 현황:\n\n")
    attendance_content.append(month_row)
    attendance_content.append(day_row)
    attendance_content.append(separator_row)

    for member, record in attendance.items():
        attendance_content.append(f"| {member} | " + " | ".join(record) + " |\n")

    # 기존 데이터 보존 + 새로운 Attendance Section 작성
    new_lines = (
        lines[:attendance_start]
        + attendance_content
        + ["\n"]
        + lines[rules_start:]
    )

    with open("README.md", "w", encoding="utf-8") as file:
        file.writelines(new_lines)

    print("README.md 파일이 성공적으로 업데이트되었습니다.")

# 메인 함수
def main():
    # 기존 출석 데이터를 README에서 읽어오기
    attendance = initialize_attendance()

    # 커밋 데이터 읽기
    try:
        with open("commit_history.json", "r", encoding="utf-8") as file:
            commits = json.load(file)[:30]  # 최근 30개의 커밋만 사용
    except FileNotFoundError:
        print("Error: commit_history.json 파일을 찾을 수 없습니다.")
        return

    # 기존 출석 데이터를 유지하며 새 커밋 데이터를 반영
    attendance = analyze_commits(commits, attendance)

    # README 업데이트
    update_readme(attendance)
    print("README.md 파일이 성공적으로 업데이트되었습니다.")

if __name__ == "__main__":
    main()
