package io.pismo.api.transaction.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "document_number", unique = true)
	private String documentNumber;

	public AccountEntity id(Long id) {
		this.id = id;
		return this;
	}

	public AccountEntity documentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
		return this;
	}

}
