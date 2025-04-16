# 정처기 실기 파이썬 코딩 예상문제 분석 (리스트, for 반복문)
box = [[1,2,3],[4,5,6],[7,8,9]]
for line in box:
    for col in line:
        print(col, end="")
    print()
        
# List는 파이썬에서 하나의 객체로 취급

# 정처기 실기 파이썬 코딩 예상문제 분석 (for 반복문, 가변 리스트)
def sum(*data):
    total = 0
    for i in data:
        total += i
    return total

result = sum(5, 10, 20)
print(result)

# 가변 매개 변수 *로 받고 튜플 형식

# 정처기 실기 파이썬 코딩 예상문제 분석 (시프트 연산자, for 반복문)
base = 10
bit = 3
result = 0
for i in range(1, 4):
    result = base << bit
print(result)

# >>> 표시는 idle shell (cmd?)에서 보이는거고 핵심은 비트 연산

# bit_length()
a = 10
print(bin(a))          # 0b1010
print(a.bit_length())  # 4 (1010 → 4자리)

b = 255
print(b.bit_length())  # 8 (11111111)

c = 1
print(c.bit_length())  # 1 (1)

# 정처기 실기 파이썬 코딩 예상문제 분석 (문자열 인덱스, 슬라이싱)
a = "Marry ChristMas"
b = "Happy New Year!"
c = a[:6] + b[6:9]
d = "%s"%" Birthday"
print(c+d) 