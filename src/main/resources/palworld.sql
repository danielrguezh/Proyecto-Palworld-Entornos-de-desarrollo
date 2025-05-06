DROP TABLE IF EXISTS Personaje;
DROP TABLE IF EXISTS Arma;
DROP TABLE IF EXISTS Pal;
DROP TABLE IF EXISTS Material;
DROP TABLE IF EXISTS HabilidadPal;

CREATE TABLE Personaje (
    personaje_id TEXT PRIMARY KEY,
    usuario TEXT
);
CREATE TABLE Arma (
    nombre TEXT PRIMARY KEY,
    danio INTEGER,
    cargador INTEGER,
    personaje_id TEXT,
    FOREIGN KEY (personaje_id) REFERENCES Personaje(personaje_id)
);
CREATE TABLE Pal (
    pal_id TEXT PRIMARY KEY,
    nombre TEXT,
    elemento TEXT,
    hp INTEGER,
    atk INTEGER,
    def INTEGER,
    personaje_id TEXT,
    FOREIGN KEY (personaje_id) REFERENCES Personaje(personaje_id)
);

CREATE TABLE Material (
    nombre TEXT,
    cantidad INTEGER,
    personaje_id TEXT,
    PRIMARY KEY (nombre),
    FOREIGN KEY (personaje_id) REFERENCES Personaje(personaje_id)
);
CREATE TABLE HabilidadPal (
    nombre TEXT PRIMARY KEY,
    descripcion TEXT,
    pal_id TEXT,
    FOREIGN KEY (pal_id) REFERENCES Pal(pal_id)
);
-- Inserción en la tabla Personaje
INSERT INTO Personaje (personaje_id, usuario) VALUES ('P001','YO');
INSERT INTO Personaje (personaje_id, usuario) VALUES ('P002','YO');
INSERT INTO Personaje (personaje_id, usuario) VALUES ('P003','otro');
INSERT INTO Personaje (personaje_id, usuario) VALUES ('P004','otro');

-- Inserción en la tabla Arma
INSERT INTO Arma (nombre, danio, cargador, personaje_id) VALUES ('Espada', 50, 1, 'P001');
INSERT INTO Arma (nombre, danio, cargador, personaje_id) VALUES ('Lanza', 60, 1, 'P002');
INSERT INTO Arma (nombre, danio, cargador, personaje_id) VALUES ('Arco', 40, 1, 'P003');
INSERT INTO Arma (nombre, danio, cargador, personaje_id) VALUES ('Hacha', 70, 2, 'P004');
INSERT INTO Arma (nombre, danio, cargador, personaje_id) VALUES ('Daga', 30, 3, 'P001');
INSERT INTO Arma (nombre, danio, cargador, personaje_id) VALUES ('Martillo', 80, 4, 'P002');

-- Inserción en la tabla Pal
INSERT INTO Pal (pal_id, nombre, elemento, hp, atk, def, personaje_id) VALUES ('PAL001', 'Dragón', 'Fuego', 100, 50, 30, 'P001');
INSERT INTO Pal (pal_id, nombre, elemento, hp, atk, def, personaje_id) VALUES ('PAL002', 'Fénix', 'Fuego', 120, 55, 35, 'P002');
INSERT INTO Pal (pal_id, nombre, elemento, hp, atk, def, personaje_id) VALUES ('PAL003', 'Golem', 'Tierra', 200, 70, 50, 'P003');
INSERT INTO Pal (pal_id, nombre, elemento, hp, atk, def, personaje_id) VALUES ('PAL004', 'Sirena', 'Agua', 90, 60, 40, 'P004');
INSERT INTO Pal (pal_id, nombre, elemento, hp, atk, def, personaje_id) VALUES ('PAL005', 'Grifo', 'Aire', 150, 65, 45, 'P001');
INSERT INTO Pal (pal_id, nombre, elemento, hp, atk, def, personaje_id) VALUES ('PAL006', 'Minotauro', 'Tierra', 180, 80, 55, 'P002');

-- Inserción en la tabla Material
INSERT INTO Material (nombre, cantidad, personaje_id) VALUES ('Hierro', 10, 'P001');
INSERT INTO Material (nombre, cantidad, personaje_id) VALUES ('Madera', 15, 'P002');
INSERT INTO Material (nombre, cantidad, personaje_id) VALUES ('Acero', 20, 'P001');
INSERT INTO Material (nombre, cantidad, personaje_id) VALUES ('Oro', 5, 'P002');
INSERT INTO Material (nombre, cantidad, personaje_id) VALUES ('Plata', 12, 'P003');
INSERT INTO Material (nombre, cantidad, personaje_id) VALUES ('Bronce', 8, 'P004');

-- Inserción en la tabla HabilidadPal
INSERT INTO HabilidadPal (nombre, descripcion, pal_id) VALUES ('Aliento de Fuego', 'Lanza fuego', 'PAL001');
INSERT INTO HabilidadPal (nombre, descripcion, pal_id) VALUES ('Renacimiento', 'Resucita', 'PAL002');
INSERT INTO HabilidadPal (nombre, descripcion, pal_id) VALUES ('Golpe de Tierra', 'Ataque poderoso de tierra', 'PAL003');
INSERT INTO HabilidadPal (nombre, descripcion, pal_id) VALUES ('Canto de Sirena', 'Encanta a los enemigos', 'PAL004');
INSERT INTO HabilidadPal (nombre, descripcion, pal_id) VALUES ('Ráfaga de Viento', 'Ataque de aire', 'PAL005');
INSERT INTO HabilidadPal (nombre, descripcion, pal_id) VALUES ('Carga Brutal', 'Ataque físico potente', 'PAL006');
