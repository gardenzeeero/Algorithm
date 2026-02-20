-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d
where SKILL_CODE & (
    select sum(CODE)
    from SKILLCODES
    where CATEGORY = 'Front End'
) != 0
ORDER BY ID ASC
