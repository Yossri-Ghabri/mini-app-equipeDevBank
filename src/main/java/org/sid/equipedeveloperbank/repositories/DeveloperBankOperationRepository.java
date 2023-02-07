package org.sid.equipedeveloperbank.repositories;

import org.sid.equipedeveloperbank.entities.DeveloperBankOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperBankOperationRepository extends JpaRepository<DeveloperBankOperation, Long> {
}
