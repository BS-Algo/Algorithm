# 팩토리얼
def solution(n):
    # 팩토리얼 구하는 함수 작성
    def fac(num):
        fc = 1
        for i in range(1, num+1):
            fc *= i
        return fc

    def find(n):
        i = 1
        while fac(i) <= n:
            i += 1
        return i - 1
    
    return find(n)


n = 7

print(solution(n))