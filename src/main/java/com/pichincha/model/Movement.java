package com.pichincha.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "movement")
public class Movement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMovement;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idAccount", nullable = false, foreignKey = @ForeignKey(name = "FK_account_movement"))
	private Account account;

	@NotNull
	@Size(min = 1, max = 6, message = "amount between 1-6, example: 999999")
	@Column(name = "amount", nullable = false, length = 70)
	private String amount;

	@NotNull
	@Column(name = "detail", nullable = false, length = 25)
	private String detail;

	@Column(name = "date", nullable = false)
	private LocalDateTime date;

}
