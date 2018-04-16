create table cafe_member(
	im_id varchar2(10 char) primary key,
	im_pw varchar2(10 char) not null,
	im_name varchar2(10 char) not null,
	im_addr1 char(5 char) not null,
	im_addr2 varchar2(100 char) not null,
	im_addr3 varchar2(100 char) not null,
	im_img varchar2(200 char) not null
);


select * from cafe_member;