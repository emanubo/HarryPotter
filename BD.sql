CREATE DATABASE indigo;

create table if not exists usuario (
    id bigint,
    username varchar(50) not null,
    password varchar(100) not null,
    role varchar(10) not null,
    primary key (id),
    unique key username (username)
);	

create table if not exists producto (
    id_producto int(11) not null auto_increment,
    nombre_producto varchar(300) default null,
	descripcion varchar(255) default null,
    precio double (19,4) default null,
	nombre_categoria varchar(100) default null,
    primary key (id_producto)  
);

create table if not exists category (
    id bigint,
    name varchar(100) not null,
    parentid bigint,
    primary key (id),
    foreign key (parentid) references category(id)
);

create table if not exists product_category (
    productid bigint,
    categoryid bigint,
    primary key (productid, categoryid),
    foreign key (categoryid) references category(id)
);

db.url= jdbc:mysql://localhost:3306/indigo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
