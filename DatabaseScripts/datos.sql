INSERT INTO mydb.cuentabanco (id_cuenta_banco, numero_cuenta, saldo, estado_cuenta, fecha_apertura, fecha_cierre, tipo_moneda, iban, pais, sospechoso) VALUES
(1, '123456789', 5000, 1, '2022-01-01', NULL, 'USD', 'GB33BUKB20201655555555', 'United Kingdom', 1),
(2, '987654321', 10000, 0, '2021-05-20', NULL, 'EUR', 'DE89370400440532013000', 'Germany', 0),
(3, '111222333', 2500, 1, '2022-02-15', '2022-01-20', 'USD', 'US4312345678901234567890', 'United States', 1),
(4, '444555666', 500, 1, '2022-03-10', NULL, 'GBP', 'GB94BARC10206530093459', 'United Kingdom', 0),
(5, '777888999', 15000, 0, '2021-12-25', '2022-01-20', 'JPY', 'JP75251001743NXY12345', 'Japan', 1),
(6, '222333444', 2000, 1, '2022-01-20', NULL, 'USD', 'US4412345678901234566890', 'United States', 0),
(7, '555666777', 100000, 0, '2021-10-15', NULL, 'EUR', 'FR7630006000011234667890189', 'France', 0),
(8, '888999000', 7500, 1, '2022-03-20', NULL, 'CHF', 'CH9300762011623852955', 'Switzerland', 1),
(9, '333444555', 3000, 0, '2021-11-05', '2022-01-01', 'USD', 'US4412345678901221567890', 'United States', 0),
(10, '666777888', 50000, 0, '2021-09-01', NULL, 'GBP', 'GB94BARC10201530093450', 'United Kingdom', 1),
(11, 'num cuenta sin users', '99', 1, '2023-04-04', NULL, 'EUR', 'iban sin users', 'Espana', 1),
(12, '12349', 5000, 1, '2022-01-01', NULL, 'USD', 'GB33BUK55555155', 'United Kingdom', 1),
(13, '1256789', 5000, 1, '2022-01-01', NULL, 'USD', 'GB33BUKB20201555555', 'United Kingdom', 1),
(14, '6666666', 5000, 1, '2022-01-01', NULL, 'EUR', 'ESP99999999', 'Espana', 1);
INSERT INTO mydb.direccion (id_direccion, calle, numero, puerta, ciudad, pais, cp, region, valida) VALUES
(1, 'Calle de Atocha', '15', '1A', 'Madrid', 'España', '28001', 'Comunidad de Madrid', 1),
(2, 'Rue de Rivoli', '25', '4B', 'Paris', 'Francia', '75001', 'Ile-de-France', 1),
(3, 'Baker Street', '221B', '', 'Londres', 'Reino Unido', 'NW1 6XE', 'Gran Londres', 1),
(4, 'Wagramer Strasse', '5', '14C', 'Viena', 'Austria', '1220', NULL, 1),
(5, 'Kurfürstendamm', '45', '7', 'Berlín', 'Alemania', '10709', NULL, 1),
(6, 'Plaza Mayor', '3', '', 'Salamanca', 'España', '37002', 'Castilla y León', 1),
(7, 'Piazza del Popolo', '4', '6B', 'Roma', 'Italia', '00187', 'Lazio', 1),
(8, 'Mannerheimintie', '15', '2D', 'Helsinki', 'Finlandia', '00100', NULL, 1),
(9, 'Carrer de la Portaferrissa', '14', '2A', 'Barcelona', 'España', '08002', 'Cataluña', 1);
 
INSERT INTO mydb.empresa (id_empresa, cif, nombre, Direccion_id_direccion,cuenta_empresa_id_cuenta_banco) VALUES
(1, 'A12345678', 'Amazon', 1,1),
(2, 'B87654321', 'Riot', 2,2),
(3, 'C98765432', 'Mojang', 2,3),
(4, 'F54852684', 'Nintendo', 2,4),
(5, 'F98765432', 'Jetbrains', 3,5),
(6, 'Q74782197', 'Tesla', 3,6),
(7, 'Y87245661', 'Apple', 3,7),
(8, 'U65846584', 'Microsoft', 3,8),
(9, 'Y3535353535', 'Fanta', 3,9),
(10, 'T666666663', 'HP', 3,10);

INSERT INTO mydb.cambiodivisa (id_cambio_divisa, moneda_venta, moneda_compra, cantidad_compra, cantidad_venta) VALUES
(1, 'EUR', 'USD', 1000, 1120),
(2, 'EUR', 'JPY', 1000, 1510),
(3, 'EUR', 'GBP', 1000, 890),
(4, 'USD', 'EUR', 1120, 1000),
(5, 'USD', 'JPY', 1000, 740),
(6, 'USD', 'GBP', 1000, 790),
(7, 'GBP', 'EUR', 890, 1000),
(8, 'GBP', 'USD', 790, 1000),
(9, 'GBP', 'JPY', 1000, 590),
(10, 'JPY', 'EUR', 1510, 1000),
(11, 'JPY', 'GBP', 590, 1000),
(12, 'JPY', 'USD', 740, 1000);


