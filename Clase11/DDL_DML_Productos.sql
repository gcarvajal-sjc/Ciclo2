-- Description de la estructura de la tabla de la empresa

CREATE TABLE Empresa (
    ID_Empresa INTEGER NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    NIT VARCHAR(15) NOT NULL UNIQUE,
    Fecha_Inicio DATETIME NOT NULL,
    Antiguedad INTEGER GENERATED ALWAYS AS(DATETIME('2021-01-01') - Fecha_Inicio),
    PRIMARY KEY (ID_Empresa)
);

-- Lo de () en linea 13 es una tupla, cada elemento es una fila
-- los elementos se difencian porque esa fila tiene al menos una o muchas diferencias
INSERT INTO Empresa (Nombre, NIT, Fecha_Inicio) VALUES ('Variedades12', '12345-6', '2010-05-12');
INSERT INTO Empresa (ID_Empresa, Nombre, NIT, Fecha_Inicio) VALUES (400, 'OtraEmpresa', '12345-7', '2000-05-12');
INSERT INTO Empresa (Nombre, NIT, Fecha_Inicio) VALUES ('OtraEmpresa2', '12345-8', '1990-05-12');


CREATE TABLE Proveedor(
    ID_Proveedor INTEGER NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Direccion VARCHAR(30) NOT NULL,
    NIT VARCHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY (ID_Proveedor)
);

INSERT INTO Proveedor (Nombre, Direccion, NIT) VALUES ('SuministrosColombia', 'Calle 12 Bogota', '34567-7');
INSERT INTO Proveedor (Nombre, Direccion, NIT) VALUES ('SOLOlombia', 'Calle 121 Bogota', '34567-8');


CREATE TABLE Producto(
    ID_Producto INTEGER NOT NULL,
    Nombre VARCHAR(30) NOT NULL, 
    Codigo VARCHAR(20) NOT NULL UNIQUE,
    Precio_Unitario INTEGER NOT NULL,
    Impuesto REAL GENERATED ALWAYS AS(Precio_Unitario * 0.19),
    ID_Empresa INTEGER NOT NULL,
    ID_Proveedor INTEGER NOT NULL,
    PRIMARY KEY (ID_Producto),
    FOREIGN KEY (ID_Empresa) REFERENCES Empresa(ID_Empresa),
    FOREIGN KEY (ID_Proveedor) REFERENCES Proveedor(ID_Proveedor)
);