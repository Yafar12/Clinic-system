# 🏥 Clinic Management System
### Fullstack Enterprise Healthcare Platform

![Java](https://img.shields.io/badge/Java-17%2B-red?style=for-the-badge&logo=java) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-336791?style=for-the-badge&logo=postgresql&logoColor=white) ![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB) ![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white)

Un **sistema integral de gestión clínica**, diseñado con enfoque **enterprise-grade**, priorizando **escalabilidad, mantenibilidad y desacoplamiento real**. El proyecto aplica **Arquitectura Hexagonal (Ports & Adapters)** en el backend y una **UI moderna de alto rendimiento** en React.

> 📌 **Objetivo del proyecto:** Demostrar el dominio de **arquitectura limpia**, **diseño orientado al dominio (DDD)** y **buenas prácticas profesionales** aplicadas a un sistema real del sector salud.

---

## 🧠 Arquitectura — Clean, Hexagonal & Scalable

El backend está diseñado para **proteger el dominio** de cualquier cambio tecnológico, garantizando independencia de frameworks, bases de datos y UI.



```mermaid
graph TD
    subgraph Infrastructure
        UI[REST Controllers / Swagger]
        DB[(PostgreSQL 17)]
        FS[File System / External Storage]
    end

    subgraph Application
        UC[Use Cases / Application Services]
        IP[Input Ports]
        OP[Output Ports]
    end

    subgraph Domain
        DM[Domain Models]
        BR[Business Rules]
    end

    UI --> IP
    UC --> IP
    UC --> OP
    OP --> DB
    OP --> FS
    UC --> DM
