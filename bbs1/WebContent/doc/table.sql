//��������

���̵� : bbs
��� bbs

create user bbs identified by bbs;
grant connect, resource, dba to bbs;

create table UserInfo
(
	id varchar2(20), 
	pass varchar2(20) not null,
	name varchar2(20) not null,
	email varchar2(16),
	constraint userinfo_id_pk primary key(id)
);

create table bbs( //my sql�� �ۼ�
   bbsID int,
   bbsTitle varchar(50),
   userID varchar(20),
   bbsDate datetime,
   bbsContent varchar(2048),
   bbsAvailable int,
   primary key (bbsID)
   );
   
   