package org.sid.equipedeveloperbank.services;

import org.sid.equipedeveloperbank.dtos.DeveloperDto;
import org.sid.equipedeveloperbank.dtos.EquipeDevBankDto;
import org.sid.equipedeveloperbank.dtos.EquipedevBankExternDto;
import org.sid.equipedeveloperbank.dtos.EquipedevBankInternDto;

import java.util.List;

public interface EquipeDevBankService {

    DeveloperDto saveDeveloper(DeveloperDto developerDto);
    DeveloperDto updateDeveloper(DeveloperDto developerDto);
    void deleteDeveloper(Long idDeveloper);
    List<DeveloperDto> listDeveloperDto();
    DeveloperDto getDeveloper(Long idDeveloper);
    EquipedevBankExternDto saveExternDeveloper(Long idDeveloper, double salary);
    EquipedevBankInternDto saveInternDeveloper(Long idDeveloper, double salary);
    EquipeDevBankDto getEquipeDevBankDto(Long idEquipeDevBank);
    List<EquipeDevBankDto> listEquipeDevBank();
    void prime(Long idAccountEquipeDev, double amount, String description);
    void credit(Long idAccountEquipeDev, double amount, String description);


}
