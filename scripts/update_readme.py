import json

# 커밋 데이터를 읽어옵니다.
with open("commit_history.json", "r") as file:
    commits = json.load(file)
    
# 커밋한 사람과 메시지를 추출합니다.
commit_messages = [
    f"- {commit['commit']['author']['name']: {commit['commit']['message']}}"
    for commit in commits[:10] # 최근 10개의 커밋만 표시
]

# 새로운 README 내용 생성
new_readme_content = "# Attendance Check\n\n"
new_readme_content += "최근 커밋 내역:\n\n"
new_readme_content += "\n".join(commit_messages)

# README.md 파일 업데이트
with open("README.md", "w") as readme_file:
    readme_file.write(new_readme_content)
    
print("README.md 업데이트 완료!")