package com.pichincha.service;

import java.util.List;

import com.pichincha.model.Movement;

public interface IMovementService extends ICRUD<Movement, Integer>{

	List<Movement> listarMovimientosPorCuentas(Integer idCuenta);

}
