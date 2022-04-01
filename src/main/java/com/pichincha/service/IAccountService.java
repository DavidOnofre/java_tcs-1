package com.pichincha.service;

import com.pichincha.dto.AccountMovementDTO;
import com.pichincha.model.Account;

public interface IAccountService extends ICRUD<Account, Integer>{
	
	Account registrar (AccountMovementDTO dto) throws Exception;

}
