# 가장 가까운 같은 글자
# https://school.programmers.co.kr/learn/courses/30/lessons/142086
def solution(s):
    s = list(s)
    log = []
    answer = []
    calc = []
    
    for i in range(len(s)):
        if not s[i] in log:
            log.append(s[i])
            answer.append(-1)
        else: # 로그에 s[i]가 있다인데
            for j in range(i):
                if s[j] == s[i]:
                    calc.append(i-j)
            answer.append(min(calc))
            calc = []        
    return answer

print(solution("banana"))
print(solution("foobar"))

# 일단 첫 글자면 -1 로직은 유지하는게 맞는거 같은데
# 큐 사용하는 느낌으로 가야하나