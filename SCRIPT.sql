create table user (
`ID` int(11) NOT NULL AUTO_INCREMENT,
USER_EMAIL varchar(100),
USER_ENABLED BOOL,
USER_PASSWORD varchar(100),
ADMIN_ENABLED BOOL,
primary key (id)
);

insert into user(id,USER_EMAIL,USER_ENABLED,USER_PASSWORD,ADMIN_ENABLED)values(1,"abdelbaki.mahmoudi@gmail.com",true,"password@123",true);