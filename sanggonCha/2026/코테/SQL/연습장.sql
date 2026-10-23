SELECT SUM(g_amount) AS sum_amount
FROM COMPANY C
JOIN GUARANTEE G
    ON C.comp_id = G.comp_id
GROUP BY C.comp_id
