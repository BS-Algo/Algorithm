#답 :
import pandas as pd

# 저장된 CSV 파일 불러오기
train = pd.read_csv("농약_train.csv")
test = pd.read_csv("농약_test.csv")

# 0. 범주형 데이터 인코딩(get_dummies)
df_train_encoded = pd.get_dummies(train)
df_train_encoded

df_test_encoded = pd.get_dummies(test)
df_test_encoded


# 1. 훈련 데이터를 훈련용과 검증용으로 데이터 분할
from sklearn.model_selection import train_test_split

x = df_train_encoded.drop(columns=['농약검출여부']) # 독립변수
y = df_train_encoded['농약검출여부'] # 종속변수

x_train, x_val, y_train, y_val = train_test_split(x, y, test_size=0.1, random_state=42)

# 2. 표준화
from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()

# 훈련 데이터 표준화
x_train_scaled = scaler.fit_transform(x_train)
x_val_scaled = scaler.fit_transform(x_val)

# 테스트 데이터 표준화
test_scaled = scaler.fit_transform(df_test_encoded)

# 3. 모델 학습
from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier(n_estimators=300)
model.fit(x_train_scaled, y_train)

# 4. 예측
y_val_pred = model.predict(x_val_scaled)

# 5. 테스트 데이터 예측
y_test_pred = model.predict(test_scaled)
y_test_pred

# 6. 예측결과를 result.csv 로 저장
import pandas as pd

result = pd.DataFrame(y_test_pred, columns=['pred'])
result.to_csv('result.csv', index=False)

# 7. 검증 데이터의 성능 평가
from sklearn.metrics import f1_score

f1_score(y_val_pred, y_val, average='macro')
