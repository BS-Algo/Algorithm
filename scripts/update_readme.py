import json
import requests
from datetime import datetime, timedelta
import os

# GitHub Personal Access Token
token = os.environ.get("GITHUBCOMMITSACCESSTOKEN")
if not token:
    raise ValueError("GitHub Personal Access Token이 설정되지 않았습니다.")


# GitHub API URL (특정 저장소의 커밋 목록)
owner = "BS-Algo"  # 저장소 소유자
repo = "Algorithm"  # 저장소 이름
# 최대 100개의 커밋 가져오기
url = f"https://api.github.com/repos/{owner}/{repo}/commits?per_page=100"

# 인증 헤더
headers = {
    "Authorization": f"token {token}"
}

# 멤버 정보 (출석 날짜 포함)
MEMBERS = {
    "sanggonCha": {"email": "yg9618@naver.com", "dates": set(), "link": "https://solved.ac/profile/yg9618"},
    "heongyuKim": {"email": "khg6436@naver.com", "dates": set(), "link": "https://solved.ac/profile/khg6436"},
    "jaeyeongPark": {"email": "pjy980526@naver.com", "dates": set(), "link": "https://solved.ac/profile/pjy980526"},
    "minjaeYoon": {"email": "stylishy62@gmail.com", "dates": set(), "link": " "},
    # "minsooKim": {"email": "alstn0575@naver.com", "dates": set(),"link": "https://solved.ac/profile/kei03016"},
    # "eunseopKim": {"email": "subway9852@gmail.com", "dates": set()},
    # "yunhaKwon": {"email": "ellen4421@naver.com", "dates": set(),"link": "https://solved.ac/profile/ellen4421"},
    "hogyeongKim": {"email": "ssafy1123992@gmail.com", "dates": set(), "link": "https://solved.ac/profile/rlaghtl2"},
}

# 점수 가져오기 함수
# def get_user_data_from_solved_ac(handle):
#     url = f"https://solved.ac/api/v3/user/show?handle={handle}"
#     try:
#         response = requests.get(url)
#         response.raise_for_status()
#         data = response.json()
#         print(data)
#         return {
#             "rating": data.get("rating", None),
#             "tier": data.get("tier", None)
#         }
#     except Exception as e:
#         print(f"[ERROR] {handle} 점수 조회 실패: {e}")
#         return None


def get_user_data_from_solved_ac(handle):
    url = f"https://solved.ac/api/v3/user/show?handle={handle}"

    headers = {
        "User-Agent": "Mozilla/5.0",
        "Accept": "application/json"
    }

    try:
        response = requests.get(url, headers=headers, timeout=5)

        print("status:", response.status_code)
        print("text:", response.text)

        response.raise_for_status()
        data = response.json()

        return {
            "rating": data.get("rating"),
            "tier": data.get("tier")
        }

    except Exception as e:
        print(f"[ERROR] {handle} 점수 조회 실패: {e}")
        return None

# 날짜 리스트 생성


def get_saved_dates():
    today = (datetime.utcnow() + timedelta(hours=9)).date()
    return [(today - timedelta(days=i)).isoformat() for i in range(9, -1, -1)]


# GitHub API에서 커밋 내역을 가져오는 함수
def fetch_commits_from_github():
    commits = []
    page = 1
    while True:
        url = f"https://api.github.com/repos/{owner}/{repo}/commits?per_page=100&page={page}"
        headers = {"Authorization": f"token {token}"}
        response = requests.get(url, headers=headers)

        print(f"API 요청 URL: {url}")  # 디버깅: API 요청 URL 확인
        print(f"응답 상태 코드: {response.status_code}")  # 디버깅: 응답 상태 코드 확인

        if response.status_code == 200:
            page_commits = response.json()
            if not page_commits:
                print("커밋 데이터가 없습니다.")  # 디버깅: 커밋 데이터가 없을 경우
                break  # 커밋이 없으면 종료
            commits.extend(page_commits)
            page += 1
        else:
            print(
                f"GitHub API 요청 실패: {response.status_code}, 메시지: {response.text}")
            break

    return commits


