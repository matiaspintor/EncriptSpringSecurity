# EncriptSpringSecurity
Encriptado cadenas con Spring Security

Desarrollo de API Rest con java 13, Spring Boot 2 y Spring Security.

Dependencia Maven Spring Security:

```
<dependency>
<groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

El controlador principal expone 4 endpoints en los cuales se juega con dos hashes de encriptación que nos provee Spring Security “BCrypt” y “pbkdf2”.

*Las peticiones HTTP que haceptan los endpoints son por POST*

** Endpoint 1: **

Recibe como parametro un JSON con una cadena como valor, dentro del metodo se va a encriptar y va a retornar al usuario la cadena encriptada en bcrypt.

```
http://localhost:8080/bcrypt
```

Parametros:
```
    {
        "password": "ejemploCadenaEncriptar"
    }
```



