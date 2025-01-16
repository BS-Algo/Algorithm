X, Y = map(int, input().split())
Z =(Y * 100) // X
start = 1
end = int(1e9)
cnt = -1
# X와 Y에 얼마큼씩 더해졌을때 Z가 변한다. 그 변하는 값을 찾을려면,,,?
# 100과 80의 경우 80 / 100 = 0.80 ... 6이 더해졌더니 86 / 106 = 0.81로 변함
while start <= end:
    mid = (start + end) // 2
    
    if ((Y + mid) * 100) // (X + mid) > Z:
        cnt = mid
        end = mid -1
    else:
        start = mid + 1
print(cnt)
        

