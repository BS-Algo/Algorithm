import json
from datetime import datetime, timedelta
import os

# 이메일 기반으로 멤버 정의
MEMBERS = {
    "sanggonCha": "yg9618@naver.com",
    "heongyuKim": "khg6436@naver.com",
    "jaeyeongPark": "pjy980526@naver.com",
    "minjaeYoon": "stylishy62@gmail.com",
    "eunseopKim": "subway9852@gmail.com",
    "jinsongLee": "annaring30@naver.com",
    "junWhang": "dmg05135@gmail.com",
}

# README 파일에서 기존 출석 데이터를 읽어오는 함수
def initialize_attendance():
    try:
        script_dir = os.path.dirname(os.path.abspath(__file__))
        readme_path = os.path.join(script_dir, "../README.md")

        with open(readme_path, "r", encoding="utf-8") as file:
            lines = file.readlines()

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

        # 기본 출석 데이터 초기화
        attendance = {member: ["⬜" for _ in range(13)] for member in MEMBERS}
        saved_dates = []

        # 기존 출석 데이터 읽기
        for line in lines[attendance_start + 4 : attendance_end]:
            if "|" in line and not line.startswith("| ---"):
                parts = line.strip().split("|")
                if len(parts) > 2:
                    member = parts[1].strip()
                    if member in attendance:
                        attendance[member] = [cell.strip() for cell in parts[2:-1]]

        today = (datetime.utcnow() + timedelta(hours=9)).date()  # KST 기준
        saved_dates = [(today - timedelta(days=i)) for i in range(12, -1, -1)]
        return attendance, saved_dates
    except FileNotFoundError:
        print("README.md 파일을 찾을 수 없습니다. 초기화된 데이터를 반환합니다.")
        today = (datetime.utcnow() + timedelta(hours=9)).date()  # KST 기준
        return (
            {member: ["⬜" for _ in range(13)] for member in MEMBERS},
            [(today - timedelta(days=i)) for i in range(12, -1, -1)],
        )

# 날짜 변경에 따른 출석 데이터 업데이트
def update_attendance_dates(attendance, saved_dates):
    today = (datetime.utcnow() + timedelta(hours=9)).date()  # KST 기준
    current_dates = [(today - timedelta(days=i)) for i in range(12, -1, -1)]  # 최근 13일 기준

    # 날짜가 변경된 경우 데이터 이동
    if saved_dates != current_dates:
        new_attendance = {member: ["⬜"] * 13 for member in MEMBERS}

        for member, records in attendance.items():
            # saved_dates와 current_dates의 겹치는 부분만 유지
            for old_date, record in zip(saved_dates, records):
                if old_date in current_dates:
                    index = current_dates.index(old_date)
                    new_attendance[member][index] = record

        print(f"✅ 날짜가 변경되었습니다. 새로운 날짜: {current_dates}")
        return new_attendance, current_dates

    return attendance, saved_dates

# 커밋 데이터를 분석하여 출석 데이터를 업데이트하는 함수
def analyze_commits(commits, attendance):
    today = (datetime.utcnow() + timedelta(hours=9)).date()  # KST 기준
    start_date = today - timedelta(days=12)  # 13일만 표시
    last_committer = None

    for commit in commits:
        try:
            author_email = commit['commit']['author']['email']
            author_name = commit['commit']['author']['name']
            date_str = commit['commit']['author']['date']  # 전체 날짜와 시간 포함
            commit_date = datetime.strptime(date_str, "%Y-%m-%dT%H:%M:%SZ")

            # UTC -> KST 변환
            commit_date += timedelta(hours=9)

            # 날짜만 추출
            commit_date = commit_date.date()

            # 가장 최근 커밋 작성자 추적
            last_committer = author_name

            # 커밋 날짜가 출석 범위에 포함될 경우
            if start_date <= commit_date <= today:
                print(f"✅ 커밋 반영 중: {author_name}, 날짜: {commit_date}")
                for member, email in MEMBERS.items():
                    if author_email == email:
                        index = (commit_date - start_date).days
                        if 0 <= index < 13:  # 범위 검사
                            attendance[member][index] = "🟩"
                        else:
                            print(f"⚠️ Index {index}가 범위를 초과했습니다.")
        except KeyError as e:
            print(f"⚠️ 커밋 데이터 오류: {e}")
            continue

    return attendance, last_committer

# README 파일을 업데이트하는 함수
def update_readme(attendance, last_committer):
    script_dir = os.path.dirname(os.path.abspath(__file__))
    readme_path = os.path.join(script_dir, "../README.md")

    with open(readme_path, "r", encoding="utf-8") as file:
        lines = file.readlines()

    attendance_start = None
    rules_start = None
    for i, line in enumerate(lines):
        if "<!-- Attendance Section -->" in line:
            attendance_start = i
        if "<!-- Rules Section -->" in line:
            rules_start = i
            break

    # 현재 날짜와 시간 계산
    current_time = (datetime.utcnow() + timedelta(hours=9)).strftime("%Y-%m-%d %H:%M:%S")  # KST
    header_line = f"⏲ **{current_time}** 출석현황<br>"

    # 마지막 커밋 작성자 표시
    if last_committer:
        committer_line = f"📝 마지막 커밋 작성자: **{last_committer}**"
    else:
        committer_line = "📝 마지막 커밋 작성자: 없음  "

    # 요일 헤더 생성
    today = (datetime.utcnow() + timedelta(hours=9)).date()  # KST 기준
    dates = [(today - timedelta(days=i)) for i in range(12, -1, -1)]
    days = [date.strftime("%a") for date in dates]

    day_row = "|   | " + " | ".join(
        [f"**{day}**" if day in ["Sat", "Sun"] else day for day in days]
    ) + " |\n"
    separator_row = "|" + " --- |" * (len(dates) + 1) + "\n"

    # 출석 데이터 생성
    attendance_content = ["<!-- Attendance Section -->\n", "# 📅Attendance Check\n\n"]
    attendance_content.append(header_line)
    attendance_content.append(committer_line + "\n")
    attendance_content.append(day_row)
    attendance_content.append(separator_row)

    for member, record in attendance.items():
        attendance_content.append(f"| {member} | " + " | ".join(record) + " |\n")

    new_lines = (
        lines[:attendance_start]
        + attendance_content
        + ["\n"]
        + lines[rules_start:]
    )

    with open(readme_path, "w", encoding="utf-8") as file:
        file.writelines(new_lines)

    print("README.md 파일이 성공적으로 업데이트되었습니다.")

# 메인 함수
def main():
    attendance, saved_dates = initialize_attendance()

    try:
        script_dir = os.path.dirname(os.path.abspath(__file__))
        commit_path = os.path.join(script_dir, "../commit_history.json")
        with open(commit_path, "r", encoding="utf-8") as file:
            commits = json.load(file)[:30]
    except FileNotFoundError:
        print("Error: commit_history.json 파일을 찾을 수 없습니다.")
        return

    # 날짜 이동 먼저 처리
    attendance, saved_dates = update_attendance_dates(attendance, saved_dates)
    # 커밋 반영
    attendance, last_committer = analyze_commits(commits, attendance)
    # README 업데이트
    update_readme(attendance, last_committer)
    print("README.md 파일이 성공적으로 업데이트되었습니다.")

if __name__ == "__main__":
    main()
