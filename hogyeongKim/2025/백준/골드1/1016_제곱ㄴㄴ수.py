mn_num, mx_num = map(int, input().split())

# min number의 인덱스를 0으로 간주하여 상대적 인덱스로 계산하기 위함(메모리 초과 방지)
check = [False] * (mx_num-mn_num+1)

for i in range(2, int(mx_num**0.5)+1):
    pow_num = i*i
    
    # min number 이전의 제곱으로 나눠지는 수가 몇 개인지 확인
    pre_cnt = (mn_num-1) // pow_num
    
    # min number 이상의 가장 작은 제곱수의 배수 계산
    pre_cnt = (pre_cnt + 1) * pow_num
    
    # 제곱수의 배수들을 체크
    for j in range(pre_cnt, mx_num+1, pow_num):
        # min number에 대한 상대적 인덱스로 나타내기. min number 이상의 숫자에서 제곱수의 배수를 셈하므로 이 수에서 min number를 빼서 상대적 인덱스 배정.
        check[j-mn_num] = True

print(check.count(False))