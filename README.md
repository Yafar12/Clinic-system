Clinic System – Hexagonal BackendAutor: Alejandro Ahmad — Futuro Ingeniero en Sistemas de InformaciónSistema de gestión clínica desarrollado bajo los principios de Arquitectura Hexagonal (Ports & Adapters). El objetivo es desacoplar completamente la lógica de negocio de las tecnologías externas (Base de datos, Frameworks, APIs), garantizando un sistema escalable, testeable y mantenible.🏗️ Arquitectura HexagonalEl proyecto se divide en tres capas fundamentales para asegurar el desacoplamiento:Fragmento de códigograph TD
    subgraph Infrastructure_Layer [Infrastructure Layer - Outer]
        InputAdapter[REST Controllers / Swagger]
        OutputAdapter[PostgreSQL / File System]
    end

    subgraph Application_Layer [Application Layer - Middle]
        UseCases[Use Cases / Services]
        InputPort[Input Ports - Interfaces]
        OutputPort[Output Ports - Interfaces]
    end

    subgraph Domain_Layer [Domain Layer - Core]
        Entities[Domain Models / Entities]
        Exceptions[Domain Exceptions]
    end

    InputAdapter --> InputPort
    UseCases --> InputPort
    UseCases --> OutputPort
    OutputAdapter --> OutputPort
    UseCases --> Entities
Domain (Core): Contiene los modelos de negocio (Patient, Doctor, Appointment) y las reglas más puras. No depende de ninguna librería externa.Application: Orquesta los procesos. Aquí residen los Use Cases que implementan la lógica necesaria para cumplir los requerimientos.Infrastructure: Adaptadores que permiten la comunicación con el exterior. Incluye la persistencia (JPA), el transporte (REST) y servicios de terceros (Storage).📌 Entidades del Dominio (Roadmap)El sistema se centra en la gestión de los siguientes actores y procesos:👤 Patient: Gestión de datos personales e historia clínica.👨‍⚕️ Doctor: Especialidades, números de matrícula y horarios de atención.⌨️ Secretary: Personal administrativo encargado de la gestión de turnos.📅 Non-Working Days: Gestión de licencias, feriados y bloqueos de agenda por rangos horarios.📝 Appointments: El núcleo del sistema, vinculando pacientes, doctores y disponibilidad.🛠️ TecnologíasJava 17/21Spring Boot 3.4.x (Web, Data JPA, Validation)Maven (Gestión de dependencias)MapStruct (Mapeo eficiente entre capas)Lombok (Reducción de código boilerplate)PostgreSQL 17 (Persistencia relacional)OpenAPI / Swagger (Documentación interactiva)🗂️ Estructura del ProyectoPlaintextcom.project.project/
├── domain/                  # Corazón del negocio
│   ├── model/               # Entidades puras (POJOs)
│   └── port/                # Interfaces (Input/Output Ports)
├── application/             # Lógica de aplicación
│   ├── usecases/            # Implementación de Use Cases
│   ├── dto/                 # Commands y Results
│   └── mapper/              # Mappers de Aplicación
├── infrastructure/          # Detalles de implementación
│   ├── input/               # Adaptadores de entrada (REST Controllers)
│   │   ├── adapter/
│   │   ├── dto/             # Request/Response DTOs
│   │   └── mapper/
│   └── output/              # Adaptadores de salida (DB, Storage)
│       ├── persistence/     # Entidades JPA y Repositorios
│       └── adapter/
└── shared/                  # Configuraciones y manejo global de errores
🚀 Configuración y EjecuciónRequisitos PreviosJDK 17 o superior.Base de datos PostgreSQL activa.Configuración de DB (application.properties)Propertiesspring.datasource.url=jdbc:postgresql://localhost:5432/clinic_db?currentSchema=public
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
EjecuciónBashmvn clean install
mvn spring-boot:run
🔌 API Endpoints (Placeholders)MétodoEndpointDescripciónPOST/guestRegistro de nuevo invitado/paciente.GET/guestsListado general.GET/guests/{id}Búsqueda por UUID.POST/non-working-daysBloqueo de agenda médica.✅ Buenas Prácticas AplicadasInversión de Dependencias: La lógica de negocio no depende de la DB, la DB depende de las interfaces del dominio.Manejo Global de Errores: Respuestas estandarizadas con códigos de error (NOT_FOUND, CONFLICT, etc.).Validación de Entrada: Uso de jakarta.validation para asegurar la integridad de los datos.Inmutabilidad: Uso de DTOs y objetos de valor para proteger el estado del sistema.👤 AutorAlejandro AhmadGitHub: Yafar12LinkedIn: [Tu Perfil]Este proyecto se encuentra en desarrollo activo. 🚧
