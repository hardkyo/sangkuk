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
values (naver_seq.nextval, '�ڹ�', 100);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '���ֵ�', 56);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '���ֵ�', 69);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, 'java', 45);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '�ڹٽ�ũ��Ʈ', 60);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, 'javascript', 68);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, 'javascript N xml', 32);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '���ε�', 84);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '�ڸ����', 42);

insert into naver (seq, keyword, hit)
values (naver_seq.nextval, '���ƿ�', 90);

select *
from naver 
where case	
			when keyword < '��' then substr(keyword, 1, 1) 
			when ascii('��') <= ascii(keyword) and ascii(keyword)<= ascii('��') then keyword 
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			when keyword < 'ī' then '��'
			when keyword < 'Ÿ' then '��'
			when keyword < '��' then '��'
			when keyword < '��' then '��'
			else '��'
	end = '��'