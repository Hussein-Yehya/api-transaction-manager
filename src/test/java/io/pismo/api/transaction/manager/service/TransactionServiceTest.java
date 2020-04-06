package io.pismo.api.transaction.manager.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.pismo.api.transaction.manager.UnitTest;
import io.pismo.api.transaction.manager.entity.AccountEntity;
import io.pismo.api.transaction.manager.entity.OperationTypeEntity;
import io.pismo.api.transaction.manager.entity.TransactionEntity;
import io.pismo.api.transaction.manager.exception.ApiException;
import io.pismo.api.transaction.manager.models.Transaction;
import io.pismo.api.transaction.manager.repository.AccountRepository;
import io.pismo.api.transaction.manager.repository.OperationTypeRepository;
import io.pismo.api.transaction.manager.repository.TransactionRepository;
import io.pismo.api.transaction.manager.util.BaseConverter;

public class TransactionServiceTest extends UnitTest {

	@InjectMocks
	private TransactionService transactionService;

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private OperationTypeRepository operationTypeRepository;

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private BaseConverter baseConverter;

	@Test
	public void createTransaciontSuccessful() {

		Optional<Transaction> transactionModel = this.createTransactionModel();
		Optional<TransactionEntity> transactionEntity = this.createTransactionEntity();
		Optional<AccountEntity> accountEntity = this.createAccountEntity();
		Optional<OperationTypeEntity> operationTypeEntity = this.createOperationTypeEntity();

		Mockito.when(this.baseConverter.fromObjectToClass(transactionModel.get(), TransactionEntity.class))
				.thenReturn(transactionEntity);

		Mockito.when(this.operationTypeRepository.findById(OPERATION_TYPE_ID)).thenReturn(operationTypeEntity);

		Mockito.when(this.accountRepository.findById(ACCOUNT_ID)).thenReturn(accountEntity);

		Mockito.when(this.transactionRepository.save(transactionEntity.get())).thenReturn(transactionEntity.get());

		Mockito.when(this.baseConverter.fromObjectToClass(transactionEntity.get(), Transaction.class))
				.thenReturn(transactionModel);

		Optional<Transaction> createTransaction = this.transactionService.createTransaction(transactionModel.get());

		assertTrue(createTransaction.isPresent());
	}

	@Test
	public void createTransaciontUnsuccessful() {

		Optional<Transaction> transactionModel = this.createTransactionModel();
		Optional<TransactionEntity> transactionEntity = Optional.empty();
		Optional<AccountEntity> accountEntity = this.createAccountEntity();
		Optional<OperationTypeEntity> operationTypeEntity = this.createOperationTypeEntity();

		Mockito.when(this.operationTypeRepository.findById(OPERATION_TYPE_ID)).thenReturn(operationTypeEntity);

		Mockito.when(this.accountRepository.findById(ACCOUNT_ID)).thenReturn(accountEntity);

		Mockito.when(this.baseConverter.fromObjectToClass(transactionModel.get(), TransactionEntity.class))
				.thenReturn(transactionEntity);

		assertThrows(ApiException.class, () -> {
			this.transactionService.createTransaction(transactionModel.get());
		});
	}

	@Test
	public void createTransaciontNotFoundOperationType() {

		Optional<Transaction> transactionModel = this.createTransactionModel();

		Mockito.when(this.operationTypeRepository.findById(OPERATION_TYPE_ID)).thenReturn(Optional.empty());

		assertThrows(ApiException.class, () -> {
			this.transactionService.createTransaction(transactionModel.get());
		});
	}

	@Test
	public void createTransaciontNotFoundAccount() {

		Optional<Transaction> transactionModel = this.createTransactionModel();
		Optional<OperationTypeEntity> operationTypeEntity = this.createOperationTypeEntity();

		Mockito.when(this.operationTypeRepository.findById(OPERATION_TYPE_ID)).thenReturn(operationTypeEntity);

		Mockito.when(this.accountRepository.findById(ACCOUNT_ID)).thenReturn(Optional.empty());

		assertThrows(ApiException.class, () -> {
			this.transactionService.createTransaction(transactionModel.get());
		});
	}

}
