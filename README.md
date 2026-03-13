# Mono-Repo

A Gradle mono-repo containing two independent Spring Boot microservices.

## Structure

```
/
├── build.gradle          # Shared subproject configuration
├── settings.gradle       # Declares both subprojects
├── time-service/         # Returns the current time  (port 8080)
│   ├── build.gradle
│   └── src/main/java/com/example/timeservice/
│       ├── TimeServiceApplication.java
│       ├── TimeController.java
│       └── OpenApiConfig.java
└── day-service/          # Returns the day of the week (port 8081)
    ├── build.gradle
    └── src/main/java/com/example/dayservice/
        ├── DayServiceApplication.java
        ├── DayController.java
        └── OpenApiConfig.java
```

## Building

### Build all services
```bash
gradle build
```

### Build a single service
```bash
gradle :time-service:build
gradle :day-service:build
```

## Running

### time-service
```bash
java -jar time-service/build/libs/time-service.jar
```
- REST endpoint: `GET http://localhost:8080/api/time`
- Swagger UI:    `http://localhost:8080/swagger-ui.html`
- OpenAPI spec:  `http://localhost:8080/v3/api-docs`

### day-service
```bash
java -jar day-service/build/libs/day-service.jar
```
- REST endpoint: `GET http://localhost:8081/api/day`
- Swagger UI:    `http://localhost:8081/swagger-ui.html`
- OpenAPI spec:  `http://localhost:8081/v3/api-docs`

## Example Responses

**GET /api/time**
```json
{
  "timestamp": "2024-10-15T14:30:00+00:00",
  "timezone": "UTC"
}
```

**GET /api/day**
```json
{
  "dayOfWeek": "Tuesday",
  "dayOfWeekShort": "Tue",
  "date": "2024-10-15"
}
```
