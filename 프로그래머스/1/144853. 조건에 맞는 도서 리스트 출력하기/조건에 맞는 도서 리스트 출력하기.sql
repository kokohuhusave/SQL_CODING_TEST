-- 코드를 입력하세요
select BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d') PUBLISHED_DATE
from book
where PUBLISHED_DATE like '2021%'
    and CATEGORY in ('인문')
order by PUBLISHED_DATE;