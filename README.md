# 🏥 Clinic System – Hexagonal Backend

![Java](https://img.shields.io/badge/Java-17%2B-red?logo=java) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-6DB33F?logo=springboot&logoColor=white) ![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-336791?logo=postgresql&logoColor=white)

> **Autor:** **Alejandro Ahmad** — *Futuro Ingeniero en Sistemas de Información*

Sistema de gestión clínica desarrollado bajo los principios de **Arquitectura Hexagonal (Puertos y Adaptadores)**. El proyecto busca el desacoplamiento total de la lógica de negocio frente a infraestructuras externas, facilitando el mantenimiento y la escalabilidad.

---

## 🏗️ Arquitectura (Ports & Adapters)

El sistema implementa una separación estricta en tres capas principales:



* **Dominio (Core):** Contiene la lógica pura del negocio y las entidades (`Guest`, `Doctor`, `Patient`). No tiene dependencias de frameworks ni librerías externas.
* **Aplicación:** Orquesta el flujo de datos. Aquí residen los **Use Cases**, los **Commands** y los **Input/Output Ports** (interfaces).
* **Infraestructura:** Contiene los adaptadores que hablan con el mundo real (Controladores REST, JPA para PostgreSQL, File Storage).

---

## 📌 Entidades del Dominio (En desarrollo)

El sistema está diseñado para gestionar el ecosistema clínico:

* 👤 **Patient (Paciente):** Gestión de datos personales e historia clínica.
* 👨‍⚕️ **Doctor:** Especialidades, matrículas y disponibilidad.
* ⌨️ **Secretary:** Administración de agendas y turnos.
* 📅 **Non-Working Days:** Bloqueos de agenda médica por feriados, vacaciones o rangos horarios específicos.

---

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 17 o superior.
* **Framework:** Spring Boot 3.4.x.
* **Gestión de Dependencias:** Maven.
* **Persistencia:** Spring Data JPA + PostgreSQL 17.
* **Mapeo:** MapStruct (Traducción entre capas).
* **Documentación:** OpenAPI / Swagger UI.

---

## 🗂️ Estructura del Proyecto

```text
src/main/java/com/project/project/
├── domain/                  # Corazón del negocio (Entities & Ports)
├── application/             # Lógica de aplicación (Use Cases & DTOs)
├── infrastructure/          # Adaptadores (Input: REST / Output: DB)
└── shared/                  # Configuración global, Middleware y Excepciones
