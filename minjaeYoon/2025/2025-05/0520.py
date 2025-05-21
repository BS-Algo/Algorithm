# 문자열 밀기
def solution(A, B):
    if A == B:
        return 0
    
    n = len(A)
    
    for i in range(1, n+1):
        shift = A[-i:] + A[:-i]
        if shift == B:
            return i

    return -1
    
A = "hello"	
B = "ohell"	

print(solution(A, B))

# 신박한 풀이
solution=lambda a,b:(b*2).find(a)
