-- 코드를 입력하세요
WITH CTE AS (
    SELECT 
        C.CAR_ID,
        C.DAILY_FEE,
        C.CAR_TYPE,
        H.HISTORY_ID,
        DATEDIFF(H.END_DATE, H.START_DATE) + 1 AS PERIOD,
        CASE
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN '7일 이상'
            ELSE 'NONE'
        END AS DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
        JOIN CAR_RENTAL_COMPANY_CAR C ON H.CAR_ID = C.CAR_ID
    WHERE C.CAR_TYPE = '트럭'
)
SELECT 
    H.HISTORY_ID,
    ROUND((H.PERIOD * H.DAILY_FEE * (100 - IFNULL(P.DISCOUNT_RATE, 0)) / 100),0) AS FEE
FROM CTE H 
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON H.CAR_TYPE = P.CAR_TYPE AND H.DURATION_TYPE = P.DURATION_TYPE
ORDER BY 
    FEE DESC,
    HISTORY_ID DESC
    