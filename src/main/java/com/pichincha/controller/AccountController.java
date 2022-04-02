package com.pichincha.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.dto.AccountDTO;
import com.pichincha.model.Account;
import com.pichincha.service.IAccountService;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

	@Autowired
	private IAccountService service;

	@GetMapping
	public ResponseEntity<List<Account>> getAll() throws Exception {
		List<Account> lista = service.listar();
		return new ResponseEntity<List<Account>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Account account = service.listarPorId(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Account> registrar(@Valid @RequestBody Account account) throws Exception {
		Account a = service.registrarTransaccional(account);
		return new ResponseEntity<Account>(a, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<AccountDTO> modificar(@Valid @RequestBody AccountDTO dto) {
		AccountDTO p = service.modificarCuenta(dto);
		return new ResponseEntity<AccountDTO>(p, HttpStatus.OK);
	}

}
