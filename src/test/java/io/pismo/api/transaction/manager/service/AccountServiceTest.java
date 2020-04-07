package io.pismo.api.transaction.manager.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.pismo.api.transaction.manager.UnitTest;
import io.pismo.api.transaction.manager.entity.AccountEntity;
import io.pismo.api.transaction.manager.exception.ApiException;
import io.pismo.api.transaction.manager.models.Account;
import io.pismo.api.transaction.manager.repository.AccountRepository;
import io.pismo.api.transaction.manager.util.BaseConverter;

public class AccountServiceTest extends UnitTest {

	@InjectMocks
	private AccountService accountService;

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private BaseConverter baseConverter;

	@Test
	public void createAccountSuccessful() {

		Optional<AccountEntity> accountEntity = this.createAccountEntity();

		Optional<Account> accountModel = this.createAccountModel();

		Mockito.when(this.baseConverter.fromObjectToClass(accountModel.get(), AccountEntity.class))
				.thenReturn(accountEntity);

		Mockito.when(this.accountRepository.save(accountEntity.get())).thenReturn(accountEntity.get());

		Mockito.when(this.baseConverter.fromObjectToClass(accountEntity.get(), Account.class)).thenReturn(accountModel);

		Optional<Account> createdAccount = this.accountService.createAccount(accountModel.get());

		assertTrue(createdAccount.isPresent());

	}

	@Test()
	public void createAccountUnsuccessful() {

		Optional<AccountEntity> accountEntity = Optional.empty();

		Optional<Account> accountModel = this.createAccountModel();

		Mockito.when(this.baseConverter.fromObjectToClass(accountModel.get(), AccountEntity.class))
				.thenReturn(accountEntity);

		assertThrows(ApiException.class, () -> {
			this.accountService.createAccount(accountModel.get());
		});

	}
	
	@Test()
	public void createExistingAccountUnsuccessful() {

		Optional<AccountEntity> accountEntity = this.createAccountEntity();

		Optional<Account> accountModel = this.createAccountModel();

		Mockito.when(this.accountRepository.findByDocumentNumber(DOCUMENT_NUMBER)).thenReturn(accountEntity);

		assertThrows(ApiException.class, () -> {
			this.accountService.createAccount(accountModel.get());
		});

	}

	@Test
	public void findAccountByIdSuccessful() {

		Optional<AccountEntity> accountEntity = this.createAccountEntity();

		Optional<Account> accountModel = this.createAccountModel();

		Mockito.when(this.accountRepository.findById(ACCOUNT_ID)).thenReturn(accountEntity);

		Mockito.when(this.baseConverter.fromObjectToClass(accountEntity.get(), Account.class)).thenReturn(accountModel);

		Optional<Account> createdAccount = this.accountService.getAccountById(ACCOUNT_ID);

		assertTrue(createdAccount.isPresent());	

	}

	@Test
	public void findAccountByIdUnsuccessful() {

		Optional<AccountEntity> accountEntity = Optional.empty();

		Mockito.when(this.accountRepository.findById(ACCOUNT_ID)).thenReturn(accountEntity);

		Optional<Account> foundAccount = this.accountService.getAccountById(ACCOUNT_ID);
		
		assertFalse(foundAccount.isPresent());
	}
}
