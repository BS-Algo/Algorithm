# 곱하기 혹은 더하기
s = list(map(int, input())) # str => 02984
print(s)
res = s[0]
for i in range(1, len(s)):
    # print(i) => 0 / 2 / 9 / 8 / 4
    # res를 두고 0과 다음 숫자는 +가 되어야 함
    if s[i] == 0:
        res += s[i]
    elif s[i-1] == 0 and s[i] != 0:
        res += s[i]
    else:
        res *= s[i]
print(res)
# 1을 더해야 하는 상황을 망각


# 참고 답안
data = input()
result = int(data[0])
for i in range(1, len(data)):
    num = int(data[i])
    if num <= 1 or result <= 1:
        result += num
    else:
        result *= num

print(result)

# 개선된 풀이
s = list(map(int, input())) # str => 02984
print(s)
res = s[0]
for i in range(1, len(s)):
    # print(i) => 0 / 2 / 9 / 8 / 4
    if s[i] in [0, 1]:
        res += s[i]
    elif s[i-1] in [0, 1] and s[i] != 0:
        res += s[i]
    else:
        res *= s[i]
print(res)