create table apr09_product(
	p_name varchar2(10 char) primary key,
	p_price number(5) not null
);

insert into apr09_product values('°øÀ¯±â',10000);

select * from apr09_product;