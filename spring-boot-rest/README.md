# spring-boot-rest

- This application contains REST endpoints to showcase the spring boot rest implementation.
- It is using `spring-boot-data-jpa` dependency for database interaction.

**Create OutOfMemory issue**
- You can execute the application using below command and try to call this [localhost](http://localhost:8888/out-of-memory)

```
java -Xms256m -Xmx512m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d://heap_dump.hprof -jar .spring-boot-rest-2.5.14.jar
```

Then you can analyze the dump using **Memory Analyzer Tool(MAT)**
