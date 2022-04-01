package com.pichincha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.dto.AccountMovementDTO;
import com.pichincha.model.Account;
import com.pichincha.service.IAccountService;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

	@Autowired
	private IAccountService service;

	@GetMapping
	public AccountMovementDTO ver()  {
		return new AccountMovementDTO();
	}
	
	@PostMapping
	public ResponseEntity<Account> registrar(@Valid @RequestBody AccountMovementDTO dto) throws Exception {
		Account obj = service.registrar(dto);
		return new ResponseEntity<Account>(obj, HttpStatus.CREATED);
	}

}
