import os
from datetime import datetime, timedelta, timezone

import requests

# ──────────────────────────────────────────────
# 기본 설정
# ──────────────────────────────────────────────
# GitHub Personal Access Token
token = os.environ.get("GITHUBCOMMITSACCESSTOKEN")
if not token:
    raise ValueError("GitHub Personal Access Token이 설정되지 않았습니다.")

owner = "BS-Algo"   # 저장소 소유자
repo = "Algorithm"  # 저장소 이름
DAYS = 9            # 출석표에 보여줄 날짜 수
KST = timezone(timedelta(hours=9))

# 멤버 정보
#  - emails : 이 멤버의 커밋으로 셀 이메일 전부
#             (GitHub 웹에서 커밋하면 noreply 이메일로 찍혀서 같이 넣어 둠)
#  - handle : solved.ac 핸들 (없으면 "")
#  - tier, rating : solved.ac 요청이 막혔을 때 그대로 쓰는 값 (2026-11-06 solved.ac 기준)
MEMBERS = {
    "sanggonCha": {
        "emails": ["yg9618@naver.com", "102268323+CHASANGGON@users.noreply.github.com"],
        "handle": "yg9618", "tier": 16, "rating": 1600,
    },
    "heongyuKim": {
        "emails": ["khg6436@naver.com"],
        "handle": "khg6436", "tier": 15, "rating": 1439,
    },
    "jaeyeongPark": {
        "emails": ["pjy980526@naver.com"],
        "handle": "pjy980526", "tier": 12, "rating": 1045,
    },
    "minjaeYoon": {
        "emails": ["stylishy62@gmail.com", "156272655+GloryMJ@users.noreply.github.com"],
        "handle": "", "tier": 0, "rating": "????",
    },
    # "minsooKim": {"emails": ["alstn0575@naver.com"], "handle": "kei03016", "tier": 0, "rating": "????"},
    # "eunseopKim": {"emails": ["subway9852@gmail.com"], "handle": "", "tier": 0, "rating": "????"},
    # "yunhaKwon": {"emails": ["ellen4421@naver.com"], "handle": "ellen4421", "tier": 0, "rating": "????"},
    "hogyeongKim": {
        "emails": ["ssafy1123992@gmail.com", "kids9010@naver.com"],
        "handle": "rlaghtl2", "tier": 15, "rating": 1470,
    },
}

# solved.ac 티어 번호 → 배지
# 1~5 브론즈 V~I, 6~10 실버, 11~15 골드, 16~20 플래티넘, 21~25 다이아, 26~30 루비, 31 마스터
TIER_GROUPS = [
    ("B", "AD5600"),  # Bronze
    ("S", "435F7A"),  # Silver
    ("G", "EC9A00"),  # Gold
    ("P", "27E2A4"),  # Platinum
    ("D", "00B4FC"),  # Diamond
    ("R", "FF0062"),  # Ruby
]


