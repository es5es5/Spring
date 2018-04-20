create table apr20_menu(
	m_name varchar2(10 char) primary key,
	m_price number(5) not null
);

insert into apr20_menu values('ÂüÄ¡ººÀ½¹ä', 6000);
insert into apr20_menu values('±èÄ¡ººÀ½¹ä', 7000);
insert into apr20_menu values('ÂüÄ¡±èÄ¡ººÀ½¹ä', 8000);

select * from APr20_MENU;