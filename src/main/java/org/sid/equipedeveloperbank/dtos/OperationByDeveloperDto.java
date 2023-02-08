package org.sid.equipedeveloperbank.dtos;

import lombok.Data;
import org.sid.equipedeveloperbank.enums.TypeOperation;

import java.util.Date;
@Data
public class OperationByDeveloperDto {
    private Long id;
    private Date operationDate;
    private String description;
    private double amount;
    private TypeOperation typeOperation ;
}

