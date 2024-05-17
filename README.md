# Instrucciones de Uso

Este repositorio contiene una aplicación de muestra que utiliza Apache Kafka como sistema de mensajería. Sigue los pasos a continuación para ejecutar la aplicación en tu entorno local.

## Requisitos Previos

Asegúrate de tener instalado Docker en tu sistema antes de comenzar.

## Paso 1: Descargar Apache Kafka

Descarga la imagen de Apache Kafka para Docker utilizando el siguiente comando:

```bash
docker pull apache/kafka:3.7.0  
```
## Paso 2: Ejecutar Apache Kafka

Correr apache kafka con el siguiente comando: 
```bash
docker run -p 9092:9092 apache/kafka:3.7.0
```
## Paso 3: Configurar la Base de Datos
1. Crear una base de datos en Postgres llamada Curso
2. llenar las credenciales correspondientes a tu base en el properties del SpringBootProvider

## Paso 4: Ejecutar la Aplicación
1. Correr el SpringBootProvider
2. Correr el SpringBootConsumer

# Funcionamiento
Cada vez que se crea un curso nuevo, el consumidor recibira un mensaje con los datos del curso creado.
