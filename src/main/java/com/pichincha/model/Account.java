package com.pichincha.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAccount;

	@NotNull
	@Size(min = 10, max = 10, message = "accountNumber must be 10 characters.")
	@Column(name = "accountNumber", nullable = false, length = 10)
	private String accountNumber;

	@NotNull
	@Size(min = 3, max = 3, message = "accountType must be AHO - COR.")
	@Column(name = "accountType", nullable = false, length = 3)
	private String accountType;

	@NotNull
	@Size(min = 10, max = 10, message = "client must be 10 characters.")
	@Column(name = "client", nullable = false, length = 10)
	private String client;

	@OneToMany(mappedBy = "account", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Movement> movement;

}
