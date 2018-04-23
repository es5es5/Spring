create table apr20_menu(
	m_name varchar2(10 char) primary key,
	m_price number(5) not null
);

insert into apr20_menu values('ÂüÄ¡ººÀ½¹ä', 6000);
insert into apr20_menu values('±èÄ¡ººÀ½¹ä', 7000);
insert into apr20_menu values('ÂüÄ¡±èÄ¡ººÀ½¹ä', 8000);

select * from APr20_MENU;

create table apr23_student(
	s_name varchar(10 char) not null,
	s_kor number(3) not null,
	s_eng number(3) not null,
	s_mat number(3) not null
);

insert into apr23_student values('È«±æµ¿', 100, 40, 50);

select * from apr23_student;