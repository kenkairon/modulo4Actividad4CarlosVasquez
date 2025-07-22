# Automatización de Formulario - demoqa.com

Este proyecto automatiza el llenado del formulario de la página [demoqa.com/automation-practice-form](https://demoqa.com/automation-practice-form) usando Selenium, JUnit 5 y Maven.

## 📦 Requisitos

- Java 8 o superior
- Maven
- Google Chrome

## ⚙️ Instalación

1. Clona el repositorio o crea un proyecto Maven.
2. Agrega estas dependencias al `pom.xml`:

```xml
<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.20.0</version>
  </dependency>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
  </dependency>
  <dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.7.0</version>
  </dependency>
</dependencies>


