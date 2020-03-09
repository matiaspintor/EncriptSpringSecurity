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

*Las peticiones HTTP que haceptan los endpoints son por **POST***

*Nota: La configuracion que se realizo de Spring Security es basica para poder desarrollar los ejercicios de encriptacion y no corresponde a una configuracion habitual*

**Endpoint 1:**

Recibe como parametro un JSON con una cadena como valor, dentro del metodo se va a encriptar y va a retornar al usuario la cadena encriptada en **bcrypt**.

```
http://localhost:8080/bcrypt
```

Parametros:
```
    {
        "password": "ejemploCadenaEncriptar"
    }
```

**Endpoint 2:**

Recibe como parametro un JSON con dos cadenas como valor, dentro del metodo se va a encriptar una cadena y la va a comparar con la segunda cadena no encriptada y ejecutar el metodo match para verificar si el texto no encriptado corresponde al texto encriptado en bcrypt, la aplicacion de este metodo tendria similitud cuando un usuario necesita logearse en la aplicacion y necesita comparar una contraseña encriptada en la base de datos con la contraseña que esta digitando el usuario. El metodo va a retornar el resultado de la comparacion.

```
http://localhost:8080/bcryptCompare
```

Parametros:
```
    {
        "password1": "ejemploCadenaEncriptar",
        "password2": "ejemploCadenaComparar"
    }
```

**Endpoint 3:**

Recibe como parametro un JSON con una cadena como valor, dentro del metodo se va a encriptar y va a retornar al usuario la cadena encriptada en **pbkdf2**.

```
http://localhost:8080/pbkdf2
```

Parametros:
```
    {
        "password": "ejemploCadenaEncriptar"
    }
```


**Endpoint 4:**

Recibe como parametro un JSON con dos cadenas como valor, dentro del metodo se va a encriptar una cadena y la va a comparar con la segunda cadena no encriptada y ejecutar el metodo match para verificar si el texto no encriptado corresponde al texto encriptado en pbkdf2, la aplicacion de este metodo tendria similitud cuando un usuario necesita logearse en la aplicacion y necesita comparar una contraseña encriptada en la base de datos con la contraseña que esta digitando el usuario. El metodo va a retornar el resultado de la comparacion.

```
http://localhost:8080/pbkdf2Compare
```

Parametros:
```
    {
        "password1": "ejemploCadenaEncriptar",
        "password2": "ejemploCadenaComparar"
    }
```




