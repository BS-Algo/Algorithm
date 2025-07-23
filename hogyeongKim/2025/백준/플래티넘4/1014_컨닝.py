import sys
from collections import defaultdict
input = sys.stdin.readline

for _ in range(int(input())):
    n, m = map(int, input().split())

    classroom = [list(input()) for _ in range(n)]

    def is_valid(row, idx):
        # 좌우 체크
        # 연속된 1이 있을 경우 비트마스킹 했을 때 Falsy하지 않음
        if row & (row >> 1):
            return False
    
        # 책상 배치 체크
        for i in range(m):
            # 각 자리마다 학생이 앉는다고 했을 때(1 << i는 이의 거듭제곱수로 딱 한 자리만 1)
            if row & (1 << i):
                # 앉을 수 없는 상태인지 체크
                if classroom[idx][i] == 'x':
                    return False
        
        return True

    def is_valid_cross(prev, curr):
        # prev를 왼쪽, 오른쪽으로 한 칸 움직였는데 1이 일치하는 경우가 있을 때 Falsy하지 않음.
        if (prev << 1 & curr) or (prev >> 1 & curr):
            return False

        return True

    # 앉을 수 있는 경우의 수는 비트마스크의 경우. 양 옆에 붙어서 앉을 수 없지만, 이 경우 추가 계산이 필요하므로 M이 20 이상에나 최적화 고려할 것.
    dp = [defaultdict(int) for _ in range(n)]

    for cur_row in range(1 << m):
        if is_valid(cur_row, 0):
            dp[0][cur_row] = bin(cur_row).count('1')
    
    # 두번째 행부터 순회 시작
    for i in range(1, n):
        # 이전 행에 배치도(딕셔너리의 키들)와 비교해야 하므로 순회
        for pre_row in dp[i-1]:
            # 현재 행은 역시 비트마스크의 경우로 생성
            for cur_row in range(1 << m):
                # is_valid로 체크하고, 별도로 좌상단, 우상단과도 체크해야 함.
                if is_valid(cur_row, i) and is_valid_cross(pre_row, cur_row):
                    # defaultdict는 없는 키에 접근하면 자동으로 0을 반환하므로 에러가 발생하지 않음. 만약 dict를 사용하면 get 메서드를 사용해야 함.
                    dp[i][cur_row] = max(dp[i][cur_row], bin(cur_row).count('1') + dp[i-1][pre_row])

    print(max(dp[n-1].values()))