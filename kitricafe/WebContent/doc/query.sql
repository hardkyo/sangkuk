-- �Խ��� ���
select bl.bcode, c.cname, bl.bname, bl.btype, c.ccode,
       decode(bl.btype, 5, 'reboard',
						6, 'album',
						7, 'bbs',
						'board') control 
from board_list bl, category c
where bl.ccode = c.ccode;

-- �亯�Խ��� �۾���
insert all
	into board (seq, name, id, email, subject, content, hit, logtime, bcode)
	values(?, ?, ?, ?, ?, ?, 0, sysdate, ?)
	into reboard (rseq, seq, ref, lev, step, pseq, reply)
	values (reboard_rseq.nextval, ?, ?, 0, 0, 0, 0)
select * from dual;

-- �Խñ� ������
select 	b.seq, b.id, b.name, b.email, b.subject, 
		b.content, b.hit, b.logtime, b.bcode,
		r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply 
from board b, reboard r
where b.seq = r.seq
and b.seq = ?;

-- �Խ��� ����Ʈ(���)
-- 3�������� ��� ���. >> 41 - 60
-- ����
-- 3���Խ���
-- 20��/1������
-- ���þ���   12:34:54
-- ���þ��� x 17.06.13
select b.*
from (
	select rownum rn, a.*
	from (
		select 	b.seq, b.id, b.name, b.email, b.subject, 
				b.content, b.hit, b.bcode,
				decode(to_char(logtime, 'yymmdd'), 
							to_char(sysdate, 'yymmdd'), to_char(logtime, 'hh24:mi:ss'), 
							to_char(logtime, 'yy.mm.dd')) logtime,
				r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply 
		from board b, reboard r
		where b.seq = r.seq
		and b.bcode = ?
		order by b.seq desc
		) a
	where rownum <= ?
	) b
where b.rn > ?


-- ���ۼ�
select count(seq) 
from board
where bcode = 3
and to_char(logtime, 'yymmdd') = to_char(sysdate, 'yymmdd');

-- ��ü�ۼ�
select count(seq) 
from board
where bcode = 3;






