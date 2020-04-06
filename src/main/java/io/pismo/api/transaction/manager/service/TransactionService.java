	package io.pismo.api.transaction.manager.service;

import static io.pismo.api.transaction.manager.exception.ExceptionBuilder.buildExceptionHandler;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pismo.api.transaction.manager.entity.AccountEntity;
import io.pismo.api.transaction.manager.entity.OperationTypeEntity;
import io.pismo.api.transaction.manager.entity.TransactionEntity;
import io.pismo.api.transaction.manager.models.Transaction;
import io.pismo.api.transaction.manager.repository.AccountRepository;
import io.pismo.api.transaction.manager.repository.OperationTypeRepository;
import io.pismo.api.transaction.manager.repository.TransactionRepository;
import io.pismo.api.transaction.manager.util.BaseConverter;

@Service
public class TransactionService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private OperationTypeRepository operationTypeRepository;

	@Autowired
	private BaseConverter baseConverter;

	public Optional<Transaction> createTransaction(Transaction transaction) {

		OperationTypeEntity operationTypeEntity = this.getOperationTypeById(transaction.getOperationTypeId());

		AccountEntity accountEntity = this.getAccountById(transaction.getAccountId());

		TransactionEntity transactionEntity = this.converterTransactionToEntity(transaction)
				.buildTransaction(operationTypeEntity, accountEntity);

		TransactionEntity createdTransaction = this.transactionRepository.save(transactionEntity);

		return this.baseConverter.fromObjectToClass(createdTransaction, Transaction.class);
	}

	private AccountEntity getAccountById(Long accountId) {
		return this.accountRepository.findById(accountId).orElseThrow(
				buildExceptionHandler(NOT_FOUND, "The account could not be found because it does not exist"));
	}

	private OperationTypeEntity getOperationTypeById(Long operationTypeId) {
		return this.operationTypeRepository.findById(operationTypeId).orElseThrow(
				buildExceptionHandler(NOT_FOUND, "Operation could not be found because it does not exist"));
	}

	private TransactionEntity converterTransactionToEntity(Transaction transaction) {
		return this.baseConverter.fromObjectToClass(transaction, TransactionEntity.class)
				.orElseThrow(buildExceptionHandler(INTERNAL_SERVER_ERROR, "Unable to convert transaction"));
	}
}