def tier_badge(tier):
    """티어 번호를 배지 이미지로 바꿈 (예: 16 → P5). 언랭(0)은 '-'
    static.solved.ac 아이콘은 GitHub 이미지 프록시가 막혀서 README에 안 보이므로 shields.io 배지를 씀"""
    if not isinstance(tier, int) or tier <= 0:
        return "-"
    if tier >= 31:
        label, color = "M", "B491FF"
    else:
        short, color = TIER_GROUPS[(tier - 1) // 5]
        label = f"{short}{5 - (tier - 1) % 5}"
    return f'<img src="https://img.shields.io/badge/{label}-{color}?style=flat-square" alt="{label}" />'


# ──────────────────────────────────────────────
# solved.ac 티어·레이팅
# ──────────────────────────────────────────────
def get_user_data_from_solved_ac(handle):
    """solved.ac에서 티어·레이팅 조회. 실패하면 None
    (solved.ac가 GitHub 서버에서 오는 요청을 막고 있어서 Actions에서는 실패할 수 있음)"""
    url = f"https://solved.ac/api/v3/user/show?handle={handle}"
    headers = {
        "Accept": "application/json",
        "User-Agent": f"{owner}-{repo}-readme-bot",
    }
    try:
        response = requests.get(url, headers=headers, timeout=5)
        if response.status_code != 200:
            print(f"[solved.ac] {handle}: HTTP {response.status_code}")
            return None
        data = response.json()
    except (requests.RequestException, ValueError) as e:
        print(f"[solved.ac] {handle}: 요청 실패 ({e})")
        return None

    if data.get("tier") is None or data.get("rating") is None:
        print(f"[solved.ac] {handle}: 응답에 tier/rating 없음")
        return None
    return {"tier": data["tier"], "rating": data["rating"]}


def update_tiers():
    """solved.ac에서 받아오면 갱신하고, 막히면 MEMBERS에 적어 둔 값을 그대로 씀"""
    for name, info in MEMBERS.items():
        handle = info.get("handle")
        if not handle:
            continue
        user_data = get_user_data_from_solved_ac(handle)
        if user_data is None:
            print("solved.ac 요청이 막혀서 저장해 둔 티어/레이팅을 그대로 씁니다.")
            break  # 하나가 막히면 나머지도 막히므로 더 요청하지 않음
        info["tier"] = user_data["tier"]
        info["rating"] = user_data["rating"]


# ──────────────────────────────────────────────
# 커밋 집계
# ──────────────────────────────────────────────
def get_saved_dates():
    """오늘(KST)을 포함한 최근 DAYS일, 오래된 날짜부터"""
    today = datetime.now(KST).date()
    return [(today - timedelta(days=i)).isoformat() for i in range(DAYS - 1, -1, -1)]


def fetch_commits_from_github():
    """저장소 기본 브랜치의 전체 커밋을 마지막 페이지까지 가져옴"""
    session = requests.Session()
    session.headers.update({
        "Authorization": f"token {token}",
        "Accept": "application/vnd.github+json",
    })

    commits = []
    page = 1
    while True:
        url = f"https://api.github.com/repos/{owner}/{repo}/commits?per_page=100&page={page}"
        response = session.get(url, timeout=30)
        if response.status_code != 200:
            # 중간에 실패한 채로 README를 쓰면 total이 틀어지므로 여기서 멈춤
            raise RuntimeError(
                f"GitHub API 요청 실패 (page {page}): {response.status_code} {response.text[:200]}"
            )
        page_commits = response.json()
        if not page_commits:
            break
        commits.extend(page_commits)
        page += 1

    print(f"가져온 커밋 수: {len(commits)}")
    return commits


def analyze_commits(commits, saved_dates):
    """멤버별 전체 커밋 수(total)와 최근 DAYS일 출석(dates)을 계산"""
    email_to_member = {}
    for member, info in MEMBERS.items():
        info["dates"] = set()
        info["total"] = 0
        for email in info["emails"]:
            email_to_member[email.lower()] = member

    latest_committer = None
    for i, commit in enumerate(commits):
        try:
            author = commit["commit"]["author"]
            email = (author.get("email") or "").lower()
            commit_date = (
                datetime.strptime(author["date"], "%Y-%m-%dT%H:%M:%SZ")
                .replace(tzinfo=timezone.utc)
                .astimezone(KST)
                .date()
                .isoformat()
            )
        except (KeyError, TypeError, ValueError) as e:
            print(f"⚠️ 커밋 데이터 오류: {e}")
            continue

        if i == 0:  # 가장 최근 커밋
            latest_committer = author.get("name")

        member = email_to_member.get(email)
        if member is None:
            continue
        MEMBERS[member]["total"] += 1      # 기간 상관없이 전체 커밋 수
        if commit_date in saved_dates:     # 최근 DAYS일 안이면 출석 체크
            MEMBERS[member]["dates"].add(commit_date)

    return latest_committer


# ──────────────────────────────────────────────
# README 갱신
# ──────────────────────────────────────────────
def update_readme(latest_committer, saved_dates):
    """README.md의 Attendance Section을 새 표로 교체"""
    script_dir = os.path.dirname(os.path.abspath(__file__))
    readme_path = os.path.join(script_dir, "../README.md")

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

    current_time = datetime.now(KST).strftime("%Y-%m-%d %H:%M:%S")
    header_line = f"⏲ **{current_time}** 출석현황<br>"
    committer_line = (
        f"📝 마지막 커밋 작성자: **{latest_committer}**" if latest_committer else "📝 마지막 커밋 작성자: 없음"
    )

    # 날짜 헤더
    days = [datetime.fromisoformat(date).strftime("%a") for date in saved_dates]
    day_row = "| tier | rating | name | total | " + " | ".join(
        f"**{day}**" if day in ("Sat", "Sun") else day for day in days
    ) + " |\n"
    separator_row = "|" + " :---: |" * (len(saved_dates) + 4) + "\n"

    attendance_content = [
        "<!-- Attendance Section -->\n",
        "# 📅Attendance Check\n\n",
        header_line,
        committer_line + "\n",
        day_row,
        separator_row,
    ]

    for member, info in MEMBERS.items():
        handle = info.get("handle")
        name = f"[{member}](https://solved.ac/profile/{handle})" if handle else member
        marks = " | ".join("🟩" if date in info["dates"] else "⬜" for date in saved_dates)
        attendance_content.append(
            f"| {tier_badge(info.get('tier'))} | {info.get('rating', '????')} | {name} | {info['total']} | {marks} |\n"
        )

    new_lines = lines[:attendance_start] + attendance_content + ["\n"] + lines[rules_start:]
    with open(readme_path, "w", encoding="utf-8") as file:
        file.writelines(new_lines)

    print("README.md 파일이 성공적으로 업데이트되었습니다.")


# ──────────────────────────────────────────────
# 메인
# ──────────────────────────────────────────────
def main():
    saved_dates = get_saved_dates()

    commits = fetch_commits_from_github()  # GitHub에서 전체 커밋 가져오기
    if not commits:
        print("커밋 내역이 없습니다.")
        return

    update_tiers()  # 🎖 solved.ac 티어·레이팅
    latest_committer = analyze_commits(commits, saved_dates)
    update_readme(latest_committer, saved_dates)

    for name, info in MEMBERS.items():
        print(f"{name}: total={info['total']}, 출석={len(info['dates'])}일, tier={info['tier']}, rating={info['rating']}")


if __name__ == "__main__":
    main()