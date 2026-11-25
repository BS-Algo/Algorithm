# 답:

# hotel_train.csv (훈련 데이터)
# hotel_test.csv (평가용 데이터)
# 예측할 컬럼: TotalBill (총 청구액)

# 학습용 데이터(hotel_train.csv)를 이용하여 총 청구액을 예측하는 모델을 만든 후,
# 이를 평가용 데이터(hotel_test.csv)에 적용해 예측값을 다음과 같은 형식의 CSV 파일로 생성하세요.
hotel_train
hotel_test

x = hotel_train.iloc[:, :-1]
y = hotel_train.iloc[:, -1]

from sklearn.ensemble import RandomForestRegressor
model = RandomForestRegressor()
model.fit(x, y)
pred = model.predict(hotel_test)
pd.DataFrame({'pred': pred}).to_csv('수험번호.csv', index=False)