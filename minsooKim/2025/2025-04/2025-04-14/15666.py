N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

answer = [0] * M
def back_tracking(num, idx):
    if num == M:
        for i in range(M):
            print(answer[i], end = ' ')
        print()
        return
    
    tmp = 0

    for i in range(idx, N):
        if tmp != arr[i]:
            answer[num] = arr[i]
            tmp = arr[i]
            print(answer)
            back_tracking(num + 1 , i)

back_tracking(0, 0)
