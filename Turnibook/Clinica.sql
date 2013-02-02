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
CREATE TABLE Turno (id_profesional , documento NUMERIC, telefono TEXT, asistencia TEXT, descripcion TEXT, os TEXT, nombre TEXT, hora TEXT, fecha NUMERIC);
CREATE TABLE profesional (
    "id_profesional" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    "id_horario" INTEGER NOT NULL,
    "nombre" TEXT NOT NULL,
    "clave" TEXT NOT NULL,
    "email" TEXT
);
