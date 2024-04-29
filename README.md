# Proyecto Contabilidad ApiRest Microservices

Esta es parte de un proyecto que se esta realizando para una firma de contadores. Se trata de una aplicación web
que gestiona facturas de clientes se le asignan y guarda la indormacion de facturación de cada empresa.

## Tecnologias aplicadas:

* Spring Boot 3.1.4
* Spring Cloud 2022.0.4
* Eclipse temurin 21.0.3 17_45-jdk
* postgresql
* SpringDoc OpenAPI 2.1.0
* Docker 24.0.7

## Características
Gestión de clientes: Permite crear, editar y eliminar su cuenta.
Asignación de Facturas: Puede crear, editar y eliminar facturas. Cada tarea tiene una lista de etiquetas.
Información de facturación: Ver su historial de facturación.

## Instalación

Para instalar el proyecto, sigue estos pasos:

1- Descarga el proyecto desde GitHub.

2- Abre una terminal desde la raiz del repositorio.

3- Ejecuta el comando.

```
docker compose up
```

La app se desplegara en el puerto 8080 ya que usa gateway por defecto.

Para hacer pruebas de los endpoint desde postman, importa el postman_collection que esta en la raiz del proyecto.

## Contacto

Si tienes alguna pregunta o problema, puedes ponerte en contacto con el autor del proyecto en
su [Correo electrónico](mailto:davidsantiago434@gmail.com) .
