# Evidencias – Laboratorio VI

Para cada ejercicio: arrancar el proyecto y ejecutar los curl indicados (caso exitoso y caso de error) para capturas.

## Ejercicio 4 – Libros

```
cd ejercicio4
./mvnw spring-boot:run
```

```bash
# Crear libro (201)
curl -i -X POST http://localhost:8080/api/libros -H "Content-Type: application/json" -d "{\"titulo\":\"Cien Años de Soledad\",\"autor\":\"Gabriel García Márquez\",\"isbn\":\"978-0307474728\",\"anioPublicacion\":1967}"

# Crear libro duplicado (409)
curl -i -X POST http://localhost:8080/api/libros -H "Content-Type: application/json" -d "{\"titulo\":\"Otro\",\"autor\":\"Otro\",\"isbn\":\"978-0307474728\",\"anioPublicacion\":2000}"

# Listar libros (200)
curl -i http://localhost:8080/api/libros

# Buscar por título (200)
curl -i http://localhost:8080/api/libros/titulo/Cien%20Años%20de%20Soledad

# Buscar por título inexistente (404)
curl -i http://localhost:8080/api/libros/titulo/NoExiste

# Actualizar libro (200)
curl -i -X PUT http://localhost:8080/api/libros/1 -H "Content-Type: application/json" -d "{\"titulo\":\"Cien Años de Soledad\",\"autor\":\"G. García Márquez\",\"isbn\":\"978-0307474728\",\"anioPublicacion\":1967}"

# Actualizar libro inexistente (404)
curl -i -X PUT http://localhost:8080/api/libros/999 -H "Content-Type: application/json" -d "{\"titulo\":\"X\",\"autor\":\"Y\",\"isbn\":\"000\",\"anioPublicacion\":2000}"

# Eliminar libro (204)
curl -i -X DELETE http://localhost:8080/api/libros/1

# Eliminar libro inexistente (404)
curl -i -X DELETE http://localhost:8080/api/libros/999
```

## Ejercicio 5 – Cursos

```
cd ejercicio5
./mvnw spring-boot:run
```

```bash
# Crear curso (201)
curl -i -X POST http://localhost:8080/api/cursos -H "Content-Type: application/json" -d "{\"nombre\":\"Programación III\",\"codigo\":\"PRG301\",\"creditos\":4}"

# Crear curso duplicado (409)
curl -i -X POST http://localhost:8080/api/cursos -H "Content-Type: application/json" -d "{\"nombre\":\"Otro\",\"codigo\":\"PRG301\",\"creditos\":3}"

# Listar cursos (200)
curl -i http://localhost:8080/api/cursos

# Buscar por código (200)
curl -i http://localhost:8080/api/cursos/codigo/PRG301

# Buscar por código inexistente (404)
curl -i http://localhost:8080/api/cursos/codigo/NOEXISTE

# Actualizar curso (200)
curl -i -X PUT http://localhost:8080/api/cursos/1 -H "Content-Type: application/json" -d "{\"nombre\":\"Programación III\",\"codigo\":\"PRG301\",\"creditos\":5}"

# Actualizar curso inexistente (404)
curl -i -X PUT http://localhost:8080/api/cursos/999 -H "Content-Type: application/json" -d "{\"nombre\":\"X\",\"codigo\":\"Y\",\"creditos\":1}"

# Eliminar curso (204)
curl -i -X DELETE http://localhost:8080/api/cursos/1

# Eliminar curso inexistente (404)
curl -i -X DELETE http://localhost:8080/api/cursos/999
```

## Ejercicio 6 – Reservas

```
cd ejercicio6
./mvnw spring-boot:run
```

```bash
# Crear reserva (201)
curl -i -X POST http://localhost:8080/api/reservas -H "Content-Type: application/json" -d "{\"nombreCliente\":\"Ana Pérez\",\"habitacion\":\"101\",\"fechaEntrada\":\"2026-10-01\",\"fechaSalida\":\"2026-10-05\"}"

# Crear reserva con fechas inválidas (400)
curl -i -X POST http://localhost:8080/api/reservas -H "Content-Type: application/json" -d "{\"nombreCliente\":\"Ana Pérez\",\"habitacion\":\"101\",\"fechaEntrada\":\"2026-10-05\",\"fechaSalida\":\"2026-10-01\"}"

# Listar reservas (200)
curl -i http://localhost:8080/api/reservas

# Buscar por id (200)
curl -i http://localhost:8080/api/reservas/1

# Buscar por id inexistente (404)
curl -i http://localhost:8080/api/reservas/999

# Actualizar reserva (200)
curl -i -X PUT http://localhost:8080/api/reservas/1 -H "Content-Type: application/json" -d "{\"nombreCliente\":\"Ana Pérez\",\"habitacion\":\"102\",\"fechaEntrada\":\"2026-10-01\",\"fechaSalida\":\"2026-10-06\"}"

# Actualizar reserva inexistente (404)
curl -i -X PUT http://localhost:8080/api/reservas/999 -H "Content-Type: application/json" -d "{\"nombreCliente\":\"X\",\"habitacion\":\"1\",\"fechaEntrada\":\"2026-10-01\",\"fechaSalida\":\"2026-10-02\"}"

# Cancelar reserva (200)
curl -i -X PATCH http://localhost:8080/api/reservas/1/cancelar

# Cancelar reserva inexistente (404)
curl -i -X PATCH http://localhost:8080/api/reservas/999/cancelar
```
