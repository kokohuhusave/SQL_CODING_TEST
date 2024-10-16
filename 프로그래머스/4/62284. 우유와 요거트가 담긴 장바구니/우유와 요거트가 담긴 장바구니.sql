-- 코드를 입력하세요
SELECT CART_ID
FROM (SELECT CART_ID
      FROM CART_PRODUCTS
      GROUP BY CART_ID, NAME
      HAVING NAME REGEXP 'Milk|Yogurt') AS A
GROUP BY CART_ID
HAVING COUNT(CART_ID) = 2