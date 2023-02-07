package org.sid.equipedeveloperbank.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.equipedeveloperbank.enums.TypeOperation;

import java.util.Date;


@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class DeveloperBankOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private String description;
    private double amount;
    @Enumerated(EnumType.STRING)
    private TypeOperation typeOperation ;

    @ManyToOne
    private EquipeDevBank equipeDevBank ;
}
