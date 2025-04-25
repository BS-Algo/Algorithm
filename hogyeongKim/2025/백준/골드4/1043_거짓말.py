import sys
input = sys.stdin.readline

n, m = map(int, input().split())
truth_vals = list(map(int, input().split()))

# 진실을 아는 사람은 0명부터 가능. 0명 이상일 경우에만 의미가 있으므로, 0명 이상인 경우만 체크.
truth = []
if truth_vals[0] > 0:
    # 첫 입력값은 사람 숫자(쓸 데 없음)이므로 제외하고 진실을 아는 사람 리스트(truth) 생성.
    truth = truth_vals[1:]
    
    # Union-Find 부모(parents) 리스트 생성. 특정 값(0)을 그룹으로 묶는 데 사용함. 만약 n+1을 넘어가는 값을 통해 묶으려면, 리스트를 그만큼 더 생성해줘야 함.
    parents = [i for i in range(n+1)]
    parties = []
    
    # 파티에 참가하는 사람은 1명부터 가능. 첫 입력값은 사람 숫자(쓸 데 없음)이므로 제외하고 파티에 참가하는 사람 리스트를 파티 리스트(parties)에 삽입.
    for _ in range(m):
        tmp = list(map(int, input().split()))
        parties.append(tmp[1:])

    # Find 함수. 현재 스스로의 인덱스와 다른 값을 부모로 가지고 있다면, 그 노드 값을 통해 최종적으로 참조하는 노드 값을 반환.
    def find(x):
        if x != parents[x]:
            return find(parents[x])
        return parents[x]
    
    # Union 함수. 0을 통해 그룹으로 묶을 것이므로, 0을 조건식에 넣어 참조 값을 변경.
    def union(x, y):
        a = find(x)
        b = find(y)
        if b == 0:
            parents[a] = b
        else:
            parents[b] = a
            
    for person in truth:
        # Union 함수에 넣었을 때, b의 값이 0으로 고정되므로 truth에 속한 모든 노드들은 parents에서 0을 참조하게 됨.
        union(person, 0)
        
    for party in parties:
        # 어차피 모두 연결할 것이므로 첫 노드를 기준으로 Union 실행.
        party_root = party[0]
        for person in party:
            # party_root가 최종적으로 참조하는 노드가 0이라면 person이 party_root를 참조하게 됨. 아니더라도 일단 묶이므로, 추후 진실을 아는 사람과 같은 파티에 참석한다면 바뀌게 됨.
            union(person, party_root)

    cnt = 0
    for party in parties:
        check = True
        # 파티를 순회하면서, 각 사람을 find 하여 최종적으로 참조하는 값을 찾았을 때, 0이 아닌 경우에만 cnt + 1.
        for person in party:
            if find(person) == 0:
                check = False
                break
        if check:
            cnt += 1
    print(cnt)
else:
    print(m)
