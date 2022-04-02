package com.pichincha.service;

import com.pichincha.dto.AccountDTO;
import com.pichincha.model.Account;

public interface IAccountService extends ICRUD<Account, Integer> {

	Account registrarTransaccional(Account account) throws Exception;

	AccountDTO modificarCuenta(AccountDTO dto);

}
