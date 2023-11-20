--liquibase formatted sql

--changeset brunoestrai:1
create table cpfvalid.lista_restrita (
    cpf varchar(11) not null unique,
    created_at timestamp not null,
    constraint pk_cpf primary key (cpf)
);