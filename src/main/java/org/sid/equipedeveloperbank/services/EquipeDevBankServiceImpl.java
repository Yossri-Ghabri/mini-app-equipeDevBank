package org.sid.equipedeveloperbank.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.equipedeveloperbank.dtos.DeveloperDto;
import org.sid.equipedeveloperbank.dtos.EquipeDevBankDto;
import org.sid.equipedeveloperbank.dtos.EquipedevBankExternDto;
import org.sid.equipedeveloperbank.dtos.EquipedevBankInternDto;
import org.sid.equipedeveloperbank.entities.Developer;
import org.sid.equipedeveloperbank.mappers.EquipeDeveloperMapperImp;
import org.sid.equipedeveloperbank.repositories.DeveloperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EquipeDevBankServiceImpl implements EquipeDevBankService {

    private EquipeDeveloperMapperImp dtoDeveloperMapper;
    private DeveloperRepository developerRepository;

    @Override
    public DeveloperDto saveDeveloper(DeveloperDto developerDto) {
        log.info("Saving New Developer");
        Developer developer = dtoDeveloperMapper.fromDeveloperDto(developerDto);
        Developer savingDeveloper = developerRepository.save(developer);
        return dtoDeveloperMapper.fromEntityDeveloper(savingDeveloper);
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
