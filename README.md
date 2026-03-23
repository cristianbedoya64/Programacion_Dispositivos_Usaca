# 🎬 App Cine - Bedoya Marin

Proyecto final para la **Universidad Santiago de Cali (USC)**, **Facultad de Ingenieria**.

## 👨‍🎓 Datos del estudiante

- **Nombre:** Cristian Alexander Bedoya Marin
- **Programa:** Ingenieria de Sistemas (Virtual)
- **Semestre:** 9no semestre
- **Curso:** Programacion de Dispositivos Moviles
- **Docente:** Mario Sanchez Echeverri

## 🧾 Descripcion del proyecto

Aplicacion Android nativa en **Java** con vistas **XML** para la gestion de **entradas a cine**.
La informacion se almacena localmente usando **SQLiteOpenHelper** (sin Firebase, Room ni APIs).
La app funciona en **una sola pantalla (MainActivity)** y permite realizar el CRUD completo.

## ✅ Requisitos funcionales (CRUD)

- **Crear:** guardar entradas desde el formulario en SQLite.
- **Consultar:** buscar por `id` y cargar datos en pantalla.
- **Actualizar:** modificar registros usando el `id`.
- **Eliminar:** borrar por `id` y limpiar campos.

## 🗂️ Modelo de datos (tabla `entradas_cine`)

- `id` (INTEGER, PK, AUTOINCREMENT)
- `nombre_pelicula` (TEXT)
- `nombre_cine` (TEXT)
- `numero_sala` (TEXT o INTEGER)
- `fecha` (TEXT)
- `hora` (TEXT)
- `numero_entradas` (INTEGER)
- `costo_total` (REAL)
- `usuario_estudiante` (TEXT) -> **valor por defecto:** `CRISTIAN ALEXANDER BEDOYA MARIN`

## 🧱 Tecnologias

- **Lenguaje:** Java
- **UI:** XML (ConstraintLayout/ScrollView)
- **BD local:** SQLiteOpenHelper

## 🎨 Linea visual

Interfaz con estilo de cine: fondo oscuro, acentos rojos y/o dorados, campos con hints claros y
botones diferenciados para las acciones CRUD.

## 📌 Nota

Este repositorio contiene el codigo fuente del proyecto y la documentacion correspondiente
para su presentacion academica.

## ▶️ Guia de ejecucion

Consulta la guia paso a paso en [README_EJECUCION.md](README_EJECUCION.md).