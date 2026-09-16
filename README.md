<div align="center">

# 🚀 Laboratorio VI — APIs REST

### Programación II · Java + Spring Boot + Swagger/OpenAPI

<p>
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk" alt="Java">
  <img src="https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen?style=for-the-badge&logo=springboot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge&logo=swagger" alt="Swagger">
  <img src="https://img.shields.io/badge/Git-GitHub-black?style=for-the-badge&logo=github" alt="GitHub">
  <img src="https://img.shields.io/badge/JSON-API-blue?style=for-the-badge&logo=json" alt="JSON">
</p>

</div>

---

## 📚 Descripción

Este repositorio contiene el desarrollo del **Laboratorio VI de Programación II**, cuyo objetivo es reforzar los conocimientos adquiridos en el **Módulo II** mediante la creación y desarrollo de **APIs REST**.

El laboratorio se divide en dos etapas:

* 🎨 **Diseño de APIs utilizando Swagger/OpenAPI**
* 💻 **Desarrollo de APIs utilizando Java y Spring Boot**

Las APIs utilizan **JSON** como formato para el intercambio de información y **listas en memoria** para almacenar los datos.

---

## 🎯 Objetivo

Reforzar los conocimientos adquiridos en el Módulo II mediante la resolución de ejercicios prácticos similares a los que serán evaluados en el segundo parcial.

Al finalizar el laboratorio se busca desarrollar la capacidad para:

* Diseñar APIs REST.
* Definir endpoints correctamente.
* Utilizar métodos HTTP.
* Trabajar con códigos de estado HTTP.
* Crear APIs utilizando Spring Boot.
* Organizar proyectos mediante una estructura por capas.
* Intercambiar información utilizando JSON.
* Utilizar Git y GitHub para el control de versiones.

---

## 🛠️ Tecnologías utilizadas

| Tecnología           | Uso                            |
| -------------------- | ------------------------------ |
| ☕ Java               | Lenguaje de programación       |
| 🌱 Spring Boot       | Desarrollo de APIs REST        |
| 📄 Swagger / OpenAPI | Diseño y documentación de APIs |
| 🔗 JSON              | Intercambio de información     |
| 🧪 Postman           | Pruebas de endpoints           |
| 🔧 Git               | Control de versiones           |
| 🐙 GitHub            | Repositorio del proyecto       |

---

# 📂 Estructura del proyecto

```text
LaboratorioVI/
│
├── ejercicio-1/
│   └── biblioteca-api.yaml
│
├── ejercicio-2/
│   └── cursos-api.yaml
│
├── ejercicio-3/
│   └── reservas-api.yaml
│
├── ejercicio-4/
│   └── biblioteca-api/
│
├── ejercicio-5/
│   └── cursos-api/
│
├── ejercicio-6/
│   └── reservas-api/
│
└── README.md
```

---

# 🎨 Diseño — Swagger/OpenAPI

## 📖 Ejercicio 1 — API de Biblioteca

Diseño de una API REST para administrar los libros de una biblioteca.

### 📌 Modelo `Libro`

```text
id
titulo
autor
isbn
anioPublicacion
estado
```

### 🔗 Endpoints

| Método   | Endpoint                  | Descripción                |
| -------- | ------------------------- | -------------------------- |
| `POST`   | `/libros`                 | Registrar libro            |
| `GET`    | `/libros`                 | Consultar libros           |
| `GET`    | `/libros/titulo/{titulo}` | Consultar libro por título |
| `PUT`    | `/libros/{id}`            | Actualizar libro           |
| `DELETE` | `/libros/{id}`            | Eliminar libro             |

### 📄 Archivo OpenAPI

```text
ejercicio-1/biblioteca-api.yaml
```

---

## 🎓 Ejercicio 2 — API de Cursos Universitarios

Diseño de una API REST para administrar cursos universitarios.

### 📌 Modelo `Curso`

```text
id
nombre
codigo
creditos
estado
```

### 🔗 Endpoints

| Método   | Endpoint                  | Descripción                |
| -------- | ------------------------- | -------------------------- |
| `POST`   | `/cursos`                 | Crear curso                |
| `GET`    | `/cursos`                 | Consultar cursos           |
| `GET`    | `/cursos/codigo/{codigo}` | Consultar curso por código |
| `PUT`    | `/cursos/{id}`            | Actualizar curso           |
| `DELETE` | `/cursos/{id}`            | Eliminar curso             |

### 📄 Archivo OpenAPI

```text
ejercicio-2/cursos-api.yaml
```

---

## 🏨 Ejercicio 3 — API de Reservas de Hotel

Diseño de una API REST para administrar las reservas de un hotel.

### 📌 Modelo `Reserva`

```text
id
nombreCliente
habitacion
fechaEntrada
fechaSalida
estado
```

### 🔗 Endpoints

