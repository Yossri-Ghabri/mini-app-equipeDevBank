package org.sid.equipedeveloperbank.services;

import org.sid.equipedeveloperbank.dtos.DeveloperDto;
import org.sid.equipedeveloperbank.dtos.EquipeDevBankDto;
import org.sid.equipedeveloperbank.dtos.EquipedevBankExternDto;
import org.sid.equipedeveloperbank.dtos.EquipedevBankInternDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class EquipeDevBankServiceImpl implements EquipeDevBankService{
    @Override
    public DeveloperDto saveDeveloper(DeveloperDto developerDto) {
        return null;
    }

    @Override
    public DeveloperDto updateDeveloper(DeveloperDto developerDto) {
        return null;
    }

    @Override
    public void deleteDeveloper(Long idDeveloper) {

    }

    @Override
    public List<DeveloperDto> listDeveloperDto() {
        return null;
    }

    @Override
    public DeveloperDto getDeveloper(Long idDeveloper) {
        return null;
    }

    @Override
    public EquipedevBankExternDto saveExternDeveloper(Long idDeveloper, double salary) {
        return null;
    }

    @Override
    public EquipedevBankInternDto saveInternDeveloper(Long idDeveloper, double salary) {
        return null;
    }

    @Override
    public EquipeDevBankDto getEquipeDevBankDto(Long idEquipeDevBank) {
        return null;
    }

    @Override
    public List<EquipeDevBankDto> listEquipeDevBank() {
        return null;
    }

    @Override
    public void prime(Long idAccountEquipeDev, double amount, String description) {

    }

    @Override
    public void credit(Long idAccountEquipeDev, double amount, String description) {

    }
}
