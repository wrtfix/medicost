CREATE TABLE sqlite_sequence(name,seq);


CREATE TABLE horario (
    "id_horario" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "lunes_desde" TEXT,
    "lunes_hasta" TEXT,
    "martes_desde" TEXT,
    "martes_hasta" TEXT,
    "miercoles_desde" TEXT,
    "miercoles_hasta" TEXT,
    "jueves_desde" TEXT,
    "jueves_hasta" TEXT,
    "viernes_desde" TEXT,
    "viernes_hasta" TEXT,
    "sabado_desde" TEXT,
    "sabado_hasta" TEXT,
    "domingo_desde" TEXT,
    "domingo_hasta" TEXT,
    "intervalo" INTEGER
    
);
CREATE TABLE Turno (
id_profesional , documento NUMERIC, 
telefono TEXT,
asistencia TEXT,
descripcion TEXT,
os TEXT,
nombre TEXT,
hora TEXT,
fecha NUMERIC
);

CREATE TABLE profesional (
    "id_profesional" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "id_horario" INTEGER NOT NULL,
    "nombre" TEXT NOT NULL,
    "clave" TEXT NOT NULL,
    "email" TEXT
);

--Esta tabla permite calcular cuantos turnos se pueden otorgar en un determinado dia
create view tuno_intervalos as
select id_horario, (lunes_hasta-lunes_desde)*(60/intervalo) as lunes,
(martes_hasta-martes_desde)*(60/intervalo)as martes,
(miercoles_hasta-miercoles_desde)*(60/intervalo) as miercoles,
(jueves_hasta-jueves_desde)*(60/intervalo) as jueves,
(viernes_hasta-viernes_desde)*(60/intervalo) as viernes,
(sabado_hasta-sabado_desde)*(60/intervalo) as sabado,
(domingo_hasta-domingo_desde)*(60/intervalo) as domingo
 from horario;

-- Esta vista permite evaluar los turnos que fueron dados por fecha
create view turno_dados as
select count(*) as dados,fecha,id_profesional
from turno 
group by fecha;
