package org.sid.equipedeveloperbank.dtos;

import jakarta.persistence.*;
import lombok.Data;
import org.sid.equipedeveloperbank.entities.Developer;
import org.sid.equipedeveloperbank.entities.DeveloperBankOperation;
import org.sid.equipedeveloperbank.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Data
public class EquipedevBankExternDto extends EquipeDevBankDto {


    private String id;
    private double salaire;
    private Date createDate;
    private AccountStatus status;
    private DeveloperDto developerDto;
    //private List<DeveloperBankOperation> developerBankOperations;
}
