# 문자열 묶기
def solution(strArr):
    answer = 0
    comp = 0
    
    for i in range(len(strArr)):
        strArr[i] = len(strArr[i])
        
    for i in range(1, 31):
        comp = strArr.count(i)
        if answer <= comp:
            answer = comp
    return answer

strArr = ["a","bc","d","efg","hi"]

print(solution(strArr))