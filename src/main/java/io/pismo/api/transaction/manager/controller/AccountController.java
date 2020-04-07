package io.pismo.api.transaction.manager.controller;

import static io.pismo.api.transaction.manager.exception.ExceptionBuilder.buildExceptionHandler;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.pismo.api.transaction.manager.AccountsApi;
import io.pismo.api.transaction.manager.models.Account;
import io.pismo.api.transaction.manager.service.AccountService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AccountController implements AccountsApi {

	@Autowired
	private AccountService accountService;

	@Override
	public ResponseEntity<Account> createAccount(@Valid Account body) {
 
		log.info("Creating account {}", body.toString());

		return ResponseEntity.ok(this.accountService.createAccount(body)
				.orElseThrow(buildExceptionHandler(INTERNAL_SERVER_ERROR, "Unable to create account")));
	}

	@Override
	public ResponseEntity<Account> getAccountById(Long accountId) {

		log.info("Looking for the account by id {}", accountId);

		return ResponseEntity.ok(this.accountService.getAccountById(accountId)
				.orElseThrow(buildExceptionHandler(HttpStatus.NOT_FOUND, "Unable to find account")));
	}

}
