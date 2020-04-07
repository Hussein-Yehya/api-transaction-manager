package io.pismo.api.transaction.manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pismo.api.transaction.manager.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

	Optional<AccountEntity> findByDocumentNumber(String documentNumber);
}
