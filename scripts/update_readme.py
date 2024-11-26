import json

# 커밋 데이터 파일 읽기
try:
    with open("commit_history.json", "r", encoding="utf-8") as file:
        commits = json.load(file)
except FileNotFoundError:
    print("Error: commit_history.json 파일을 찾을 수 없습니다.")
    exit(1)

# 최근 커밋 메시지를 추출
try:
    commit_messages = [
        f"- {commit['commit']['author']['name']} ({commit['commit']['author']['date']}): {commit['commit']['message']}"
        for commit in commits[:5]  # 최근 5개의 커밋
    ]
except KeyError as e:
    print(f"Error: JSON 데이터에서 키 {e}를 찾을 수 없습니다.")
    exit(1)

# README.md 업데이트
try:
    new_content = "# Attendance Check\n\n최근 커밋 내역:\n\n" + "\n".join(commit_messages)
    with open("README.md", "w", encoding="utf-8") as readme_file:
        readme_file.write(new_content)
    print("README.md 파일이 성공적으로 업데이트되었습니다.")
except Exception as e:
    print(f"Error: README.md 파일 업데이트 중 문제가 발생했습니다: {e}")
    exit(1)
