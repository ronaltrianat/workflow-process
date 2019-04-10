USE `workflow_process_db` ;

select * from document_types;
select * from user_status;
select * from users;

insert into document_types(document_type_id, code, description) values (1, 'CC', 'Cedula de Ciudadania');
insert into user_status(user_status_id, name, description) values (1, 'Activo', 'Activo');
insert into user_status(user_status_id, name, description) values (2, 'Inactivo', 'Inactivo');

insert into users(name, surname, age, email, fk_document_type_id, document_number,
password, fk_user_status_id, address, phone_number) 
values ('Ronal', 'Triana', 30, 'ronaltriana.t@gmail.com', 1, '1093884556', 
'$2a$10$lxjw1F6NujiIthrktf00ReBaqukdBG/gWAHNwx3Y8eSAHL.sTg3hy', 1, 'Bogota', '3002742886');


