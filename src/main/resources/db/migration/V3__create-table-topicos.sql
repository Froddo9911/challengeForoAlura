create table topicos(

    id biguint not null auto_increment,
    titulo varchar(255) not null unique,
    mensaje TEXT not null,
    fecha_creacion DATETIME not null,
    activo tinyint,
    autor varchar(255) not null,
    curso varchar(255) not null,

    primary key (id)
);