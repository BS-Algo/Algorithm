import json
from datetime import datetime, timedelta
import os

# 멤버 정보 (출석 날짜 포함)
MEMBERS = {
    "sanggonCha": {"email": "yg9618@naver.com", "dates": set()},
    "heongyuKim": {"email": "khg6436@naver.com", "dates": set()},
    "jaeyeongPark": {"email": "pjy980526@naver.com", "dates": set()},
    "minjaeYoon": {"email": "stylishy62@gmail.com", "dates": set()},
}
# 박재영 팀원의 출석 정보 추가
MEMBERS["sanggonCha"]["dates"].update(["2024-11-26", "2024-11-27", "2024-11-28"])
MEMBERS["jaeyeongPark"]["dates"].update(["2024-11-22", "2024-11-25", "2024-11-26", "2024-11-28", "2024-11-29", "2024-12-02"])
MEMBERS["heongyuKim"]["dates"].update(["2024-11-25", "2024-11-26", "2024-11-27"])
MEMBERS["minjaeYoon"]["dates"].update(["2024-11-22", "2024-11-26", "2024-12-03", "2024-12-05", "2024-12-06"])

# 최근 13일 날짜 리스트 생성
def get_saved_dates():
    today = (datetime.utcnow() + timedelta(hours=9)).date()
    return [(today - timedelta(days=i)).isoformat() for i in range(12, -1, -1)]

# 커밋 데이터를 분석하여 출석 정보를 갱신하는 함수
def analyze_commits(commits):
    """
    커밋 데이터를 기반으로 출석 정보를 갱신.
    """
    saved_dates = get_saved_dates()
    last_committer = None

    print(f"⚙️ 저장된 날짜: {saved_dates}")  # 디버그 로그 추가

    for commit in commits:
        try:
            author_email = commit["commit"]["author"]["email"]
            author_name = commit["commit"]["author"]["name"]
            commit_date = commit["commit"]["author"]["date"]
            commit_date = (
                datetime.strptime(commit_date, "%Y-%m-%dT%H:%M:%SZ") + timedelta(hours=9)
            ).date().isoformat()

            print(f"🔍 처리 중 커밋: {commit_date} by {author_name}")  # 디버그 로그 추가

            if commit_date in saved_dates:
                last_committer = author_name
                for member, info in MEMBERS.items():
                    if author_email == info["email"]:
                        info["dates"].add(commit_date)
                        print(f"✅ 출석 추가: {member} - {commit_date}")  # 디버그 로그 추가
                        break
        except KeyError as e:
            print(f"⚠️ 커밋 데이터 오류: {e}")
            continue

    return last_committer

# README 파일 업데이트 함수
def update_readme(last_committer):
    """
    README.md 파일을 갱신된 출석 정보로 업데이트.
    """
    script_dir = os.path.dirname(os.path.abspath(__file__))
    readme_path = os.path.join(script_dir, "../README.md")
    saved_dates = get_saved_dates()

    with open(readme_path, "r", encoding="utf-8") as file:
        lines = file.readlines()

    # Attendance Section 위치 찾기
    attendance_start = None
    rules_start = None
    for i, line in enumerate(lines):
        if "<!-- Attendance Section -->" in line:
            attendance_start = i
        if "<!-- Rules Section -->" in line:
            rules_start = i
            break

    if attendance_start is None or rules_start is None:
        raise ValueError("README.md 파일 형식 오류")

    # 현재 시간 (KST) 계산
    current_time = (datetime.utcnow() + timedelta(hours=9)).strftime("%Y-%m-%d %H:%M:%S")
    header_line = f"⏲ **{current_time}** 출석현황<br>"
    committer_line = (
        f"📝 마지막 커밋 작성자: **{last_committer}**" if last_committer else "📝 마지막 커밋 작성자: 없음"
    )

    # 날짜 헤더 생성
    days = [datetime.fromisoformat(date).strftime("%a") for date in saved_dates]
    day_row = "|   | " + " | ".join(
        [f"**{day}**" if day in ["Sat", "Sun"] else day for day in days]
    ) + " |\n"
    separator_row = "|" + " --- |" * (len(saved_dates) + 1) + "\n"

    # 출석 데이터 생성
    attendance_content = ["<!-- Attendance Section -->\n", "# 📅Attendance Check\n\n"]
    attendance_content.append(header_line)
    attendance_content.append(committer_line + "\n")
    attendance_content.append(day_row)
    attendance_content.append(separator_row)

    for member, info in MEMBERS.items():
        row = [
            "🟩" if date in info["dates"] else "⬜" for date in saved_dates
        ]
        attendance_content.append(f"| {member} | " + " | ".join(row) + " |\n")

    # 업데이트된 README 저장
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
    """
    전체 프로세스를 실행.
    """
    try:
        script_dir = os.path.dirname(os.path.abspath(__file__))
        commit_path = os.path.join(script_dir, "../commit_history.json")
        with open(commit_path, "r", encoding="utf-8") as file:
            commits = json.load(file)[:30]
    except FileNotFoundError:
        print("commit_history.json 파일을 찾을 수 없습니다.")
        return

    last_committer = analyze_commits(commits)
    update_readme(last_committer)

if __name__ == "__main__":
    main()