INSERT INTO mydb.pago (moneda, cantidad, iban_beneficiario) VALUES
('EUR', 100, 'GB33BUKB20201655555555'),
('GBP', 500, 'GB33BUKB20201655555555'),
('GBP', 100, 'US456789'),
('EUR', 777, 'FR7630006000011234667890189'),
('EUR', 888, 'US4412345678901221567890'),
('USD', 125,'DE89370400440532013000'),
('USD', 819,'DE89370400440532013000');


INSERT INTO mydb.transaccion (fecha_instruccion, fecha_ejecucion, cuenta_banco_id_cuenta_banco, cambio_divisa_id_cambio_divisa, Pago_id_pago,id_usuario_actor) VALUES
('2022-04-20', NULL, 1, null, 7,1),
('2023-04-19', '2023-04-20', 2, null, 6,2),
('2023-04-18', '2023-04-19', 3, null, 5,3),
('2023-04-20', NULL, 1, null, 4,1),
('2023-04-20', NULL, 1, null, 3,1),
('2023-04-20', NULL, 1, 4, null,1),
('2023-04-18', '2023-04-19', 3, 7, null,3),
('2023-04-18', '2023-04-19', 3, null, 2,3),
('2023-04-18', '2023-04-19', 13, null, 1,13),
('2023-04-18', '2023-04-19', 13, 4, null,18),
('2023-04-18', '2023-04-19', 13, 1, null,13);

