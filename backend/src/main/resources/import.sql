-- Creacion de nuevos clientes

INSERT INTO clientes(apellido,create_date,email,nombre) values ('bravo',now(),'jose@gmail.com','jose');
INSERT INTO clientes(apellido,create_date,email,nombre) values ('condori',now(),'edson@gmail.com','edson');

-- Creacion de nuevos usuarios

INSERT INTO usuarios(enabled,password,username,nombre,apellido,email) VALUES (1,'$2a$10$AGpLIM9lbuMB.pQlfwMgseZmYBTE7TZOu1QuXfTxAwyoXxZgcLwTC','user','jose','bravo','bravo@gmail.com');
 
INSERT INTO usuarios(enabled,password,username,nombre,apellido,email) VALUES (1,'$2a$10$AGpLIM9lbuMB.pQlfwMgseZmYBTE7TZOu1QuXfTxAwyoXxZgcLwTC','admin','javier','unaj','javier@gmail.com');

-- Set de Roles por Usuarios

INSERT INTO roles(nombre) values ('ROLE_USER');
INSERT INTO roles(nombre) values ('ROLE_ADMIN');

-- Set Relacion Rol-Usuario

INSERT INTO usuarios_roles(usuario_id,role_id) values (1,1);
INSERT INTO usuarios_roles(usuario_id,role_id) values (2,2);
INSERT INTO usuarios_roles(usuario_id,role_id) values (2,1);