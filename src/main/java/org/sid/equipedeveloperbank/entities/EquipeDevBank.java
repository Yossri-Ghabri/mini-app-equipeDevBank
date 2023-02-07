package org.sid.equipedeveloperbank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.equipedeveloperbank.enums.AccountStatus;

import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public abstract class  EquipeDevBank {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double salaire;
    private Date createDate;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
   // private List<Developer> developers;
    @ManyToOne
    private Developer developer;
    @OneToMany (mappedBy = "equipeDevBank", fetch = FetchType.LAZY)
    private List<DeveloperBankOperation> developerBankOperations;
}
