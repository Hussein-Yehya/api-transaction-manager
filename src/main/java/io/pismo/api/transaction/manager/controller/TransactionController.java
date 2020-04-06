package io.pismo.api.transaction.manager.controller;

import static io.pismo.api.transaction.manager.exception.ExceptionBuilder.buildExceptionHandler;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.pismo.api.transaction.manager.TransactionsApi;
import io.pismo.api.transaction.manager.models.Transaction;
import io.pismo.api.transaction.manager.service.TransactionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TransactionController implements TransactionsApi {
	
	@Autowired
	private TransactionService transactionService;

	@Override
	public ResponseEntity<Transaction> createTransaction(@Valid Transaction body) {

		log.info("Creating transaction {}", body.toString());
		
		return ResponseEntity.ok(this.transactionService.createTransaction(body)
				.orElseThrow(buildExceptionHandler(INTERNAL_SERVER_ERROR, "Unable to create account")));
	}

}
