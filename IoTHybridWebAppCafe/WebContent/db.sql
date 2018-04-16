create table ihwac_msg(
	im_no number(7) primary key,
	im_from varchar2(10 char) not null,
	im_to varchar2(10 char) not null,
	im_txt varchar2(350 char) not null,
	im_date date not null
);
create sequence ihwac_msg_seq;
--------------------------------------------------
create table ihwac_sns(
	is_no number(5) primary key,			-- �� ��ȣ
	is_owner varchar2(10 char) not null,	-- �۾��� id
	is_txt varchar2(350 char) not null,
	is_date date not null
);
create sequence ihwac_sns_seq;
--------------------------------------------------
create table ihwac_sns_repl(
	isr_no number(7) primary key,			-- ��� ��ȣ
	isr_is_no number(5) not null,			-- �Ҽ� �� ��ȣ
	isr_owner varchar2(10 char) not null,	-- ��� �� ���
	isr_txt varchar2(150 char) not null,	-- ��� ����
	isr_date date not null
);
create sequence ihwac_sns_repl_seq;
--------------------------------------------------
create table ihwac_member(
	im_id varchar2(10 char) primary key, 	-- id
	im_pw varchar2(10 char) not null, 		-- pw
	im_name varchar2(10 char) not null,		-- �̸�
	im_addr varchar2(10 char) not null,		-- ������
	im_birthday date not null,				-- �������
	im_img varchar2(100 char) not null		-- ����
);
select *
from ihwac_sns, ihwac_member
where is_owner = im_id
order by is_date;
--------------------------------------------------
create table ihwac_dataroom(
	id_id number(5) primary key,
	id_owner varchar2(10 char) not null,
	id_title varchar2(20 char) not null,
	id_file varchar2(200 char) not null,
	id_date date not null
);
create sequence ihwac_dataroom_seq;
--------------------------------------
create table ihwac_vote(
	iv_title varchar2(100 char) primary key,
	iv_owner varchar2(10 char) not null,
	iv_count number(3) not null
);
insert into ihwac_vote values('�׽�Ʈ', 'kwon', 0);
------------------------------------------
create table ihwac_vote_item(
	ivi_no number(9) primary key,	-- ��ǥ �׸� ��ȣ
	ivi_item varchar2(150 char) not null,
	ivi_count number(3) not null,
	ivi_percent number(5, 4) not null
);
select * from ihwac_vote_item;
--------------------------------------------------
create table ihwac_vote_vote(
	ivv_im_id varchar2(10 char) primary key,	-- ��ǥ �� ���id
	ivv_ivi_no number(9) not null			-- ��ǥ�׸� ��ȣ
);

select * from ihwac_vote_vote;









