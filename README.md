# Charge-Points-api

### Database diagram
![image](https://user-images.githubusercontent.com/102662863/220786393-489162bd-8d9c-4905-bb85-6c30d6d20610.png)


### application.properties
```bash
app.version=v.1.0
app.dbversion=v.1.0

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:electric_vehicles_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```
