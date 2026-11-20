# Parcial Final - Exámenes de Sangre

Aplicación Java 11 y JavaFX para registrar exámenes de sangre mediante una arquitectura hexagonal (Ports and Adapters). El proyecto separa dominio, casos de uso, puertos y adaptadores, e incorpora pruebas unitarias y patrones de diseño GoF.

## Funcionalidades

- Registrar exámenes con código, paciente, costo, tipo sanguíneo y factor RH.
- Validar campos y reglas de dominio.
- Listar exámenes por código o por nombre de paciente.
- Serializar y deserializar los registros en `examenes.dat`.
- Limpiar el formulario y mostrar mensajes al usuario.

## Arquitectura y patrones

- **Dominio:** `ExamenSangre`, `TipoSangre`, `FactorRH`.
- **Aplicación:** `ExamenService` y estrategias de orden.
- **Puertos:** `PuertoExamenEntrada`, `ExamenRepository`, `SerializacionPort`.
- **Adaptadores:** JavaFX, repositorio en memoria y persistencia Java.
- **GoF:** Factory Method, Adapter y Strategy.

Diagramas en `Examen2/docs/`.

## Requisitos

- Java 11 o superior.
- Maven 3.8 o superior.
- Acceso a internet para descargar dependencias JavaFX y JUnit la primera vez.

## Instalación

```powershell
git clone https://github.com/Miilo00/ParcialFinal.git
cd ParcialFinal\Examen2
mvn clean install
```

## Ejecutar

```powershell
mvn javafx:run
```

La aplicación crea o utiliza el archivo `examenes.dat` en el directorio desde el que se ejecuta Maven.

## Pruebas

```powershell
mvn test
```

## Documentación JavaDoc

```powershell
mvn javadoc:javadoc
```

La documentación se genera en `target/site/apidocs`.

## Configuración recomendada

- Ejecutar desde `Examen2`.
- Mantener Java 11 como versión objetivo.
- No incluir `examenes.dat`, `target/` ni archivos `.class` en el control de cambios.
- Las implementaciones de persistencia se pueden sustituir implementando los puertos existentes.
