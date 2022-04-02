package com.pichincha.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.dto.AccountDTO;
import com.pichincha.model.Account;
import com.pichincha.repo.IAccountRepo;
import com.pichincha.repo.IGenericRepo;
import com.pichincha.service.IAccountService;

@Service
public class AccountServiceImpl extends CRUDImpl<Account, Integer> implements IAccountService {

	@Autowired
	private IAccountRepo repo;

	@Override
	protected IGenericRepo<Account, Integer> getRepo() {
		return repo;
	}

	@Override
	public Account registrarTransaccional(Account account) throws Exception {
		account.getMovement().forEach(det -> {
			det.setAccount(account);
			det.setDate(LocalDateTime.now());
		});

		return repo.save(account);
	}

	@Override
	public AccountDTO modificarCuenta(AccountDTO dto) {

		// recuperar el account by ID
		Account account = getAccountTODTO(dto);

		// actualizar los datos dto
		account.setAccountNumber(dto.getAccountNumber());
		account.setAccountType(dto.getAccountType());
		account.setClient(dto.getClient());

		// actualizar
		repo.save(account);
		return dto;
	}

	private Account getAccountTODTO(AccountDTO dto) {
		Optional<Account> op = repo.findById(dto.getIdAccount());
		return op.isPresent() ? op.get() : new Account();
	}

}
