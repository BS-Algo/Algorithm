SELECT
    T1.HOUR,
    COUNT(T2.DATETIME) AS COUNT
FROM
    (
        SELECT
            0 AS HOUR
        UNION ALL
        SELECT
            1
        UNION ALL
        SELECT
            2
        UNION ALL
        SELECT
            3
        UNION ALL
        SELECT
            4
        UNION ALL
        SELECT
            5
        UNION ALL
        SELECT
            6
        UNION ALL
        SELECT
            7
        UNION ALL
        SELECT
            8
        UNION ALL
        SELECT
            9
        UNION ALL
        SELECT
            10
        UNION ALL
        SELECT
            11
        UNION ALL
        SELECT
            12
        UNION ALL
        SELECT
            13
        UNION ALL
        SELECT
            14
        UNION ALL
        SELECT
            15
        UNION ALL
        SELECT
            16
        UNION ALL
        SELECT
            17
        UNION ALL
        SELECT
            18
        UNION ALL
        SELECT
            19
        UNION ALL
        SELECT
            20
        UNION ALL
        SELECT
            21
        UNION ALL
        SELECT
            22
        UNION ALL
        SELECT
            23
    ) T1
    LEFT JOIN ANIMAL_OUTS T2 ON T1.HOUR = HOUR (T2.DATETIME)
GROUP BY
    T1.HOUR
ORDER BY
    T1.HOUR;