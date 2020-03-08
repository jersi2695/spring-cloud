INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$Ndk1HpZZqHZAL8y87rmIY.3urti4zLL0TnPrqjREkuAvEsFNHoyta', 1, 'Administrator', 'Admin', 'admin@admin.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('jhonatan', '$2a$10$czSJV2XdP0f3aU/6r3cRkeoHcggFA7x2vdSWTpZ83.Bt8I9ShLFwK', 1, 'Jhonatan', 'España', 'jhonatan@admin.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);