drop table member_detail;
drop table member;

create table member
(
	id varchar2(16), 
	name varchar2(24) not null,
	pass varchar2(16) not null,
	email varchar2(16),
	address VARCHAR2(100),
	constraint member_id_pk primary key(id)
);

//테이블 수정



create table zipcode
(
  zipcode varchar2(7),
  sido varchar2(30),
  gugun varchar2(50),
  dong varchar2(50),
  bunji varchar2(100),
  seq number primary key
);

