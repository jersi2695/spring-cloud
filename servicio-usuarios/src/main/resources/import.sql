INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '123456', 1, 'Administrator', 'Admin', 'admin@admin.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('jhonatan', '123456', 1, 'Jhonatan', 'España', 'jhonatan@admin.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, rol_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, rol_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, rol_id) VALUES (2, 1);