package com.pichincha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.model.Movement;
import com.pichincha.service.IMovementService;

@RestController
@RequestMapping("api/v1/movements")
public class MovementController {

	@Autowired
	private IMovementService service;

	@GetMapping
	public ResponseEntity<List<Movement>> getAll() throws Exception {
		List<Movement> movements = service.listar();
		return new ResponseEntity<List<Movement>>(movements, HttpStatus.OK);
	}

	@GetMapping("/accounts/{id}")
	public ResponseEntity<List<Movement>> getAll(@PathVariable("id") Integer id) throws Exception {
		List<Movement> movements = service.listarMovimientosPorCuentas(id);
		return new ResponseEntity<List<Movement>>(movements, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
