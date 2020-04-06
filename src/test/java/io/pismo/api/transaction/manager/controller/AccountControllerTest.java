package io.pismo.api.transaction.manager.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.http.HttpStatus.OK;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import io.pismo.api.transaction.manager.UnitTest;
import io.pismo.api.transaction.manager.exception.ApiException;
import io.pismo.api.transaction.manager.models.Account;
import io.pismo.api.transaction.manager.service.AccountService;

public class AccountControllerTest extends UnitTest {

	@InjectMocks
	private AccountController accountController;

	@Mock
	private AccountService accountService;

	@Test
	public void createAccountSuccessful() {

		Optional<Account> accountModel = this.createAccountModel();

		Mockito.when(this.accountService.createAccount(accountModel.get())).thenReturn(accountModel);

		ResponseEntity<Account> responseEntity = this.accountController.createAccount(accountModel.get());

		assertEquals(OK, responseEntity.getStatusCode());

	}

	@Test
	public void createAccountInternalServerError() {

		Optional<Account> accountModel = this.createAccountModel();

		Mockito.when(this.accountService.createAccount(accountModel.get())).thenReturn(Optional.empty());

		assertThrows(ApiException.class, () -> {
			this.accountController.createAccount(accountModel.get());
		});
	}

	@Test
	public void getAccountByIdSuccessful() {

		Optional<Account> accountModel = this.createAccountModel();

		Mockito.when(this.accountService.getAccountById(ACCOUNT_ID)).thenReturn(accountModel);

		ResponseEntity<Account> responseEntity = this.accountController.getAccountById(ACCOUNT_ID);

		assertEquals(OK, responseEntity.getStatusCode());

	}

	@Test
	public void getAccountByIdUnsuccessful() {

		Optional<Account> accountModel = Optional.empty();

		Mockito.when(this.accountService.getAccountById(ACCOUNT_ID)).thenReturn(accountModel);

		assertThrows(ApiException.class, () -> {
			this.accountController.getAccountById(ACCOUNT_ID);
		});
	}
}
