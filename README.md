# msvc-oauth

El microservicio `msvc-oauth` proporciona funcionalidades de autenticación y autorización utilizando OAuth2. Este servicio es parte de una arquitectura de microservicios y se comunica con otros servicios a través de Eureka y Feign.

## Descripción

Este proyecto es un servidor de autorización OAuth2, parte del ecosistema de Spring Cloud. Su finalidad es educativa, permitiendo a los desarrolladores aprender cómo configurar y utilizar un servidor de autorización en una arquitectura de microservicios.

## Requisitos

- Java 21
- Maven 3.6.3 o superior
- Spring Boot 3.4.2 o superior

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/ignjs/msvc-oauth.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd msvc-oauth
    ```
3. Compila el proyecto con Maven:
    ```sh
    mvn clean install
    ```

## Ejecución

1. Ejecuta la aplicación:
    ```sh
    mvn spring-boot:run
    ```
2. La aplicación estará disponible en `http://localhost:8080`.

## Dependencias

El proyecto [msvc-oauth](http://_vscodecontentref_/2) utiliza las siguientes dependencias:

- **Spring Boot Starter Parent**: Configuración base para proyectos Spring Boot.
- **Spring Cloud Starter Netflix Eureka Client**: Cliente Eureka para registro y descubrimiento de servicios.
- **Spring Boot Starter Security**: Seguridad para aplicaciones Spring Boot.
- **Spring Boot Starter OAuth2 Client**: Cliente OAuth2.
- **Spring Boot Starter OAuth2 Resource Server**: Servidor de recursos OAuth2.
- **Spring Boot DevTools**: Herramientas de desarrollo para Spring Boot.
- **Spring Boot Starter Test**: Dependencias para pruebas en Spring Boot.
- **Reactor Test**: Herramientas de prueba para Reactor.

## Configuración

El archivo de configuración principal se encuentra en `src/main/resources/application.yml`. Aquí puedes configurar las propiedades del servidor de autorización.

## Estructura del Proyecto

- [java](http://_vscodecontentref_/3): Contiene el código fuente del proyecto.
- [resources](http://_vscodecontentref_/4): Contiene los archivos de configuración y recursos estáticos.
- [pom.xml](http://_vscodecontentref_/5): Archivo de configuración de Maven.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, haga un fork del repositorio y envíe un pull request con sus cambios.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulte el archivo `LICENSE` para más detalles.