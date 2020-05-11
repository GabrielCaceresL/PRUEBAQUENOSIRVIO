package com.fomacionbdi.springboot.app.ouath.controllador;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerPrueba {

	@GetMapping("/saludo")
	public String otroMetodo() {
		System.out.println(".-asda--da-s-a-sd-asd-a-sd-sa-d-as-da-sd-asa-d-as-sd-----------");
		return "Hi";
	}
}
