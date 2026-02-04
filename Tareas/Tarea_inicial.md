# Tarea Inicial: Preparación y Configuración del Entorno - Proyecto Cine V2 Base

## 1. Introducción
Bienvenidos al proyecto **Cine V2 Base**. Esta primera tarea tiene como objetivo asentar las bases técnicas y el flujo de trabajo que seguiremos durante las próximas semanas. Se trata de una actividad de arranque esencial para asegurar que todo el alumnado dispone de un entorno de desarrollo funcional y sincronizado con el repositorio base.

**Nota importante:** Esta tarea es de carácter **obligatorio**, aunque no computará en la calificación final de la unidad. Es un requisito indispensable para poder realizar las siguientes entregas evaluables.

---

## 2. Instrucciones Paso a Paso
Para completar la tarea, deberás seguir estrictamente este orden de ejecución:

1.  **Fork del Repositorio:** Realiza un *fork* del repositorio base proporcionado por el profesor (`Cine_V2_Base`) hacia tu cuenta personal de GitHub.
2.  **Clonación Local:** Clona tu repositorio (el fork) en tu equipo de trabajo local.
3.  **Importación al IDE:** Importa el proyecto en tu entorno de desarrollo (IntelliJ IDEA, VS Code o Eclipse) asegurándote de que todas las dependencias de Maven se descargan correctamente.
4.  **Configuración de Base de Datos:** Configura tu instancia local de PostgreSQL. Asegúrate de que las credenciales en el archivo de propiedades del proyecto coinciden con tu configuración local.
5.  **Despliegue Inicial:** Arranca la aplicación Spring Boot y verifica que no se producen errores en la consola.

---

## 3. Normas de Trabajo y Git Flow
Para mantener la integridad del proyecto y simular un entorno profesional, se establecen las siguientes reglas:

*   **Rama Principal:** Queda terminantemente prohibido realizar commits directamente sobre la rama `main`.
*   **Gestión de Ramas:** Una vez clonado el proyecto, debes crear inmediatamente una rama llamada `develop`. Todo el trabajo de esta asignatura se gestionará desde esta rama o ramas derivadas (*feature branches*).
*   **Funcionalidad:** En esta etapa, no se debe modificar ninguna funcionalidad existente ni añadir código nuevo. El objetivo es puramente de configuración.
*   **Historial:** Bajo ningún concepto se debe borrar o alterar el historial de commits existente del repositorio base.

---

## 4. Criterios de Validación
Sabrás que has completado la tarea con éxito cuando hayas comprobado los siguientes puntos:

1.  **Arranque del Servidor:** La aplicación se inicia y el servidor embebido queda a la escucha de peticiones sin excepciones en el log.
2.  **Conectividad:** La aplicación se conecta correctamente a PostgreSQL y se observa la creación automática de las tablas e inserción de los datos de prueba iniciales.
3.  **Disponibilidad de la API:** Al realizar peticiones a los puntos de enlace (*endpoints*) existentes, el servidor responde con la información esperada.
4.  **Estructura Git:** Tu repositorio en GitHub muestra claramente el origen del fork y la nueva rama `develop` creada.

---
🚀 *¡Ánimo! Con este paso completado, ya estarás listo para empezar a trabajar en las mejoras del sistema.*
