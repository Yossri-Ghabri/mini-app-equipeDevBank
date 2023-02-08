package org.sid.equipedeveloperbank.repositories;

import org.sid.equipedeveloperbank.entities.DeveloperBankOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperBankOperationRepository extends JpaRepository<DeveloperBankOperation, Long> {
    //  List<DeveloperBankOperation> findByOperationByDeveloper(Long id);
    //   Page<DeveloperBankOperation> findByBankAccountId(Long accountId, Pageable pageable);
 //   List<DeveloperBankOperation> findByEquipDevBankId(Long Id);
}
