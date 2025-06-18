K = int(input())
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