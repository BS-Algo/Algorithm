import json
from datetime import datetime, timedelta

# 멤버 리스트 (미리 정의)
MEMBERS = [
    "jinsongLee",
    "junWhang",
    "minjaeYoon",
    "heongyuKim",
    "sanggoncha",
    "jaeyeongPark",
    "minjaeYun",
    "eunseopKim",
]

# 커밋 데이터 분석
def analyze_commits(commits):
    today = datetime.utcnow().date()  # 오늘 날짜
    start_date = today - timedelta(days=13)  # 이전 2주(14일) 시작 날짜
    dates = [start_date + timedelta(days=i) for i in range(14)]  # 14일 날짜 리스트
    weekdays = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]  # 요일 리스트

    # 각 멤버별 출석 상태 초기화
    attendance = {member: ["⬜" for _ in range(14)] for member in MEMBERS}

    for commit in commits:
        try:
            author = commit["commit"]["author"]["name"]  # 커밋 작성자
            date_str = commit["commit"]["author"]["date"][:10]  # 날짜 (YYYY-MM-DD)
            commit_date = datetime.strptime(date_str, "%Y-%m-%d").date()  # 날짜 변환

            # 14일 범위 내 커밋인지 확인
            if start_date <= commit_date <= today and author in MEMBERS:
                index = (commit_date - start_date).days
                attendance[author][index] = "🟩"  # 출석 표시
        except KeyError:
            continue  # 예상치 못한 데이터는 무시

    return dates, weekdays, attendance

# README 파일 업데이트
def update_readme(dates, weekdays, attendance):
    # 월 헤더 생성
    months = [date.strftime("%b") for date in dates]  # 날짜에서 월만 추출 (e.g., Nov, Oct)
    month_header = " | " + " | ".join([month if i == 0 or months[i] != months[i - 1] else "" for i, month in enumerate(months)]) + " |"

    # 요일 헤더 생성
    weekday_header = " | " + " | ".join([weekdays[date.weekday()] for date in dates]) + " |"

    # 구분선 생성 (GitHub 표 스타일)
    separator = " | " + " | ".join(["---" for _ in dates]) + " |"

    # 멤버별 출석 상태 생성
    attendance_rows = []
    for member, record in attendance.items():
        attendance_rows.append(f"**{member}** | " + " | ".join(record) + " |")

    # README 내용 생성
    attendance_section = [
        "<!-- Attendance Section -->\n",
        "# Attendance Check\n\n",
        "최근 2주 출석 현황:\n\n",
        month_header + "\n",
        weekday_header + "\n",
        separator + "\n",
    ] + [row + "\n" for row in attendance_rows]

    # 기존 README 읽기
    try:
        with open("README.md", "r", encoding="utf-8") as file:
            lines = file.readlines()
    except FileNotFoundError:
        print("Error: README.md 파일을 찾을 수 없습니다.")
        return

    # Rules Section 시작 부분 찾기
    rules_start = None
    for i, line in enumerate(lines):
        if "<!-- Rules Section -->" in line:
            rules_start = i
            break

    # 새로운 README 생성
    new_lines = attendance_section + ["\n"] + lines[rules_start:]
    with open("README.md", "w", encoding="utf-8") as file:
        file.writelines(new_lines)

    print("README.md 파일이 성공적으로 업데이트되었습니다.")

# 메인 함수
def main():
    # 커밋 데이터 읽기
    try:
        with open("commit_history.json", "r", encoding="utf-8") as file:
            commits = json.load(file)[:30]  # 최근 30개 커밋만 사용
    except FileNotFoundError:
        print("Error: commit_history.json 파일을 찾을 수 없습니다.")
        return

    # 커밋 데이터 분석
    dates, weekdays, attendance = analyze_commits(commits)

    # README 업데이트
    update_readme(dates, weekdays, attendance)

if __name__ == "__main__":
    main()
