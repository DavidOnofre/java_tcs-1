package com.pichincha.service;

import com.pichincha.dto.AccountMovementDTO;
import com.pichincha.model.Movement;

public interface IMovementService extends ICRUD<Movement, Integer>{
	
	Movement registrar (AccountMovementDTO dto) throws Exception;

}
