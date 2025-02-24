'''
n을 2진수 변환했을 때 1의 개수가 필요한 막대기의 개수임.
ex) n이 23인 경우 => 23의 2진수는 0010111

n & (1 << i) 하면서 23의 2진수에서 1 개수 체크
i = 0일 때, 1 << i는 0000001   0010111 & 0000001 -> 0000001    cnt = 1
i = 1일 때, 1 << i는 0000010   0010111 & 0000010 -> 0000010    cnt = 2
요론 식으루~ 하면 됨
'''

n = int(input())
cnt = 0

for i in range(7): # i=0~6
    if n & (1 << i):
        cnt += 1 # 막대기 수 한 개 추가

print(cnt)