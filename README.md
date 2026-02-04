# 🎬 Cine_V2_Base - Sistema de Gestión de Entradas

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-latest-blue?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-build-red?style=for-the-badge&logo=apachemaven)

Sistema integral para la gestión de cines, permitiendo la administración de películas, salas, funciones y la venta automatizada de entradas con control de disponibilidad en tiempo real.

## 🚀 Características Principales

- **Gestión de Cartelera**: Control total sobre películas, directores y repartos.
- **Programación de Funciones**: Asignación dinámica de películas a salas con horarios específicos.
- **Venta de Entradas**: Proceso de compra con validación de edad y estado de ocupación.
- **Arquitectura Robusta**: Implementación multicapa (Controller, Service, Repository, DTO).
- **Mapeo Eficiente**: Uso de MapStruct para transformaciones entre entidades y DTOs.
- **Seguridad**: Sistema de usuarios y roles integrado.

## 📊 Modelo de Datos (Diagrama E-R)

A continuación se detalla la estructura relacional del sistema:

```mermaid
erDiagram
    DIRECTOR ||--o{ PELICULA : "dirige"
    PELICULA ||--o{ FUNCION : "se proyecta en"
    SALA ||--o{ FUNCION : "alberga"
    PELICULA }|--|{ ACTOR : "actúa en"
    FUNCION ||--o{ ENTRADA : "genera"
    VENTA ||--o{ ENTRADA : "contiene"
    USUARIO ||--o{ VENTA : "realiza"
    USUARIO }|--|{ ROL : "posee"

    ACTOR {
        Long id PK
        String nombre
    }
    DIRECTOR {
        Long id PK
        String nombre
    }
    PELICULA {
        Long id PK
        String titulo
        int duracion
        int edadMinima
        Long director_id FK
    }
    SALA {
        Long id PK
        String nombre
        int capacidad
    }
    FUNCION {
        Long id PK
        LocalDateTime fechaHora
        double precio
        Long pelicula_id FK
        Long sala_id FK
    }
    ENTRADA {
        Long id PK
        String codigo
        int fila
        int asiento
        String estado
        Long funcion_id FK
        Long venta_id FK
    }
    VENTA {
        Long id PK
        LocalDateTime fecha
        double importeTotal
        String metodoPago
        String estado
        Long usuario_id FK
    }
    USUARIO {
        Long id PK
        String email
        String password
        boolean enabled
    }
    ROL {
        Long id PK
        String nombre
    }
```

## 🛠️ Stack Tecnológico

- **Lenguaje**: Java 21
- **Framework**: Spring Boot 4.0.2
- **Persistencia**: Spring Data JPA / Hibernate
- **Base de Datos**: PostgreSQL
- **Herramientas**:
  - **Lombok**: Para reducir el código boilerplate.
  - **MapStruct**: Mapeo profesional de entidades.
  - **Maven**: Gestión de dependencias y construcción.

## ⚙️ Configuración y Ejecución

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/AminHarouEdu/Cine_V2_Base.git
   ```
2. **Configurar la base de datos**:
   Asegúrate de tener PostgreSQL corriendo y configurar tus credenciales en `src/main/resources/application.properties`.
3. **Ejecutar el proyecto**:
   ```bash
   ./mvnw spring-boot:run
   ```

## 📚 Lecciones y Recursos

Para facilitar el aprendizaje y las pruebas del proyecto, se han incluido los siguientes materiales:

- 📂 **[Carpeta de Lecciones](Lecciones/)**: Acceso a todo el material didáctico.
- 📖 **[Lección 1: Introducción al Proyecto Cine V2](Lecciones/Lecci%C3%B3n%201%20-%20El%20proyecto%20Cine%20V2%20-%20Introducci%C3%B3n.md)**: Explicación de la estructura base.
- 🚀 **[Colección de Postman](Lecciones/Postman_Cine_V2.json)**: Archivo para importar en Postman y realizar pruebas de la API.

---
💎 *Proyecto académico desarrollado para el módulo de Acceso a Datos (2º DAM).*
