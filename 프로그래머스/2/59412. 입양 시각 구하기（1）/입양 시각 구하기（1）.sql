-- 코드를 입력하세요
-- SELECT to_timestamp(DATETIME, 'yyyy-mm-dd hh24:mi:ss') AS HOUR
-- FROM ANIMAL_OUTS

SELECT HOUR(DATETIME) AS HOUR, COUNT(ANIMAL_ID) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR > 8 AND HOUR < 20
ORDER BY HOUR


