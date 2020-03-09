package com.example.demo.Shell;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.example.demo.Controller.EncriptacionController;
/*
 * Clase que ejecuta la shell para probar los metodo con parametros sin necesidad de tener
 * un cliente Http que envie peticiones a la api rest
 * */
@ShellComponent
public class ShellComand {
	
	@Autowired
	private EncriptacionController encriptacion;
	
	@ShellMethod(value = "Metodo que encripta en bcrypt una cadena y la retorna encriptada", key="bcrypt")
	public String bcrypt(String password) {
		Map<String, String> datos = new HashMap<String, String>();
		datos.put("password", password);
		String respuesta = this.encriptacion.bcrypt(datos).getBody().toString();
		return respuesta;
	}
	
	@ShellMethod(value = "Metodo que compara dos cadenas, una encriptada, retorna si las cadenas son iguales con bcrypt",
			key = "bcryptCompare")
	public String bCryptCompare(String password1, String password2) {
		Map<String, String> datos = new HashMap<String, String>();
		datos.put("password1", password1);
		datos.put("password2", password2);
		String respuesta = this.encriptacion.bCryptCompare(datos).getBody().toString();
		return respuesta;
	}
	
	@ShellMethod(value = "Metodo que encripta una cadena y retorna el resultado encriptado en c",
			key = "pbkdf2")
	public String pbkdf2(String cadena) {
		Map<String, String> datos = new HashMap<String, String>();
		datos.put("password", cadena);
		String respuesta = this.encriptacion.pbkdf2(datos).getBody().toString();
		return respuesta;
	}
	
	@ShellMethod(value = "Metodo que compara dos cadenas, una la encripta en pbkdf2 y verifica si hace match la cadena encriptada con la cadena no encriptada",
			key = "pbkdf2Compare")
	public String pbkdf2Compare(String cadena1, String cadena2) {
		Map<String, String> datos = new HashMap<String, String>();
		datos.put("password1", cadena1);
		datos.put("password2", cadena2);
		String respuesta = this.encriptacion.pbkdf2Compare(datos).getBody().toString();
		return respuesta;
	}

}
