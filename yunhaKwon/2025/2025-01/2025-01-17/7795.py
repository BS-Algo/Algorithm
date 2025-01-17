def bin_search(B_lst, target):
    start = 0
    end = B - 1
    while start <= end:
        mid = (start + end) // 2
        if B_lst[mid] < target:
            start = mid + 1  # target보다 작으면 오른쪽 탐색
        else:
            end = mid - 1  # target보다 크거나 같으면 왼쪽 탐색
    return start  # start: target보다 작은 요소의 개수

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    A_lst = list(map(int, input().split()))
    B_lst = list(map(int, input().split()))

    A_lst.sort()
    B_lst.sort()

    result = 0

    for a in A_lst:
        result += bin_search(B_lst, a)

    print(result)
