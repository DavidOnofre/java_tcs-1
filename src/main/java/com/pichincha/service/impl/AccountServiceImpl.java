package com.pichincha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pichincha.dto.AccountMovementDTO;
import com.pichincha.model.Account;
import com.pichincha.repo.IAccountRepo;
import com.pichincha.repo.IGenericRepo;
import com.pichincha.repo.IMovementRepo;
import com.pichincha.service.IAccountService;

@Service
public class AccountServiceImpl extends CRUDImpl<Account, Integer> implements IAccountService {

	@Autowired
	private IAccountRepo repo;
	
	@Autowired
	private IMovementRepo repoMov;

	@Override
	protected IGenericRepo<Account, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Account registrar(AccountMovementDTO dto) throws Exception {
		dto.getAccount().getMovement().forEach(det -> det.setAccount(dto.getAccount()));
		repo.save(dto.getAccount());
		
		dto.getLstMovements().forEach(mov -> repoMov.registrar(dto.getAccount().getIdAccount(), mov.getIdMovement()));

		return dto.getAccount();
	}

}
