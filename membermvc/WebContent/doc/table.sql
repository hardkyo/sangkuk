drop table member_detail;
drop table member;

create table member
(
	id varchar2(16), 
	name varchar2(24) not null,
	pass varchar2(16) not null,
	email1 varchar2(16),
	email2 varchar2(20) default 'kitri.com',
	constraint member_id_pk primary key(id)
);

create table member_detail
(
	id varchar2(16), 
	tel1 varchar2(3),
	tel2 varchar2(4),
	tel3 varchar2(4),
	zip1 varchar2(3),
	zip2 varchar2(3),
	addr1 varchar2(100),
	addr2 varchar2(100),
	joindate date default sysdate,
	constraint member_detail_id_fk pk foreign key(id)
	reference member (id)
);


insert all 
into member(id, name, pass, email1, email2) 
values ('as','as','as','as','naver.com') 
into member_detail (id, tel1, tel2, tel3, zip1, zip2, addr1, addr2, joindate ) 
values ('as','010','1244','4444','124','124','as','as', sysdate) 
select * from dual 