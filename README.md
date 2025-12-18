# 🏥 Clinic Management System — Fullstack Enterprise Solution

![Java](https://img.shields.io/badge/Java-17%2B-red?logo=java) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-6DB33F?logo=springboot&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-336791?logo=postgresql&logoColor=white) ![React](https://img.shields.io/badge/React-20232A?logo=react&logoColor=61DAFB) ![Vite](https://img.shields.io/badge/Vite-646CFF?logo=vite&logoColor=white)

Este es un ecosistema de gestión clínica de alto rendimiento diseñado bajo estándares de ingeniería de software modernos. El backend implementa **Arquitectura Hexagonal (Ports & Adapters)** para garantizar un desacoplamiento total y máxima testabilidad, mientras que el frontend utiliza **Vite + React** para una experiencia de usuario fluida y reactiva.

---

## 🚀 Stack Tecnológico Profesional

### **Backend (The Core)**
* **Engine:** Java 17+ con Spring Boot 3.4.1.
* **Architecture:** Hexagonal (Ports & Adapters) para aislamiento de reglas de negocio.
* **Persistence:** Spring Data JPA + Hibernate con PostgreSQL 17.
* **Mapping:** MapStruct para transformaciones seguras entre capas (DTOs, Commands, Entities).
* **Validation:** Jakarta Validation para integridad de datos.
* **Documentation:** OpenAPI / Swagger UI.

### **Frontend (The UI)**
* **Framework:** React con **Vite** para un desarrollo ultrarrápido.
* **Paradigm:** Integración **MERN** (MongoDB, Express, React, Node) para módulos específicos de alta concurrencia o logs no relacionales.
* **Styling:** Componentes modernos y optimizados para entornos médicos.

---

## 🧱 Arquitectura Hexagonal y Organización

El proyecto sigue una estructura de carpetas estricta para mantener la pureza del dominio:

```text
src/main/java/com/project/project/
├── application/             # Capa de Aplicación (Orquestación)
│   ├── dto/                 # Commands y Results (Data transfer)
│   ├── mapper/              # Mapeo Aplicación ↔ Dominio
│   ├── useCase/             # Implementación de lógica de negocio (Servicios)
│   ├── GuestCreator.java    # Input Port (Interface)
│   └── GuestFindAll.java    # Input Port (Interface)
├── domain/                  # Corazón del Sistema (Reglas puras)
│   ├── model/               # Entidades de negocio (POJOs)
│   └── port/                # Output Ports (Interfaces para persistencia/externos)
├── infrastructure/          # Detalles de Implementación (Frameworks)
│   ├── input/               # Adaptadores de Entrada (REST, Swagger)
│   └── output/              # Adaptadores de Salida (JPA Repository, File Storage)
└── shared/                  # Módulos Transversales
    ├── config/              # Configuraciones de Bean y Swagger
    └── error/               # Manejo Global de Excepciones y Códigos de Error


```
📌 Entidades y Roadmap del Sistema
El sistema está diseñado para escalar hacia una solución integral de salud:

👥 Gestión Integral: Pacientes, Doctores y Personal Administrativo (Secretarios).

📅 Agenda Inteligente: Sistema de turnos con validación de disponibilidad en tiempo real.

🛑 Non-Working Days: Módulo avanzado para que médicos gestionen licencias, feriados y bloqueos horarios personalizados (Días libres y franjas horarias).

📂 Historia Clínica Digital: Almacenamiento seguro de registros médicos y archivos adjuntos.

🔐 Seguridad: Implementación de JWT (JSON Web Tokens) para control de acceso basado en roles.

⚙️ Configuración del Entorno
Requisitos
JDK 17 o superior.

Maven 3.9+.

PostgreSQL 17 activo.

Configuración de Base de Datos
Actualiza tu archivo src/main/resources/application.properties:

Properties

spring.datasource.url=jdbc:postgresql://localhost:5432/postgres?currentSchema=public
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

👤 Autor
Alejandro Ahmad Futuro Ingeniero en Sistemas de Información

GitHub: Yafar12

Email: yafarahmad72@gmail.com

© 2025 Clinic Management System. Desarrollo profesional orientado a la excelencia técnica.
