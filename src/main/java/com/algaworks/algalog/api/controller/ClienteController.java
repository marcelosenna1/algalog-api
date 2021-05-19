package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {

		var c1 = new Cliente(1L,"Marcelo1","75 991252901","marcelomarcos2@gmail.com");
		var c2 = new Cliente(1L,"Zeus","75 991252901","zeus2@gmail.com");
		

		return Arrays.asList(c1, c2);
	}
}
