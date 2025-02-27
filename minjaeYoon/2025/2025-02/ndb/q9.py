# 문자열 압축
# 구현 -> 이중 for 문
def solution(s):
    answer = len(s)
    for step in range(1, len(s) // 2+1):
        comp = ""
        prev = s[0:step]
        cnt = 1
        for j in range(step, len(s), step):
            if prev == s[j:j+step]:
                cnt += 1
            else:
                comp += str(cnt) + prev if cnt >= 2 else prev
                prev = s[j:j+step]
                cnt = 1
        comp += str(cnt) + prev if cnt >= 2 else prev
        answer = min(answer, len(comp))
    return answer

s = "aabbaccc"

print(solution(s))