def analyze_commits(commits):
    """
    커밋 데이터를 기반으로 출석 정보를 갱신.
    """
    saved_dates = get_saved_dates()

    print(f"⚙️ 저장된 날짜: {saved_dates}")  # 디버그 로그 추가

    latest_committer = None

    for i, commit in enumerate(commits):
        try:
            author_email = commit["commit"]["author"]["email"]
            author_name = commit["commit"]["author"]["name"]
            commit_date = commit["commit"]["author"]["date"]
            commit_date = (
                datetime.strptime(
                    commit_date, "%Y-%m-%dT%H:%M:%SZ") + timedelta(hours=9)
            ).date().isoformat()

            print(f"🔍 처리 중 커밋: {commit_date} by {author_name}")  # 디버그 로그 추가

            # 첫 번째 커밋에서만 last_committer 설정
            if i == 0:
                latest_committer = author_name

            if commit_date in saved_dates:
                for member, info in MEMBERS.items():
                    if author_email == info["email"]:
                        info["dates"].add(commit_date)
                        # 디버그 로그 추가
                        print(f"✅ 출석 추가: {member} - {commit_date}")
                        break

        except KeyError as e:
            print(f"⚠️ 커밋 데이터 오류: {e}")
            continue

    # 마지막으로 설정된 first_committer 리턴
    return latest_committer


# README 파일 업데이트 함수
def update_readme(latest_committer):
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
    current_time = (datetime.utcnow() + timedelta(hours=9)
                    ).strftime("%Y-%m-%d %H:%M:%S")
    header_line = f"⏲ **{current_time}** 출석현황<br>"
    committer_line = (
        f"📝 마지막 커밋 작성자: **{latest_committer}**" if latest_committer else "📝 마지막 커밋 작성자: 없음"
    )

    # 날짜 헤더 생성
    days = [datetime.fromisoformat(date).strftime("%a")
            for date in saved_dates]
    day_row = "| tier | rating | name | " + " | ".join(
        [f"**{day}**" if day in ["Sat", "Sun"] else day for day in days]
    ) + " |\n"
    separator_row = "|" + " :---: |" * (len(saved_dates) + 3) + "\n"

    # 출석 데이터 생성
    attendance_content = [
        "<!-- Attendance Section -->\n", "# 📅Attendance Check\n\n"]
    attendance_content.append(header_line)
    attendance_content.append(committer_line + "\n")
    attendance_content.append(day_row)
    attendance_content.append(separator_row)

    for member, info in MEMBERS.items():
        row = [
            "🟩" if date in info["dates"] else "⬜" for date in saved_dates
        ]

        # 티어 이미지 생성
        tier_img = ""
        tier = info.get("tier")
        rating = info.get("rating")

        if tier is not None:
            tier_img = f'<img src="https://static.solved.ac/tier_small/{tier}.svg" width="20" style="vertical-align: middle;" /> '
            tier_img += f"| {rating} "
            print("tier_img ok")
        else:
            print("tier_img not ok..")

        display_name = f"[{member}]({info['link']})" if info.get(
            "link") else member
        name_with_tier = f"{tier_img} | {display_name}"

        # attendance_content.append(f"| {display_name} | " + " | ".join(row) + " |\n")
        attendance_content.append(
            f"| {name_with_tier} | " + " | ".join(row) + " |\n")

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

    commits = fetch_commits_from_github()  # GitHub 에서 커밋 내역 가져오기

    if not commits:
        print("커밋 내역이 없습니다.")
        return

    # 🎖solved.ac 점수 업데이트
    for name, info in MEMBERS.items():
        link = info.get("link")
        if link:
            handle = link.split("/")[-1]  # 프로필 링크에서 ID 추출
            user_data = get_user_data_from_solved_ac(handle)
            if user_data:
                MEMBERS[name]["rating"] = user_data["rating"]
                MEMBERS[name]["tier"] = user_data["tier"]
            else:
                MEMBERS[name]["rating"] = "????"
                MEMBERS[name]["tier"] = 0
        else:
            MEMBERS[name]["rating"] = "????"
            MEMBERS[name]["tier"] = 0

    latest_committer = analyze_commits(commits)
    update_readme(latest_committer)

    # 결과 출력
    for name, info in MEMBERS.items():
        print(f"{name}: rating={info.get('rating')}, tier={info.get('tier')}")


if __name__ == "__main__":
    main()
