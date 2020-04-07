package io.pismo.api.transaction.manager.service;

import static io.pismo.api.transaction.manager.exception.ExceptionBuilder.buildExceptionHandler;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.pismo.api.transaction.manager.entity.AccountEntity;
import io.pismo.api.transaction.manager.exception.ApiException;
import io.pismo.api.transaction.manager.models.Account;
import io.pismo.api.transaction.manager.repository.AccountRepository;
import io.pismo.api.transaction.manager.util.BaseConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BaseConverter baseConverter;

	public Optional<Account> createAccount(Account account) {

		this.checkAccountAlreadyExists(account);

		AccountEntity accountEntity = this.converterAccountToEntity(account);

		AccountEntity createdAccount = this.accountRepository.save(accountEntity);

		return this.baseConverter.fromObjectToClass(createdAccount, Account.class);

	}

	public Optional<Account> getAccountById(Long id) {

		Optional<AccountEntity> accountEntity = this.accountRepository.findById(id);

		if (accountEntity.isPresent()) {
			log.info("Found Account {}", accountEntity.toString());
			return this.baseConverter.fromObjectToClass(accountEntity.get(), Account.class);
		}

		return Optional.empty();
	}

	private AccountEntity converterAccountToEntity(Account account) {

		log.info("Converting Account to AccountEntity");
		return this.baseConverter.fromObjectToClass(account, AccountEntity.class)
				.orElseThrow(buildExceptionHandler(INTERNAL_SERVER_ERROR, "Unable to convert Account to entity"));
	}

	private void checkAccountAlreadyExists(Account account) {

		this.accountRepository.findByDocumentNumber(account.getDocumentNumber()).ifPresent(a -> {
			throw new ApiException(CONFLICT.name(), "The account could not be created because it already exists",
					CONFLICT.value());
		});
	}

}
