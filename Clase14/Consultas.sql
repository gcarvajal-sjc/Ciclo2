-- Consultas basicas
SELECT * FROM Lider; --Todas las filas y columnas

SELECT Nombre,
       Ciudad_Residencia,
       Cargo
FROM Lider;  --Algunas columans y todas las filas

-- Ciertas columnas, ciertas filas
-- Requerimiento: Nombre y Ciudad_Residencia de los gerentes

SELECT Nombre,
       Ciudad_Residencia,
       Cargo
FROM Lider
WHERE Cargo = "Gerente" AND 
(Ciudad_Residencia = "Barranquilla"
 OR
 Ciudad_Residencia = "Bucaramanga");
 
SELECT Nombre, Cargo, Salario * 0.10 as Impuesto 
FROM Lider;

SELECT Nombre, Cargo, Salario * 0.10 as Impuesto 
FROM Lider
WHERE Cargo = "Asesor"
ORDER BY Nombre ASC
LIMIT 10;

SELECT Nombre || ' ' ||            
       Primer_Apellido || ' ' ||
       Segundo_Apellido as Nombre_Completo,
       Salario
FROM Lider;


--- Requerimientos sobre Reto3 ._ Conceptos de consultas SQL

-- Generar los correos electronicos de los lideres de los proyectos 
-- proyectos con el siguiente formato y arrojarlos ordenados por longitud de forma descendente.
-- La columna resultante como email_lider:
-- 1. la primera letra del nombre en miniscula
-- 2. un punto
-- 3.  Primer apellido
-- 4. Colocar el ID_Lider
-- 5. Dominio @empresa.com.co

-- Extraer pedazos de cadena:
SELECT SUBSTR(Lider.Nombre, 1, 3) as Pedazo_Nombre,
       Lider.Nombre
FROM Lider;

SELECT LOWER(SUBSTR(Lider.Nombre, 1, 1)) as Inicial,
       Lider.Nombre
FROM Lider;

--- Respuesta al requerimiento
SELECT LOWER(SUBSTR(Lider.Nombre, 1, 1)) || "." || 
       Lider.Primer_Apellido || Lider.ID_Lider || 
       "@empresa.com.co" AS email_lider
FROM Lider
ORDER BY LENGTH(email_lider) DESC;

--- Sin ordenar por longitud de correo generado
SELECT LOWER(SUBSTR(Lider.Nombre, 1, 1)) || "." || 
       Lider.Primer_Apellido || Lider.ID_Lider || 
       "@empresa.com.co" AS email_lider
FROM Lider;

-- Revision de la consulta
SELECT LOWER(SUBSTR(Lider.Nombre, 1, 1)) || "." || 
       Lider.Primer_Apellido || Lider.ID_Lider || 
       "@empresa.com.co" AS email_lider,
       Lider.Nombre,
       Lider.Primer_Apellido,
       Lider.ID_Lider
FROM Lider
ORDER BY LENGTH(email_lider) DESC;


-- Variante sacando la porcion final del apellidoparalo
-- lo de 1, 1 en linea 83 is donde arranca y donde termina (osea inicio y cuantas poscisiones desde el inicio)
SELECT LOWER(SUBSTR(Lider.Nombre, 1, 1)) || "." || 
       SUBSTR(Lider.Primer_Apellido , LENGTH(Lider.Primer_Apellido)-2,3)
       || Lider.ID_Lider || 
       "@empresa.com.co" AS email_lider,
       Lider.Nombre,
       Lider.Primer_Apellido,
       Lider.ID_Lider
FROM Lider
ORDER BY LENGTH(email_lider) DESC;


-- Obtener promedio que involucre fechas 
-- RQ: Edad promedio de los lideres redondeada.
-- Calcular edades de los lideres
SELECT DATETIME('now') -  Lider.Fecha_Nacimiento AS Edad_Lider,
       Lider.Nombre,
       Lider.Fecha_Nacimiento
FROM Lider;

-- Requerimiento edad promedio
SELECT ROUND(AVG(DATETIME('now') -  Lider.Fecha_Nacimiento)) AS Promedio_Lider
FROM Lider;

