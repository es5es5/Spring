create table apr20_menu(
	m_name varchar2(10 char) primary key,
	m_price number(5) not null
);

insert into apr20_menu values('��ġ������', 6000);
insert into apr20_menu values('��ġ������', 7000);
insert into apr20_menu values('��ġ��ġ������', 8000);

select * from APr20_MENU;

create table apr23_student(
	s_name varchar(10 char) not null,
	s_kor number(3) not null,
	s_eng number(3) not null,
	s_mat number(3) not null
);

insert into apr23_student values('ȫ�浿', 100, 40, 50);

select * from apr23_student;