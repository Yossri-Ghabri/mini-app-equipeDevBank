package org.sid.equipedeveloperbank.services;

import org.sid.equipedeveloperbank.dtos.*;
import org.sid.equipedeveloperbank.entities.DeveloperBankOperation;
import org.sid.equipedeveloperbank.exceptions.DeveloperNotFoundException;
import org.sid.equipedeveloperbank.exceptions.EquipeDevBankNotFoundException;
import org.sid.equipedeveloperbank.exceptions.PrimeInterditSupeMaxException;
import org.sid.equipedeveloperbank.exceptions.SalaireDeveloperNotSufficentException;

import java.util.List;

public interface EquipeDevBankService {

    DeveloperDto saveDeveloper(DeveloperDto developerDto);
    DeveloperDto updateDeveloper(DeveloperDto developerDto);
    void deleteDeveloper(Long idDeveloper);
    List<DeveloperDto> listDeveloperDto();
    DeveloperDto getDeveloper(Long idDeveloper) throws DeveloperNotFoundException;
    EquipedevBankExternDto saveExternDeveloper(Long idDeveloper, double salary) throws DeveloperNotFoundException;
    EquipedevBankInternDto saveInternDeveloper(Long idDeveloper, double salary) throws DeveloperNotFoundException;
    EquipeDevBankDto getEquipeDevBankDto(Long idEquipeDevBank) throws EquipeDevBankNotFoundException;
    List<EquipeDevBankDto> listEquipeDevBank();
    void prime(Long idAccountEquipeDev, double amount, String description) throws EquipeDevBankNotFoundException, PrimeInterditSupeMaxException;
    void credit(Long idAccountEquipeDev, double amount, String description) throws EquipeDevBankNotFoundException, SalaireDeveloperNotSufficentException;
   // List<OperationByDeveloperDto> listOperationByDeveloper(Long idEquipDevBank);
    List<DeveloperBankOperation> listOperationByDeveloper(Long id);

}
