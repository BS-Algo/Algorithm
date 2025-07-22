SELECT
    F.FLAVOR
FROM
    FIRST_HALF F
    JOIN (
        -- JULY에는 FLAVOR마다 다른 출하번호가 존재할 수 있음 -> 그룹화가 필요
        SELECT
            FLAVOR,
            SUM(TOTAL_ORDER) AS JULY_TOTAL_ORDER
        FROM
            JULY
        GROUP BY
            FLAVOR
    ) J ON F.FLAVOR = J.FLAVOR
ORDER BY
    F.TOTAL_ORDER + J.JULY_TOTAL_ORDER DESC
LIMIT
    3;