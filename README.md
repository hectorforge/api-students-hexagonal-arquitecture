# Sistema CRUD de Gestión de Estudiantes

Este proyecto implementa un sistema básico de gestión de estudiantes utilizando **Java 17**, **Spring Boot 3** y una **Arquitectura Hexagonal (Puertos y Adaptadores)**. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la información de estudiantes y persiste los datos en una base de datos **PostgreSQL**.

---

## Objetivo del Proyecto

El principal objetivo de este proyecto es demostrar la aplicación de principios de **Diseño Orientado a Dominio (DDD)** y **Arquitectura Hexagonal** en un contexto de desarrollo de microservicios con Spring Boot. Se busca separar claramente la lógica de negocio del dominio de las preocupaciones de infraestructura, haciendo el sistema más mantenible, escalable y adaptable a futuros cambios tecnológicos.

## Características Principales

* **CRUD Completo de Estudiantes:**
    * Crear nuevos registros de estudiantes.
    * Consultar la lista de todos los estudiantes.
    * Obtener detalles de un estudiante específico por ID.
    * Actualizar información de estudiantes existentes.
    * Eliminar registros de estudiantes.
* **Arquitectura Hexagonal (Puertos y Adaptadores):**
    * Separación clara entre el dominio (negocio) y la infraestructura (persistencia, API REST).
    * Adaptadores de entrada (REST) y de salida (Persistencia) desacoplados del dominio.
    * Mayor facilidad para cambiar implementaciones de infraestructura sin afectar la lógica de negocio.
* **Spring Boot 3:** Desarrollo rápido y configuración mínima gracias a las capacidades de auto-configuración de Spring Boot.
* **Persistencia con PostgreSQL:** Utilización de Spring Data JPA para interactuar eficientemente con una base de datos relacional PostgreSQL.
* **Manejo Global de Excepciones:** `GlobalControllerAdvice` para una gestión consistente y centralizada de errores en la API.
* **Mappers:** Clases dedicadas para la conversión de objetos de solicitud/respuesta (DTOs) a entidades de dominio y viceversa.

## Tecnologías Utilizadas

* Java 17
* Spring Boot 3.5.4
* Maven (Gestor de dependencias)
* Spring Data JPA
* PostgreSQL (Base de datos relacional)
* Lombok (Para reducir código boilerplate)

## Cómo Ejecutar el Proyecto

Sigue estos pasos para levantar el proyecto en tu máquina local:

### 1. Requisitos Previos

* Java Development Kit (JDK) 17 o superior instalado.
* Maven instalado.
* Una instancia de PostgreSQL corriendo.

### 2. Configuración de la Base de Datos

1.  Asegúrate de tener una base de datos PostgreSQL disponible.
2.  Crea una base de datos llamada, por ejemplo, `student_db`.
    ```sql
    CREATE DATABASE student_db;
    ```
3.  Actualiza el archivo `src/main/resources/application.properties` (o `application.yml`) con las credenciales de tu base de datos PostgreSQL:

    ```properties
    datasource:
      url: jdbc:postgresql://localhost:5432/student_db
      username: postgres
      password: postgres
    ```

### 3. Compilación y Ejecución

1.  Clona el repositorio:
    ```bash
    git clone [https://github.com/tu_usuario/nombre_del_repositorio.git](https://github.com/tu_usuario/nombre_del_repositorio.git)
    cd nombre_del_repositorio
    ```
2.  Compila el proyecto usando Maven:
    ```bash
    mvn clean install
    ```
3.  Ejecuta la aplicación Spring Boot:
    ```bash
    mvn spring-boot:run
    ```
    La aplicación se iniciará en `http://localhost:8080` (por defecto).

## Endpoints de la API REST

Una vez que la aplicación esté corriendo, puedes usar herramientas como Postman, Insomnia o `curl` para interactuar con los siguientes endpoints:

| Método | Endpoint                    | Descripción                          | Body (Request) Ejemplo                   |
| :----- | :-------------------------- | :----------------------------------- | :--------------------------------------- |
| `POST` | `/api/students`             | Crear un nuevo estudiante.           | `{"firstName": "Juan", "lastName": "Perez", "age": 20, "email": "juan.perez@example.com"}` |
| `GET`  | `/api/students`             | Obtener todos los estudiantes.       | `N/A`                                    |
| `GET`  | `/api/students/{id}`        | Obtener estudiante por ID.           | `N/A`                                    |
| `PUT`  | `/api/students/{id}`        | Actualizar estudiante por ID.        | `{"firstName": "Juan", "lastName": "Gomez", "age": 21}` (Puedes omitir campos no a actualizar) |
| `DELETE`|`/api/students/{id}`        | Eliminar estudiante por ID.          | `N/A`                                    |

---

## Estructura del Proyecto
```plaintext
El proyecto sigue una estructura inspirada en la Arquitectura Hexagonal, organizada de la siguiente manera:
src
└── main
└── java
└── com
└── hex
└── app
├── application
│   ├── ports
│   │   ├── input  (Interfaces de entrada)
│   │   └── output (Interfaces de salida)
│   └── service    (Implementación de la lógica de negocio del dominio)
├── domain         (Entidades de negocio y objetos de valor del dominio)
└── infrastructure
├── adapters
│   ├── input.rest  (Adaptador para la API REST)
│   │   ├── mapper
│   │   ├── model
│   │   │   ├── request (DTOs de entrada)
│   │   │   └── response (DTOs de salida)
│   │   └── StudentController
│   └── output.persistence (Adaptador para la persistencia de datos)
│       ├── entity       (Entidades JPA/Hibernate)
│       ├── mapper       (Mappers entre dominio y entidad de persistencia)
│       ├── repository   (Interfaces de Spring Data JPA)
│       └── StudentPersistenceAdapter (Implementación del puerto de salida)
└── config           (Configuraciones específicas de la aplicación y Spring)
└── GlobalControllerAdvice (Manejo global de excepciones)
└── AppHexagonalApplication (Clase principal de la aplicación Spring Boot)
└── utils                 (Clases utilitarias como catálogos de errores, si aplica)
```

## Contribuciones

Las contribuciones son bienvenidas. Si encuentras un error o tienes una mejora, no dudes en abrir un "issue" o enviar un "pull request".

## Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

---

Desarrollado por [hectorforge]
