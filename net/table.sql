CREATE TABLE tblRegister(
 id VARCHAR(20) PRIMARY KEY,
 pwd CHAR(20) NOT NULL,
 name CHAR(20) NOT NULL,
 regdate DATETIME  DEFAULT NOW()
)

insert into tblRegister
values('aaa', '1234', 'ȫ�浿', NOW());

insert into tblRegister
values('bbb', '1234', '����â', NOW());

insert into tblRegister
values('ccc', '1234', '������', NOW());