package io.pismo.api.transaction.manager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;

import io.pismo.api.transaction.manager.constants.OperationTypes;
import io.pismo.api.transaction.manager.entity.AccountEntity;
import io.pismo.api.transaction.manager.entity.OperationTypeEntity;
import io.pismo.api.transaction.manager.entity.TransactionEntity;
import io.pismo.api.transaction.manager.models.Account;
import io.pismo.api.transaction.manager.models.OperationType;
import io.pismo.api.transaction.manager.models.Transaction;

@TestPropertySource(locations = { "classpath:application-test.yml" })
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public abstract class UnitTest {

	public static final long TRANSACTION_ID = 1L;
	public static final long ACCOUNT_ID = 1L;
	public static final long OPERATION_TYPE_ID = 1L;
	public static final String DOCUMENT_NUMBER = "367.015.760-36";

	public Optional<AccountEntity> createAccountEntity() {
		AccountEntity accountEntity = new AccountEntity().id(ACCOUNT_ID).documentNumber(DOCUMENT_NUMBER);

		return Optional.of(accountEntity);
	}

	public Optional<Account> createAccountModel() {
		Account account = new Account()
				.id(ACCOUNT_ID)
				.documentNumber(DOCUMENT_NUMBER);

		return Optional.of(account);
	}

	public Optional<OperationTypeEntity> createOperationTypeEntity() {
		OperationTypeEntity operationTypeEntity = new OperationTypeEntity()
				.id(OPERATION_TYPE_ID)
				.description(OperationTypes.PAGAMENTO.getLabel())
				;

		return Optional.of(operationTypeEntity);
	}

	public Optional<OperationType> createOperationTypeModel() {
		OperationType operationType = new OperationType()
				.id(OPERATION_TYPE_ID)
				.description(OperationTypes.PAGAMENTO.getLabel());

		return Optional.of(operationType);
	}

	public Optional<TransactionEntity> createTransactionEntity() {
		TransactionEntity transactionEntity =  new TransactionEntity()
				.id(TRANSACTION_ID)
				.accountEntity(this.createAccountEntity().get())
				.operationTypeEntity(this.createOperationTypeEntity().get())
				.amount(new BigDecimal(500))
				.evendDate(LocalDateTime.now());

		return Optional.of(transactionEntity);
	}
	
	public Optional<TransactionEntity> createTransactionEntityNegative() {
		TransactionEntity transactionEntity = new TransactionEntity()
				.id(TRANSACTION_ID)
				.accountEntity(this.createAccountEntity().get())
				.operationTypeEntity(this.createOperationTypeEntity().get())
				.amount(new BigDecimal(500))
				.evendDate(LocalDateTime.now());

		return Optional.of(transactionEntity);
	}

	public Optional<Transaction> createTransactionModel() {
		Transaction transaction = new Transaction()
				.id(TRANSACTION_ID)
				.accountId(ACCOUNT_ID)
				.operationTypeId(OPERATION_TYPE_ID)
				.amount(new BigDecimal(500))
				.eventDate(LocalDateTime.now());

		return Optional.of(transaction);
	}

}
