# Resumen de análisis SonarQube

La imagen de resumen se encuentra en [resumen-sonarqube.svg](resumen-sonarqube.svg).

## Evidencia local verificable

| Métrica | Resultado |
|---|---|
| Pruebas JUnit | 5 ejecutadas, 0 fallos, 0 errores |
| Compilación Maven | Exitosa |
| Java objetivo | Java 11 |
| Arquitectura | Hexagonal |
| Patrones GoF | Factory Method, Adapter y Strategy |

## Cómo ejecutar el análisis

1. Configurar el servidor SonarQube o SonarCloud.
2. Ejecutar `mvn clean test`.
3. Ejecutar `mvn sonar:sonar -Dsonar.host.url=<URL> -Dsonar.token=<TOKEN>`.
4. Publicar la captura o el resumen exportado en la wiki.

La configuración reproducible del proyecto está en `Examen2/sonar-project.properties`.
