drop database if exists aula;
create database aula;
use aula;

 create table aluno
(
    id int primary key auto_increment,
    nome varchar(50) not null,
    dt_insercao date not null ,
    email varchar(50) unique

);

insert into aluno values (null,'Adriel Santos',now(),'adriel@gmail.com');
insert into aluno values (null,'Farmy Pereira',now(),'farmy@gmail.com');
insert into aluno values (null,'Luis Rodrigues',now(),'rodrigues@gmail.com');
insert into aluno values (null,'Rocha Barbosa',now(),'rocha@gmail.com');
insert into aluno values (null,'Smith Scoth',now(),'smith@gmail.com');

create table curso
(
    id int primary key auto_increment,
    descricao varchar (50) not null

);
insert into curso values (null,'Java web developer');
insert into curso values (null,'Angular com Spring');
insert into curso values (null,'PHP orientado a objeto');

create table aluno_curso(
    id int primary key auto_increment,
    id_aluno int not null,
    id_curso int not null,
    dt_matricula date not null
);

insert into aluno_curso values(null,1,2,now());
insert into aluno_curso values(null,1,1,now());
insert into aluno_curso values(null,2,1,now());
insert into aluno_curso values(null,2,3,now());
insert into aluno_curso values(null,3,3,now());
insert into aluno_curso values(null,3,2,now());
insert into aluno_curso values(null,4,1,now());
insert into aluno_curso values(null,5,1,now());


create or replace view vw_aluno_curso
as
select
    a.id as id_aluno,
    a.nome as nome_aluno,
    ac.dt_matricula as dt_Matricula,
    a.email as email_aluno,
    a.dt_insercao as dt_insercao_Aluno,
    c.descricao as descricao_curso
from aluno_curso ac
left join aluno a on a.id = ac.id_aluno
left join curso c on c.id = ac.id_curso
order by a.nome asc;

select * from vw_aluno_curso;
select  distinct  nome_aluno from vw_aluno_curso;