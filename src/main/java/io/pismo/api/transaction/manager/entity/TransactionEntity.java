package io.pismo.api.transaction.manager.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.pismo.api.transaction.manager.constants.OperationTypes;
import lombok.Data;

@Data
@Entity
@Table(name = "transaction")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private AccountEntity accountEntity;

	@ManyToOne
	private OperationTypeEntity operationTypeEntity;

	private BigDecimal amount;

	@Column(name = "event_date")
	private LocalDateTime evendDate;

	public TransactionEntity id(Long id) {
		this.id = id;
		return this;
	}

	public TransactionEntity accountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
		return this;
	}

	public TransactionEntity operationTypeEntity(OperationTypeEntity operationTypeEntity) {
		this.operationTypeEntity = operationTypeEntity;
		return this;
	}

	public TransactionEntity amount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public TransactionEntity evendDate(LocalDateTime evendDate) {
		this.evendDate = evendDate;
		return this;
	}

	@Transient
	public TransactionEntity buildTransaction(OperationTypeEntity operationTypeEntity, AccountEntity accountEntity) {

		this.setAccountEntity(accountEntity);
		this.setOperationTypeEntity(operationTypeEntity);
		this.setAmount(this.checkOperationType(operationTypeEntity));
		this.setEvendDate(LocalDateTime.now());

		return this;
	}

	@Transient
	public BigDecimal checkOperationType(OperationTypeEntity operationTypeEntity) {

		if (OperationTypes.PAGAMENTO.getLabel().equals(operationTypeEntity.getDescription())) {
			return new BigDecimal(this.getAmount().doubleValue());
		}

		return new BigDecimal(this.getAmount().doubleValue()).negate();
	}
}
