package com.fomacionbdi.springboot.app.ouath.controllador;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fomacionbdi.springboot.app.ouath.entity.Usuario;

@Controller
public class UsuarioController {

	private static final Map<String, Usuario> map = new HashMap<String, Usuario>();
	private static final Logger log = LoggerFactory.getLogger(Interceptor.class);

	@GetMapping("/saludo2")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public String otroMetodo() {

		return "Hi";
	}

	@GetMapping(path = "/listar")
	public ResponseEntity<Object> listar() {
		log.info("LISTAR");
		llenar();
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	public static void llenar() {

		Usuario user1 = new Usuario("pepe", "lopez");
		Usuario user2 = new Usuario("pepa", "garcia");
		Usuario user3 = new Usuario("prueba", "apellidoPrueba");
		map.put(user1.getNombre(), user1);
		map.put(user2.getNombre(), user2);
		map.put(user3.getNombre(), user3);
	}

}
