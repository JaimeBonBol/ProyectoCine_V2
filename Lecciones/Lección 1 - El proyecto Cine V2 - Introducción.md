# Lección 1: El Proyecto Cine V2 - Introducción

Bienvenido a la primera sesión sobre el proyecto **Cine V2**. Esta aplicación es un sistema robusto desarrollado con **Spring Boot** para gestionar la operativa diaria de un cine, desde la cartelera hasta la venta de entradas.

---

## 📽️ 1. Descripción de la Aplicación
El sistema permite administrar cines de forma automatizada, gestionando:
*   **Contenido**: Películas, Actores y Directores.
*   **Infraestructura**: Salas y su capacidad.
*   **Programación**: Funciones de cine vinculando películas, salas, horarios y precios.
*   **Operaciones**: Venta de entradas con validación de edad y control de ocupación.

---

## 🏗️ 2. Arquitectura: El "Camino Principal"
El proyecto sigue el patrón de diseño multicapa para asegurar el desacoplamiento y la mantenibilidad:

`Controlador ➡️ Servicio ➡️ Repositorio ➡️ Modelo (Entidad)`

*   **Controlador (API Layer)**: Gestiona las peticiones HTTP y devuelve las respuestas. No contiene lógica de negocio.
*   **Servicio (Business Layer)**: Donde reside la "magia". Aquí se aplican las reglas de negocio, validaciones y transformaciones.
*   **Repositorio (Data Access Layer)**: Interfaz que se comunica con la base de datos PostgreSQL mediante Spring Data JPA.
*   **DTO (Data Transfer Object)**: Objetos que transportan los datos entre capas, evitando exponer las entidades de base de datos directamente al exterior.

---

## 🧩 3. Conceptos Clave del Proyecto

### 🔄 DTOs de Entrada y Salida
Usamos DTOs separados para mayor control:
-   **Entrada (Request)**: Estructuras optimizadas para recibir datos del cliente (ej. `EntradaRequestDTO`).
-   **Salida (Response)**: Estructuras diseñadas para mostrar solo la información necesaria al cliente, ocultando datos internos (ej. `EntradaResponseDTO`).

### 📦 MapStruct
Herramienta profesional de generación de código que automatiza el mapeo entre entidades y DTOs.
*   **Beneficio**: Evita el tedioso código manual de `setters` y `getters`, reduciendo errores y aumentando la eficiencia.
*   **Ejemplo**: `PeliculaMapper` convierte una `Pelicula` (Entidad) en un `PeliculaResponseDTO` de forma instantánea.

### 💾 DataLoader
Clase configurada para ejecutarse al inicio de la aplicación.
*   **Uso**: Poblar la base de datos con datos de prueba iniciales (Seeders) para que el desarrollador pueda trabajar de inmediato sin base de datos vacía.

### 🛡️ @Transactional
Anotación de Spring que garantiza la **atomicidad** de las operaciones.
*   **Importancia**: Si una operación compleja falla a mitad (ej. se crea la Venta pero falla la reserva de Entradas), se hace un *rollback* automático para que la base de datos no quede en un estado inconsistente.

---

## 🛠️ 4. Stack de Dependencias
Las piezas fundamentales del `pom.xml`:
*   **Spring Boot Starter Web**: Para crear la API REST.
*   **Spring Data JPA**: Para la persistencia de datos.
*   **PostgreSQL**: Driver para conectar con la base de datos relacional.
*   **Lombok**: Para eliminar código repetitivo (Constructores, Getters/Setters).
*   **MapStruct**: Para el mapeo de objetos.
*   **Validation**: Para asegurar que los datos de entrada son correctos.

---

## ⚙️ 5. Funcionalidad Actual
Más allá del CRUD (Create, Read, Update, Delete) básico para todas las entidades, el sistema incluye:
*   **Control de Aforo**: No se pueden vender más entradas de las que permite la capacidad de la sala.
*   **Validación de Edad**: Impide la compra de entradas si el usuario no cumple la edad mínima de la película.
*   **Gestión de Estados**: Las entradas cambian de estado (DISPONIBLE, RESERVADA, VENDIDA).
*   **Cálculo Automático**: La `Venta` calcula el importe total sumando los precios de las funciones asociadas.

---

## 🚀 6. Pruebas con Postman
En esta misma carpeta encontrarás el archivo `Postman_Cine_V2.json`. Importalo en tu herramienta Postman para visualizar todas las rutas organizadas por carpetas (Películas, Salas, Ventas, etc.) y probar la API en segundos.
