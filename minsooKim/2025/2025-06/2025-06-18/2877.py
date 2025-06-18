K = int(input())

# k가 4, 7 => 1자리일땐 2개 2의 1승
# k가 44, 47, 74, 77 => 2자리일땐 4개
# if k = 6 : 6>2 6-2
# k가 3 4 5 6 2자릿수
# 3일때 3 - 2의 1승
# 4 일땐 4 - 2
# k가 444... => 3자리일땐 8개
# k가 6일때 : length는 2자리, tmp번째 숫자
# 인덱스 상으로는 [0, 1, 2, 3] 4자리
# tmp-1 = 3 => 11(2)
# 1을 7로 바꾸고 0을 4로 바꿉니다
# 11 => 77

# k가 7 length = 3 tmp = 1
# tmp - 1 = 0
# 000 = > 444

length = 0

while True:
    length += 1
    current_length = 2 ** length

    if K <= current_length:
        break

    K -= current_length

tmp = K - 1

bin_num = bin(tmp)[2:]

plus_num = bin_num.zfill(length)
result = ""

for i in plus_num:
    if i == '0':
        result += '4'
    else:
        result += '7'
        
print(result)