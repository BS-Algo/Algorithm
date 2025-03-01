N = int(input())

length = 0
digit = 1 # 현재 자리수(1의자리, 10의자리, 100의자리)
start = 1 # 자리수별 시작 숫자 (1, 10, 100)

while start <= N:
    end = min(N, start * 10 - 1) # 해당 자릿수에서 끝나는 숫자
    length += (end - start + 1) * digit # 해당 자리수의 숫자 갯수 * 자리수
    start *= 10
    digit += 1

print(length)