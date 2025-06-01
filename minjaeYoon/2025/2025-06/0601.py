# A로 B 만들기
def solution(before, after):
    from collections import Counter
    return 1 if Counter(before) == Counter(after) else 0
    
before = "olleh"
after = "hello"

print(solution(before, after))

# 굳이 컬렉션-카운터 사용할 필요가 없었던 - 순서는 자유롭게 변경이 가능
def solution(before, after):
    return 1 if sorted(before)==sorted(after) else 0

# 이진수 더하기
def solution(bin1, bin2):
    answer = ''
    res = int(bin1, 2) + int(bin2, 2)
    res = bin(res)
    return answer.join(res)[2:]

bin1 = "10"
bin2 = "11"

print(solution(bin1, bin2))