-- 반올림 ROUND, 평균 AVG 사용
SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = 'SUV';