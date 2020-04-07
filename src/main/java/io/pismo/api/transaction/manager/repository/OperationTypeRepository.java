package io.pismo.api.transaction.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.pismo.api.transaction.manager.entity.OperationTypeEntity;

public interface OperationTypeRepository extends JpaRepository<OperationTypeEntity, Long> {

}
