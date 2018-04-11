create table apr11_product(
	p_no number(3) primary key,
	p_name varchar2(10 char) not null,
	p_img varchar2(100 char) not null,
	p_price number(6) not null,
	p_exp date not null
);

create sequence apr11_product_seq;

select * from apr11_product;

update apr11_product set p_price = p_price + 500 where p_price <= 12000;