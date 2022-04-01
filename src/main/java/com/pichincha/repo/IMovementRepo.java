package com.pichincha.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pichincha.model.Movement;

public interface IMovementRepo extends IGenericRepo<Movement, Integer>{
	
		@Modifying
		@Query(value = "INSERT INTO movement(id_movement, id_account) VALUES (:idMovement, :idAccount)", nativeQuery = true)
		Integer registrar(@Param("idMovement") Integer idConsulta, @Param("idAccount") Integer idExamen);

}
