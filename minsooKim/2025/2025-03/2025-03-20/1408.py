from datetime import datetime, timedelta

# 입력 받기
a = input()
b = input()

# 문자열을 datetime 객체로 변환
a_datetime = datetime.strptime(a, "%H:%M:%S")
b_datetime = datetime.strptime(b, "%H:%M:%S")

# 자정 넘어가는 경우 처리
if a_datetime > b_datetime:
    b_datetime += timedelta(days=1)

# 남은 시간 계산
delta = b_datetime - a_datetime
total_seconds = int(delta.total_seconds())

# 시, 분, 초 계산 후 포맷팅 (이 부분 추가)
hours = total_seconds // 3600
minutes = (total_seconds % 3600) // 60
seconds = total_seconds % 60

# 결과 출력 (00:00:00 형식)
print(f"{hours:02}:{minutes:02}:{seconds:02}")