INSERT INTO mydb.usuario (nif, nombre, segundo_nombre, primer_apellido, segundo_apellido, fecha_nacimiento, contrasena, fecha_inicio, cuenta_banco_id_cuenta_banco, Empresa_id_empresa, Direccion_id_direccion, tipo_usuario, estado_usuario, tipo_persona_relacionada) VALUES
('12345678A', 	'John', 	'William', 		'Doe', 			'Smith', '1990-01-01', 		'password123', '2022-01-01',	1, 1, 1, 'cliente', 'activo', NULL),
('23456789B', 	'Jane',	 	NULL, 			'Doe', 			'Garcia', '1985-05-05', 	'password456', '2022-01-01',	2, 2, 2, 'socio', 'activo', NULL),
('34567890C', 	'David', 	'Edward', 		'Brown', 		NULL, '1995-03-15', 		'password789', '2022-01-01',	3, 3, 3, 'socio', 'inactivo', NULL),
('45678901D', 	'Sarah', 	NULL, 			'Johnson', 		NULL, '1998-11-25', 		'passwordabc', '2022-01-01',	4, 4, 4, 'socio', 'activo', 'desbloqueada'),
('56789012E', 	'Alex', 	'Robert', 		'Wilson', 		'Perez', '1992-07-10', 		'passworddef', '2022-01-01',	5, 5, 5, 'socio', 'inactivo', NULL),
('67890123F', 	'Lisa', 	'Anne', 		'Anderson', 	'Lopez', '1980-12-30', 		'pass1234', '2022-01-01', 		6, 6, 6, 'cliente', 'activo', NULL),
('78901234G', 	'Mark', 	'William', 		'Taylor', 		NULL, '1991-04-20', 		'pass5678', '2022-01-01', 		7, 7, 7, 'socio', 'activo', NULL),
('89012345H', 	'Emily', 	'Marie', 		'Davis', 		'Gomez', '1982-08-05', 		'pass9012', '2022-01-01', 		8, 8, 8, 'cliente', 'inactivo', NULL),
('90123456I', 	'Mike',		NULL, 			'Miller', 		'Fernandez', '1987-06-12', 	'passabcd', '2022-01-01', 		9, 9, 9, 'cliente', 'activo', NULL),
('01234567J', 	'Samantha', 'Louise', 		'Hernandez', 	NULL, '2000-02-18', 		'passdefg', '2022-01-01', 		10, 10, 7, 'cliente', 'inactivo', NULL),
('T12345678', 	'Maria', 	'Luisa', 		'Garcia', 		'Perez', '2000-01-15', 		'mypassword', '2022-01-01', 	1, 2, 3, 'cliente', 'activo', NULL),
('B23456789', 	'Lucas', 	NULL, 			'Martinez', 	'Gutierrez', '1987-07-23', 	'mypass', '2021-08-01', 		4, 1, 5, 'socio', 'inactivo', NULL),
('A34567890', 	'Sofia', 	NULL, 			'Diaz', 		'Garcia', '1999-12-05', 	'mypwd', '2023-04-15', 			3, 4, 6, 'socio', 'activo', 'desbloqueada'),
('C45678901', 	'Juan', 	NULL, 			'Alvarez', 		'Hernandez', '1980-03-12', 	'mysecret', '2022-10-20', 		2, 5, 7, 'socio', 'activo', NULL),
('K56789012', 	'Pablo', 	'Enrique', 		'Romero', 		'Gonzalez', '1995-05-31', 	'pass123', '2023-01-01', 		5, 3, 8, 'cliente', 'activo', NULL),
('Z67890123', 	'Julia', 	NULL, 			'Ortega', 		'Sanchez', '2002-08-19', 	'mypassword', '2021-02-15', 	1, 2, 9, 'cliente', 'inactivo', 'desbloqueada'),
('D78901234', 	'Eva', 		'Maria', 		'Fernandez', 	'Perez', '1985-11-20', 		'mypasswd', '2022-03-05', 		4, 1, 1, 'autorizado', 'activo', 'desbloqueada'),
('E89012345', 	'Miguel', 	'Angel', 		'Gutierrez', 	'Santos', '1998-06-28', 	'mypassword123', '2023-05-01', 	3, 4, 7, 'socio', 'activo', 'desbloqueada'),	
('G90123456', 	'Alejandro',NULL, 			'Navarro', 		'Rodriguez', '1982-02-02', 	'mypass123', '2022-09-10', 		2, 5, 1, 'autorizado', 'activo', 'desbloqueada'),
('H01234567', 	'Ana', 		'Maria', 		'Castro', 		'Garcia', '1990-09-09', 	'mysecret123', '2023-02-14', 	5, 3, 1, 'asistente', 'inactivo','desbloqueada'),
('12345678V', 	'ed', 		'ed', 			'ed', 			'ed', '1990-09-09', 		'password123', '2023-02-14', 	1, 2, 3, 'asistente', 'activo', 'desbloqueada'),
('22222222A', 	'Manolo', 	NULL, 			'Bonilla',		'Pérez', '1991-09-11', 		'123', '2023-04-25', 			14, NULL, 1, 'cliente', 'activo', null),
('22222222B', 	'Martín', 	NULL, 			'Bonilla',		'Pérez', '1991-09-11', 		'123', '2023-04-25', 			14, NULL, 1, 'cliente', 'pendiente', null),
('22222222C', 	'Morad', 	NULL, 			'Bonilla',		'Pérez', '1991-09-11', 		'123', '2023-04-25', 			14, NULL, 1, 'cliente', 'bloqueado', null),
('22222222D', 	'Manuel', 	NULL, 			'Bonilla',		'Pérez', '1991-09-11', 		'123', '2023-04-25', 			14, NULL, 1, 'cliente', 'inactivo', null),
('11111111A', 	"Antonio", 	NULL, 			"Ortega", 		NULL, '2001-04-22', 		'123', '2023-04-22', 			NULL, NULL, 1, 'cliente', 'pendiente', 'desbloqueada'),
('11111111A', 	"Antonio", 	NULL, 			"Ortega", 		NULL, '2001-04-22', 		'123', '2023-04-22', 			NULL, 1, 1, 'socio', 'pendiente', NULL),
('11111111A', 	"Antonio", 	NULL, 			"Ortega", 		NULL, '2001-04-22', 		'123', '2023-04-22', 			1, 1, 1, 'socio', 'bloqueado', NULL);


INSERT INTO mydb.peticion (id_peticion, tipo_peticion, fecha_peticion, Usuario_id_usuario, estado_peticion) VALUES
(1, "desbloqueo", "1982-08-05", 1, "aceptada"),
(2, "alta", "1982-08-05", 5, "aceptada"),
(3, "alta", "2023-04-15", 7, "denegada"),
(4, "desbloqueo", "2002-08-19", 1, "aceptada"),
(5, "desbloqueo", "2022-09-10", 1, "aceptada"),
(6, "alta", "1982-08-05", 1, "denegada"),
(7, "alta", "2023-04-15", 4, "aceptada"),
(8, "alta", "2002-08-19", 8, "aceptada"),
(9, "desbloqueo", "2022-09-10", 6, "aceptada"),
(10, "alta", "2022-09-10", 1, "aceptada"),
(11, "activar", "2020-2-20", 20, "noprocesada"),
(12, "alta", "2020-2-20", 22, "noprocesada"),
(13, "alta", "2020-2-20", 23, "noprocesada"),
(14, "activar", "2020-2-20", 21, "noprocesada"),
(15, "desbloqueo", "2020-2-20", 24, "noprocesada");