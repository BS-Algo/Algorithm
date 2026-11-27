import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_squared_log_error

# 0. 데이터 불러오기
train = pd.read_csv("store_train.csv")
test = pd.read_csv("store_test.csv")
train.head(10)

# 1. 종속변수와 제출용 id 분리
y=train['qty']
test_id = test['id']

# 2. train + test 합쳐서 원핫인코딩 → 다시 나누기
a= train.drop('qty', axis=1)
b =test.drop('id', axis=1)
all_df = pd.concat([ a, b ])
all_df = pd.get_dummies( all_df, columns=[ 'store_type'  ,'category', 'promo'] )
all_df

x = all_df.iloc[ 0 : len(train) ]
x_test = all_df.iloc[ len(train) : ]

#3. 검증: qty에 log1p를 씌워 학습 → expm1로 되돌려 RMSLE 확인
x_train, x_val, y_train, y_val =train_test_split( x, y, test_size=0.2, random_state=0)

model = RandomForestRegressor()
model.fit( x_train, np.log1p(y_train))

val_pred=model.predict( x_val)

np.sqrt( mean_squared_log_error ( y_val, val_pred) )

# 4. 최종: train 전체로 다시 학습 → test 예측
model.fit( x, np.log1p(y))

pred=model.predict( x_test)

final_pred=np.expm1(pred)


# 5. 제출 파일 저장
result =pd.DataFrame( { 'id' : test_id, 'pred' : final_pred } )
result.to_csv('result.csv', index=False)


