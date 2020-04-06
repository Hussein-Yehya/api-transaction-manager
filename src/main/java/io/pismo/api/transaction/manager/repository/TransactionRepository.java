package io.pismo.api.transaction.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pismo.api.transaction.manager.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
