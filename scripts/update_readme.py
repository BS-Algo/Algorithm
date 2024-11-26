import json
from datetime import datetime

# 멤버 이름 리스트 (코드에서 직접 관리)
MEMBERS = [
    "jinsongLee",
    "junWhang",
    "minjaeYoon",
    "minjaeYun",
    "heongyuKim",
    "jaeyeongPark",
    "sanggonCha",
    "eunseopKim"
]

# 오늘 날짜의 커밋 내역 분석
def analyze_commits(commits):
    today = datetime.utcnow().date()  # UTC 기준으로 오늘 날짜
    attendance = {member: "⬜" for member in MEMBERS}  # 기본값은 '⬜' (결석)

    for commit in commits:
        try:
            author = commit["commit"]["author"]["name"]  # 커밋 작성자
            date_str = commit["commit"]["author"]["date"][:10]  # 날짜 (YYYY-MM-DD 형식)
            commit_date = datetime.strptime(date_str, "%Y-%m-%d").date()  # 문자열을 날짜로 변환

            # 오늘 날짜의 커밋인지 확인
            if commit_date == today and author in MEMBERS:
                attendance[author] = "🟩"  # 출석 표시
        except KeyError:
            continue  # 예상치 못한 데이터가 있을 경우 넘어감

    return attendance

# README 파일 업데이트
def update_readme(attendance):
    # 기존 README 읽기
    try:
        with open("README.md", "r", encoding="utf-8") as file:
            lines = file.readlines()
    except FileNotFoundError:
        print("Error: README.md 파일을 찾을 수 없습니다.")
        return

    # 기존 README에서 Attendance와 Rules 섹션 구분
    attendance_start = None
    rules_start = None
    for i, line in enumerate(lines):
        if "<!-- Attendance Section -->" in line:
            attendance_start = i
        if "<!-- Rules Section -->" in line:
            rules_start = i
            break

    # 출석 체크 내용 생성
    attendance_content = ["<!-- Attendance Section -->\n", "# Attendance Check\n\n"]
    for member, status in attendance.items():
        attendance_content.append(f"**{member}**: {status}\n")

    # 새로운 README 생성
    if rules_start is not None:
        new_lines = attendance_content + ["\n"] + lines[rules_start:]
    else:
        new_lines = attendance_content + lines  # Rules 섹션이 없으면 그대로 유지

    # README 파일 쓰기
    with open("README.md", "w", encoding="utf-8") as file:
        file.writelines(new_lines)

    print("README.md 파일이 성공적으로 업데이트되었습니다.")

# 메인 함수
def main():
    # 커밋 데이터 읽기
    try:
        with open("commit_history.json", "r", encoding="utf-8") as file:
            commits = json.load(file)[:30]  # 최근 30개의 커밋만 사용
    except FileNotFoundError:
        print("Error: commit_history.json 파일을 찾을 수 없습니다.")
        return

    # 커밋 데이터 분석
    attendance = analyze_commits(commits)

    # README 업데이트
    update_readme(attendance)

if __name__ == "__main__":
    main()
