drop table naver;

drop sequence naver_seq;

create sequence naver_seq
start with 1 increment by 1;

create table naver
(
  seq number primary key,
  keyword varchar2(100),
  hit number
);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '자바', 100);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '재주도', 56);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '제주도', 69);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, 'java', 45);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '자바스크립트', 60);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, 'javascript', 68);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, 'javascript N xml', 32);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '제부도', 84);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '자린고비', 42);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '좋아요', 90);

select *
from naver 
where case	
			when keyword < 'ㄱ' then substr(keyword, 1, 1) 
			when ascii('ㄱ') <= ascii(keyword) and ascii(keyword)<= ascii('ㅎ') then keyword 
			when keyword < '나' then 'ㄱ'
			when keyword < '다' then 'ㄴ'
			when keyword < '라' then 'ㄷ'
			when keyword < '마' then 'ㄹ'
			when keyword < '바' then 'ㅁ'
			when keyword < '사' then 'ㅂ'
			when keyword < '아' then 'ㅅ'
			when keyword < '자' then 'ㅇ'
			when keyword < '차' then 'ㅈ'
			when keyword < '카' then 'ㅊ'
			when keyword < '타' then 'ㅋ'
			when keyword < '파' then 'ㅌ'
			when keyword < '하' then 'ㅍ'
			else 'ㅎ'
	end = 'ㅈ'