SELECT * FROM Proyecto LIMIT 10;

--Los JOIN es unir tablas por puntos donde haya coincidencias o donde no haya coincidencias
--JOIN -> Ampliar entidades -> Contrario a normalizar.
-- www.w3schools.com/sql/sql_join.asp
-- p y t abajo en linea 113 y 114  son un alias para tablas proyecto y tipo. Los alias se ponen para que quede mas corto

SELECT * FROM Proyecto p 
JOIN Tipo t ON 
p.ID_Tipo = t.ID_Tipo
LIMIT 10;

-- Este es el mismo de arriba pero sin alias
SELECT * FROM Proyecto
JOIN Tipo ON
Proyecto.ID_Tipo = Tipo.ID_Tipo;

-- Crear una proyeccion
SELECT  p.Constructora,
         p.Banco_Vinculado,
         t.Area_Max,
         t.Estrato,
         t.Financiable
FROM Proyecto p 
JOIN Tipo t ON 
p.ID_Tipo = t.ID_Tipo;

-- RQ Area promedio de los proyectos que respalda cada banco
-- Miramos agrupamiento y agregacion(-> promedio) sobre el resultado de un JOIN
-- Ranking de los bancos segun el area promedio de mayor a menor
-- AGREGACION: COUNT, AVG, SUM, MIN, MAX, TOTAL (aggregations functions sqlite)
-- Una agrupacion nunca va a tener sentido si yo no hago una funcion de agregacion
-- y la funcion de agregacion siempre me convierte N registros en un registro
-- por ejemplo aca agrupamos por banco

SELECT p.Banco_Vinculado,
       AVG(t.Area_Max) AS Area_Promedio_Proyectos,
       COUNT(*) AS Numero_Proyectos
FROM Proyecto p 
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo
GROUP BY p.Banco_Vinculado
ORDER BY Area_Promedio_Proyectos DESC;


SELECT p.Banco_Vinculado,
       AVG(t.Area_Max) AS Area_Promedio_Proyectos,
       COUNT(*) AS Numero_Proyectos,
FROM Proyecto p 
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo
GROUP BY p.Banco_Vinculado
ORDER BY Numero_Proyectos DESC;

SELECT p.Banco_Vinculado,
       AVG(t.Area_Max) AS Area_Promedio_Proyectos,
       COUNT(*) AS Numero_Proyectos,
FROM Proyecto p 
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo
GROUP BY p.Banco_Vinculado
ORDER BY Numero_Proyectos DESC, Area_Promedio_Proyectos DESC; -- Ordera por entries(criterios), primer entry por numero de proyectos, segundo entry para desempatar y ponga el area mas grande de primera

SELECT p.Banco_Vinculado,
       AVG(t.Area_Max) AS Area_Promedio_Proyectos,
       COUNT(*) AS Numero_Proyectos,
       -- Area_Promedio_Proyectos / Numero_Proyectos AS Indicador -- asi no funciona porque necesita anidacion porque es un campo que esta parcialmente calculado
FROM Proyecto p 
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo
GROUP BY p.Banco_Vinculado
ORDER BY Numero_Proyectos DESC;

--ANIDACION (esto es una subconsulta) Son pesadas es mejor evitar hacer esto
-- Sobre la tabla de las lineas 160 a la 167 vamos a sacar un indicador, primero tiene que estar el resultado osea la tabla del las lineas 160-167

SELECT Banco_Vinculado,
       Area_Promedio_Proyectos,
       Numero_Proyectos,
       ROUND(Area_Promedio_Proyectos / Numero_Proyectos) AS Indicador
FROM (
       SELECT p.Banco_Vinculado,
              AVG(t.Area_Max) AS Area_Promedio_Proyectos,
              COUNT(*) AS Numero_Proyectos
       FROM Proyecto p 
       JOIN Tipo t ON
       p.ID_Tipo = t.ID_Tipo
       GROUP BY p.Banco_Vinculado
       ORDER BY Numero_Proyectos DESC, Area_Promedio_Proyectos DESC 
);