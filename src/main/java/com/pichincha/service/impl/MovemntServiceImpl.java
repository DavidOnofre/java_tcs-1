package com.pichincha.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.model.Movement;
import com.pichincha.repo.IGenericRepo;
import com.pichincha.repo.IMovementRepo;
import com.pichincha.service.IMovementService;

@Service
public class MovemntServiceImpl extends CRUDImpl<Movement, Integer> implements IMovementService {

	@Autowired
	private IMovementRepo repo;

	@Override
	protected IGenericRepo<Movement, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Movement> listarMovimientosPorCuentas(Integer idCuenta) {
		List<Movement> movemenstsCuentas = new ArrayList<Movement>();

		List<Movement> movemensts = repo.findAll();
		for (Movement movement : movemensts) {
			if (movement.getAccount().getIdAccount() == idCuenta) {
				movemenstsCuentas.add(movement);		
			}
		}

		return movemenstsCuentas;
	}

}
