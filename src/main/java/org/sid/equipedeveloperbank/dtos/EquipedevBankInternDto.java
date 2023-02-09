package org.sid.equipedeveloperbank.dtos;

import lombok.Data;
import org.sid.equipedeveloperbank.entities.Developer;
import org.sid.equipedeveloperbank.enums.AccountStatus;

import java.util.Date;
@Data
public class EquipedevBankInternDto extends EquipeDevBankDto{
    private String id;
    private double salaire;
    private Date createDate;
    private AccountStatus status;
    private DeveloperDto developerDto;
    //private List<DeveloperBankOperation> developerBankOperations;
}

