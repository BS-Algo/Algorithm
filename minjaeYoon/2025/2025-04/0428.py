# 문자열 잘라서 정렬하기
def solution(myString):
    myString = [i for i in myString.split("x") if i]
    myString.sort()
    return myString

myString = "axbxcxdx"

print(solution(myString))