package com.pichincha.dto;

import java.util.List;

import com.pichincha.model.Account;
import com.pichincha.model.Movement;

import lombok.Data;

@Data
public class AccountMovementDTO {

	private Account account;
	private List<Movement> lstMovements;
}
