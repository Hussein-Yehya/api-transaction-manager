package io.pismo.api.transaction.manager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "operation_type")
public class OperationTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	public OperationTypeEntity id(Long id) {
		this.id = id;
		return this;
	}
	
	public OperationTypeEntity description(String description) {
		this.description = description;
		return this;
	}
}