| Método   | Endpoint         | Descripción              |
| -------- | ---------------- | ------------------------ |
| `POST`   | `/reservas`      | Crear reserva            |
| `GET`    | `/reservas`      | Consultar reservas       |
| `GET`    | `/reservas/{id}` | Consultar reserva por ID |
| `PUT`    | `/reservas/{id}` | Actualizar reserva       |
| `DELETE` | `/reservas/{id}` | Cancelar reserva         |

### 📄 Archivo OpenAPI

```text
ejercicio-3/reservas-api.yaml
```

---

# 💻 Desarrollo — Java + Spring Boot

## 📖 Ejercicio 4 — API de Biblioteca

Implementación en **Java + Spring Boot** de la API diseñada en el Ejercicio 1.

### Características

* API REST.
* Arquitectura organizada por capas.
* Datos almacenados en listas en memoria.
* Intercambio de información mediante JSON.
* Operaciones CRUD.
* Pruebas mediante Postman.

### Capas

```text
Controller
    ↓
Service
    ↓
Repository / Data
    ↓
Model
```

---

## 🎓 Ejercicio 5 — API de Cursos

Implementación en **Java + Spring Boot** de la API diseñada en el Ejercicio 2.

### Características

* API REST.
* Arquitectura por capas.
* Lista en memoria.
* JSON.
* Operaciones CRUD.
* Consulta de cursos mediante código.
* Pruebas mediante Postman.

---

## 🏨 Ejercicio 6 — API de Reservas

Implementación en **Java + Spring Boot** de la API diseñada en el Ejercicio 3.

### Características

* API REST.
* Arquitectura por capas.
* Lista en memoria.
* JSON.
* Creación de reservas.
* Consulta de reservas.
* Actualización de reservas.
* Cancelación de reservas.
* Pruebas mediante Postman.

---

# 🌐 Códigos HTTP utilizados

| Código | Significado           | Uso                                            |
| ------ | --------------------- | ---------------------------------------------- |
| `200`  | OK                    | Solicitud procesada correctamente              |
| `201`  | Created               | Recurso creado correctamente                   |
| `204`  | No Content            | Operación realizada sin contenido de respuesta |
| `400`  | Bad Request           | Datos enviados incorrectamente                 |
| `404`  | Not Found             | Recurso no encontrado                          |
| `500`  | Internal Server Error | Error interno del servidor                     |

---

# 🧪 Pruebas

Las APIs desarrolladas serán probadas utilizando **Postman**.

Las operaciones principales a validar son:

```text
GET     → Consultar información
POST    → Crear información
PUT     → Actualizar información
DELETE  → Eliminar información
```

Las pruebas deben verificar:

* ✔️ Respuestas correctas.
* ✔️ Códigos HTTP adecuados.
* ✔️ Datos enviados mediante JSON.
* ✔️ Consulta de recursos existentes.
* ✔️ Manejo de recursos inexistentes.

---

# 🔧 Control de versiones

El desarrollo del laboratorio utiliza **Git Bash** y **GitHub**.

Los commits deben utilizar mensajes claros y descriptivos.

### Ejemplos

```bash
git add .

git commit -m "Agrega diseño de API de biblioteca"

git commit -m "Implementa API de libros"

git commit -m "Agrega endpoints de cursos"

git commit -m "Implementa API de reservas"

git push
```

---

# 📸 Evidencias

Para cada ejercicio se deben presentar evidencias del correcto funcionamiento.

### Ejercicio 1

* Diseño de la API en Swagger/OpenAPI.
* Archivo `.yaml`.

### Ejercicio 2

* Diseño de la API en Swagger/OpenAPI.
* Archivo `.yaml`.

### Ejercicio 3

* Diseño de la API en Swagger/OpenAPI.
* Archivo `.yaml`.

### Ejercicio 4

* Ejecución de la API.
* Pruebas de endpoints en Postman.
* Respuestas HTTP.

### Ejercicio 5

* Ejecución de la API.
* Pruebas de endpoints en Postman.
* Respuestas HTTP.

### Ejercicio 6

* Ejecución de la API.
* Pruebas de endpoints en Postman.
* Respuestas HTTP.

---

# 📦 Entregables

El laboratorio debe entregarse mediante **un único archivo PDF** que contenga:

1. 🔗 Link del repositorio de GitHub.
2. 📸 Evidencias del funcionamiento de cada ejercicio.
3. 📋 Evidencias de las pruebas realizadas.
4. 📝 Información correspondiente al laboratorio.

### 📄 Formato del archivo

```text
Nombre_Apellido_Seccion_LaboratorioVI.pdf
```

---

# 👨‍💻 Autor

<div align="center">

### Diego Flores

**Ingeniería en Sistemas**

**Programación II**

Laboratorio VI — APIs REST

</div>

---

<div align="center">

### 🚀 Java • Spring Boot • Swagger • REST API • Git • GitHub

</div>
