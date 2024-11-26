import json
from datetime import datetime, timedelta
import os

# 이메일 기반으로 멤버 정의
# 각 멤버의 이름과 이메일을 연결하여 저장
MEMBERS = {
    "eunseopKim": "subway9852@gmail.com",
    "heongyuKim": "khg6436@naver.com",
    "jaeyeongPark": "pjy980526@naver.com",
    "jinsongLee": "annaring30@naver.com",
    "junWhang": "dmg05135@gmail.com",
    "minjaeYoon": "stylishy62@gmail.com",
    "sanggonCha": "yg9618@naver.com",
}

# README 파일에서 기존 출석 데이터를 읽어오는 함수
def initialize_attendance():
    try:
        # 스크립트의 현재 디렉토리와 README 경로를 계산
        script_dir = os.path.dirname(os.path.abspath(__file__))
        readme_path = os.path.join(script_dir, "../README.md")

        # README 파일 읽기
        with open(readme_path, "r", encoding="utf-8") as file:
            lines = file.readlines()
        
        # Attendance Section 위치를 찾기
        attendance_start = None
        attendance_end = None
        for i, line in enumerate(lines):
            if "<!-- Attendance Section -->" in line:
                attendance_start = i
            if "<!-- Rules Section -->" in line:
                attendance_end = i
                break

        # Attendance Section이 없으면 오류 발생
        if attendance_start is None or attendance_end is None:
            raise ValueError("Attendance Section을 찾을 수 없습니다.")

        # 출석 데이터를 기본값으로 초기화
        attendance = {member: ["⬜" for _ in range(13)] for member in MEMBERS}  # 13일로 제한
        # 기존 출석 데이터를 읽어와 파싱
        for line in lines[attendance_start + 4 : attendance_end]:
            if "|" in line and not line.startswith("| ---"):
                parts = line.strip().split("|")
                if len(parts) > 2:
                    member = parts[1].strip()
                    if member in attendance:
                        attendance[member] = [cell.strip() for cell in parts[2:-1]]
        
        return attendance
    except FileNotFoundError:
        # README.md 파일이 없으면 기본 데이터를 반환
        print("README.md 파일을 찾을 수 없습니다. 초기화된 데이터를 반환합니다.")
        return {member: ["⬜" for _ in range(13)] for member in MEMBERS}

# 커밋 데이터를 분석하여 출석 데이터를 업데이트하는 함수
def analyze_commits(commits, attendance):
    # 오늘 날짜와 시작 날짜 계산
    today = datetime.utcnow().date()
    start_date = today - timedelta(days=12)  # 13일만 표시

    for commit in commits:
        try:
            # 커밋 작성자의 이메일과 날짜 추출
            author_email = commit['commit']['author']['email']
            date_str = commit['commit']['author']['date'][:10]  # 날짜 부분만 추출
            commit_date = datetime.strptime(date_str, "%Y-%m-%d").date()

            # 날짜가 범위 안에 있는지 확인하고 출석 체크
            if start_date <= commit_date <= today:
                for member, email in MEMBERS.items():
                    if author_email == email:
                        index = (commit_date - start_date).days
                        # 이미 출석(🟩) 체크된 경우 건너뜀
                        if attendance[member][index] == "⬜":
                            attendance[member][index] = "🟩"
        except KeyError:
            continue

    return attendance

# README 파일을 업데이트하는 함수
def update_readme(attendance):
    # 스크립트의 현재 디렉토리와 README 경로를 계산
    script_dir = os.path.dirname(os.path.abspath(__file__))
    readme_path = os.path.join(script_dir, "../README.md")

    # 기존 README 파일 읽기
    with open(readme_path, "r", encoding="utf-8") as file:
        lines = file.readlines()

    # Attendance와 Rules 섹션 위치 찾기
    attendance_start = None
    rules_start = None
    for i, line in enumerate(lines):
        if "<!-- Attendance Section -->" in line:
            attendance_start = i
        if "<!-- Rules Section -->" in line:
            rules_start = i
            break

    # 최근 13일의 날짜와 요일 생성
    today = datetime.utcnow().date()
    dates = [(today - timedelta(days=i)) for i in range(12, -1, -1)]
    days = [date.strftime("%a") for date in dates]

    # 요일 행 생성 (주말은 빨간색으로 표시)
    day_row = "|   | " + " | ".join(
        [f"**{day}**" if day in ["Sat", "Sun"] else day for day in days]
    ) + " |\n"
    separator_row = "|" + " --- |" * (len(dates) + 1) + "\n"

    # Attendance 데이터 생성
    attendance_content = ["<!-- Attendance Section -->\n", "# Attendance Check\n\n"]
    attendance_content.append(day_row)
    attendance_content.append(separator_row)

    for member, record in attendance.items():
        # 이름과 출석 데이터 행 생성
        attendance_content.append(f"| {member} | " + " | ".join(record) + " |\n")

    # 기존 데이터 보존 + 새로운 Attendance Section 작성
    new_lines = (
        lines[:attendance_start]
        + attendance_content
        + ["\n"]
        + lines[rules_start:]
    )

    # 업데이트된 내용을 README 파일에 쓰기
    with open(readme_path, "w", encoding="utf-8") as file:
        file.writelines(new_lines)

    print("README.md 파일이 성공적으로 업데이트되었습니다.")

# 메인 함수
def main():
    # 기존 출석 데이터를 README에서 읽어오기
    attendance = initialize_attendance()

    # 커밋 데이터 읽기
    try:
        script_dir = os.path.dirname(os.path.abspath(__file__))
        commit_path = os.path.join(script_dir, "../commit_history.json")
        with open(commit_path, "r", encoding="utf-8") as file:
            commits = json.load(file)[:30]  # 최근 30개의 커밋만 사용
    except FileNotFoundError:
        print("Error: commit_history.json 파일을 찾을 수 없습니다.")
        return

    # 출석 데이터 업데이트
    attendance = analyze_commits(commits, attendance)

    # README 업데이트
    update_readme(attendance)
    print("README.md 파일이 성공적으로 업데이트되었습니다.")

# 프로그램 시작
if __name__ == "__main__":
    main()
