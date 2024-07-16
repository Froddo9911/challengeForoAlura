create table post(

     id bigint not null auto_increment,
     autor varchar(100) not null,
     titulo varchar(100) not null,
     contenido varchar(500) not null,
     fecha varchar(100) not null,

     primary key(id)
);