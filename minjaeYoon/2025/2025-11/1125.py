# 이상한 문자 만들기
# https://school.programmers.co.kr/learn/courses/30/lessons/12930
def solution(s):
    answer = []
    words = s.split(' ')
    
    for word in words:
        converted = ''
        for i in range(len(word)):
            if i % 2 == 0:
                converted += word[i].upper()
            else:
                converted += word[i].lower()
        answer.append(converted)
    
    return ' '.join(answer)

print(solution("try hello world"))

# 람다식 풀이
def toWeirdCase(s):
    return " ".join(map(lambda x: "".join([a.lower() if i % 2 else a.upper() for i, a in enumerate(x)]), s.split(" ")))
