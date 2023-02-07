package org.sid.equipedeveloperbank.repositories;

import org.sid.equipedeveloperbank.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
