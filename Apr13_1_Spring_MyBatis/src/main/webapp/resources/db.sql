create table apr13_menu(
	m_no number(3) primary key,
	m_name varchar2(10 char) not null,
	m_price number(5) not null
);

create sequence apr13_menu_seq;

select * from apr13_menu;