-- www.sqlitetutorial.net
-- www.w3schools.com/sql
-- RQ1: Tres meses en los que se realizan mas compras
-- strftime function has 2 arguments (dia-mes-anio,campo a trabajar(fecha),nombre de la tabla.Fecha) 
-- Agrupacion/Agregacion: agrupar campos por Mes y a ese grupo se le hace el conteo
SELECT strftime("%m",Compra.Fecha) AS Mes,
       COUNT(*) Numero_Compras
FROM Compra
GROUP BY Mes
ORDER BY Numero_Compras DESC
LIMIT 3;
       
-- RQ2: Cual es la ciudad diferente a Bogota donde mas lideres residen

SELECT Lider.Ciudad_Residencia,
       COUNT(*) Numero_Lideres
FROM Lider
WHERE Lider.Ciudad_Residencia NOT LIKE "%Bogota%"
GROUP BY Lider.Ciudad_Residencia
ORDER BY Numero_Lideres DESC
LIMIT 1;

-- RQ3: Materiales de produccion nacional mas comprados en los proyectos, mostrando 
--      cuantas compras se han hecho de cada uno. Desempatar alfabeticamente.
--      JOIN se recomienda hacer entre el ID de la llave foranea
SELECT m.Nombre_Material, 
       m.Importado,
       COUNT(*) AS No_Compras 
FROM MaterialConstruccion AS m 
JOIN Compra c 
ON m.ID_MaterialConstruccion = c.ID_MaterialConstruccion
WHERE m.Importado NOT LIKE "Si"
GROUP BY m.ID_MaterialConstruccion
ORDER BY No_Compras DESC,
         m.Nombre_Material ASC;

-- RQ4: Los 5 proyectos donde mas compras se han realizado de Granito. Adjuntar la 
--      clasificacion del proyecto y el area maxima del tipo en el que ha sido clasificado. 
--      Las compras de granito es un campo calculado que sale del conteo de agrupar todas esas compras por el nombre del material. Es un conteo.Area_Max

SELECT p.ID_Proyecto,
       p.Clasificacion,
       t.Area_Max,
       COUNT(m.Nombre_Material) as No_Compras_Granito
FROM Proyecto p 
JOIN Compra c ON
p.ID_Proyecto = c.ID_Proyecto
JOIN MaterialConstruccion m ON
m.ID_MaterialConstruccion = c.ID_MaterialConstruccion
JOIN Tipo t ON
p.ID_Tipo = t.ID_Tipo
WHERE m.Nombre_Material LIKE "Granito"
GROUP BY p.ID_Proyecto
ORDER BY No_Compras_Granito DESC
LIMIT 5;


-- RQ5: Los dos cargos que lideran menos proyectos.
--      El numero de proyectos no existe hay que calcularlo de las agrupaciones por cargo

SELECT l.Cargo,
       COUNT(l.Cargo) AS Numero_Proyectos
FROM Lider l 
JOIN Proyecto p ON
p.ID_Lider = l.ID_Lider
GROUP BY l.Cargo
ORDER BY Numero_Proyectos
LIMIT 2;

------------- HASTA ACA VA EL RETO 3 ----------

-- El JOIN es conmutativo lo que no es conmutativo es el concepto por el cual agrupamos

SELECT l.Cargo,
       COUNT(p.ID_Proyecto) AS Numero_Proyectos
FROM Proyecto P
JOIN Lider l ON
p.ID_Lider = l.ID_Lider
GROUP BY l.Cargo
ORDER BY Numero_Proyectos
LIMIT 2;


-- RQ2.1: Para mostrar el uso del HAVING. Solamente presentar las ciudades diferentes a Bogota donde el numbero de lideres oscila entre 2 y 5
SELECT Lider.Ciudad_Residencia,
       COUNT(*) Numero_Lideres
FROM Lider
WHERE Lider.Ciudad_Residencia NOT LIKE "%Bogota%"
GROUP BY Lider.Ciudad_Residencia
HAVING Numero_Lideres BETWEEN 2 AND 5
ORDER BY Numero_Lideres DESC
LIMIT 10;