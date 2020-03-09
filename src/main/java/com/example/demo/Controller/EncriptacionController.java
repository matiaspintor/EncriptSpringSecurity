package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/encriptar"})
public class EncriptacionController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;
	/*
	 * Metodo que encripta una cadena de texto con algoritmo bcrypt y retorna el hash al usuario
	 * @Params[password(string)]
	 * */
	@PostMapping(path = "/bcrypt")
	public ResponseEntity<Object> bcrypt(@RequestBody Map<String, String> pass){
		String passwordEncode = bCryptEncoder.encode(pass.get("password").toString());
		return ResponseEntity.status(HttpStatus.OK).body(passwordEncode);
	}
	
	/*
	 * Metodo que compara dos hashes bcrypt, encripta la primera cadena y luego compara
	 * con el metodo matches que la cadena desenciptada haga match con la cadena encriptada
	 * @Params[password1, password2]
	 * */
	@PostMapping(path = {"/bcryptCompare"})
	public ResponseEntity<Object> bCryptCompare(@RequestBody Map<String, String> datos){
		String pass1 = datos.get("password1").toString();
		String pass2 = datos.get("password2").toString();
		pass1 = this.bCryptEncoder.encode(pass1);
		boolean comparacion = this.bCryptEncoder.matches(pass2, pass1);
		if(comparacion) {
			return ResponseEntity.status(HttpStatus.OK).body("Los hashes de encriptacion son iguales.");
		}
		return ResponseEntity.status(HttpStatus.OK).body("No coinciden los hashes.");
	}
	
	/*
	 * Metodo que encripta una cadena con hash pbkdf2 y la retorna al usuario
	 * @Params[password]
	 * */
	@PostMapping(path = {"/pbkdf2"})
	public ResponseEntity<Object> pbkdf2(@RequestBody Map<String, String> datos){
		Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder("secret", 10000, 128);
		String hash = encoder.encode(datos.get("password").toString());
		return ResponseEntity.status(HttpStatus.OK).body(hash);
	}
	
	/*
	 * Metodo que recibe dos contraseñas, encripta una y trata de hacer match con la cadena
	 * sin encriptar a modo de comparacion con hash pbkdf2
	 * @Params
	 * */
	@PostMapping(path = {"/pbkdf2Compare"})
	public ResponseEntity<Object> pbkdf2Compare(@RequestBody Map<String, String> datos){
		String pass1 = datos.get("password1").toString();
		String pass2 = datos.get("password2").toString();
		Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder("secret", 10000, 128);
		pass1 = encoder.encode(pass1);
		boolean comparacion = encoder.matches(pass2, pass1);
		if(comparacion) {
			return ResponseEntity.status(HttpStatus.OK).body("Los hashes de encriptacion son iguales");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Los hashes de encriptacion son diferentes.");
	}
	
	
}
