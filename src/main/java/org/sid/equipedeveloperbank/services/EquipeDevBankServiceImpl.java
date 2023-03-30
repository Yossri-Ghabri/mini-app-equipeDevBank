package org.sid.equipedeveloperbank.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.equipedeveloperbank.dtos.*;
import org.sid.equipedeveloperbank.entities.*;
import org.sid.equipedeveloperbank.enums.AccountStatus;
import org.sid.equipedeveloperbank.enums.BadgeExtern;
import org.sid.equipedeveloperbank.enums.BadgeIntern;
import org.sid.equipedeveloperbank.enums.TypeOperation;
import org.sid.equipedeveloperbank.exceptions.DeveloperNotFoundException;
import org.sid.equipedeveloperbank.exceptions.EquipeDevBankNotFoundException;
import org.sid.equipedeveloperbank.exceptions.PrimeInterditSupeMaxException;
import org.sid.equipedeveloperbank.exceptions.SalaireDeveloperNotSufficentException;
import org.sid.equipedeveloperbank.mappers.EquipeDeveloperMapperImp;
import org.sid.equipedeveloperbank.repositories.DeveloperBankOperationRepository;
import org.sid.equipedeveloperbank.repositories.DeveloperRepository;
import org.sid.equipedeveloperbank.repositories.EquipeDevBankRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EquipeDevBankServiceImpl implements EquipeDevBankService {

    private EquipeDeveloperMapperImp dtoDeveloperMapper;
    private DeveloperRepository developerRepository;
    private EquipeDevBankRepository equipeDevBankRepository;
    private DeveloperBankOperationRepository developerBankOperationRepository;

    @Override
    public DeveloperDto saveDeveloper(DeveloperDto developerDto) {
        log.info("Saving New Developer");
        Developer developer = dtoDeveloperMapper.fromDeveloperDto(developerDto);
        Developer savingDeveloper = developerRepository.save(developer);
        return dtoDeveloperMapper.fromEntityDeveloper(savingDeveloper);
    }

    @Override
    public DeveloperDto updateDeveloper(DeveloperDto developerDto) {
        log.info("Update developer");
        Developer developer = dtoDeveloperMapper.fromDeveloperDto(developerDto);
        Developer updateDeveloper = developerRepository.save(developer);
        return dtoDeveloperMapper.fromEntityDeveloper(updateDeveloper);
    }

    @Override
    public void deleteDeveloper(Long developerId) {
        if(developerId==null){
            log.error("id is null");
        }
        developerRepository.deleteById(developerId);
    }

    @Override
    public List<DeveloperDto> listDeveloperDto() {
        List<Developer> developers = developerRepository.findAll();
        List<DeveloperDto> developerDtos = developers.stream()
                .map(developer -> dtoDeveloperMapper.fromEntityDeveloper(developer))
                .collect(Collectors.toList());
        return developerDtos;
    }

    @Override
    public DeveloperDto getDeveloper(Long idDeveloper) throws DeveloperNotFoundException {
        Developer developer = developerRepository.findById(idDeveloper).orElseThrow(() ->
                new DeveloperNotFoundException("Developer Not Found"));
        return dtoDeveloperMapper.fromEntityDeveloper(developer);
    }

    @Override
    public EquipedevBankExternDto saveExternDeveloper(Long idDeveloper, double salary) throws DeveloperNotFoundException {
        Developer developer = developerRepository.findById(idDeveloper).orElseThrow(() ->
                new DeveloperNotFoundException("Developer Not Found"));
        ExternDeveloper externDeveloper = new ExternDeveloper();
        externDeveloper.setId(UUID.randomUUID().toString());
        externDeveloper.setDeveloper(developer);
        externDeveloper.setSalaire(salary);
        externDeveloper.setStatus(AccountStatus.CREATED);
        externDeveloper.setBadgeExtern(BadgeExtern.BADGE_EXTERN);
        externDeveloper.setCreateDate(new Date());
        ExternDeveloper savingExternDeveloper = equipeDevBankRepository.save(externDeveloper);
        return dtoDeveloperMapper.fromEntityExternDeveloper(savingExternDeveloper);
    }

    @Override
    public EquipedevBankInternDto saveInternDeveloper(Long idDeveloper, double salary) throws DeveloperNotFoundException {
        Developer developer = developerRepository.findById(idDeveloper).orElseThrow(() ->
                new DeveloperNotFoundException("Developer Not Found Exception"));
        InternDeveloper internDeveloper = new InternDeveloper();
        internDeveloper.setId(UUID.randomUUID().toString());

        internDeveloper.setDeveloper(developer);
        internDeveloper.setBadgeIntern(BadgeIntern.BADGE_INTERN);
        internDeveloper.setSalaire(salary);
        internDeveloper.setCreateDate(new Date());
        internDeveloper.setStatus(AccountStatus.CREATED);
        InternDeveloper savingInternDeveloper = equipeDevBankRepository.save(internDeveloper);

        return dtoDeveloperMapper.fromEntityInternDeveloper(savingInternDeveloper);
    }

    @Override
    public EquipeDevBankDto getEquipeDevBankDto(String idEquipDevBank) throws EquipeDevBankNotFoundException {
        EquipeDevBank equipDevBank = equipeDevBankRepository.findById(idEquipDevBank).orElseThrow(() ->
                new EquipeDevBankNotFoundException("EquipDevBank Not Found"));
        if (equipDevBank instanceof InternDeveloper) {
            InternDeveloper internDeveloper = (InternDeveloper) equipDevBank;
            return dtoDeveloperMapper.fromEntityInternDeveloper(internDeveloper);
        } else {
            ExternDeveloper externDeveloper = (ExternDeveloper) equipDevBank;
            return dtoDeveloperMapper.fromEntityExternDeveloper(externDeveloper);
        }
    }

    @Override
    public List<EquipeDevBankDto> listEquipeDevBank() {
        List<EquipeDevBank> equipDevBanks = equipeDevBankRepository.findAll();
        List<EquipeDevBankDto> equipDevBankDtos = equipDevBanks.stream().map(equipDevBank -> {
            if (equipDevBank instanceof InternDeveloper) {
                InternDeveloper internDeveloper = (InternDeveloper) equipDevBank;
                return dtoDeveloperMapper.fromEntityInternDeveloper(internDeveloper);
            } else {
                ExternDeveloper externDeveloper = (ExternDeveloper) equipDevBank;
                return dtoDeveloperMapper.fromEntityExternDeveloper(externDeveloper);
            }
        }).collect(Collectors.toList());
        return equipDevBankDtos;
    }

    @Override
    public void prime(String idAccountEquipeDev, double amount, String description) throws EquipeDevBankNotFoundException, PrimeInterditSupeMaxException {
        EquipeDevBank equipeDevBank = equipeDevBankRepository.findById(idAccountEquipeDev).orElseThrow(() ->
                new EquipeDevBankNotFoundException("EquipeDevBank Not Found"));
        if (amount > 1000)
            throw new PrimeInterditSupeMaxException("Interdit sup max prime");
        DeveloperBankOperation developerBankOperation = new DeveloperBankOperation();
        developerBankOperation.setEquipeDevBank(equipeDevBank);
        developerBankOperation.setOperationDate(new Date());
        developerBankOperation.setAmount(amount);
        developerBankOperation.setDescription("Prime fin d'annee");
        developerBankOperation.setTypeOperation(TypeOperation.PRIME);
        developerBankOperationRepository.save(developerBankOperation);
        equipeDevBank.setSalaire(equipeDevBank.getSalaire() + amount);
        equipeDevBankRepository.save(equipeDevBank);
    }

    @Override
    public void credit(String idAccountEquipeDev, double amount, String description) throws EquipeDevBankNotFoundException, SalaireDeveloperNotSufficentException {
        EquipeDevBank equipeDevBank = equipeDevBankRepository.findById(idAccountEquipeDev).orElseThrow(() ->
                new EquipeDevBankNotFoundException("EquipeDevBank Not Found"));
        if (equipeDevBank.getSalaire() < 0)
            throw new SalaireDeveloperNotSufficentException("SalaireDeveloper Not Sufficent");
        DeveloperBankOperation developerBankOperation = new DeveloperBankOperation();
        developerBankOperation.setEquipeDevBank(equipeDevBank);
        developerBankOperation.setTypeOperation(TypeOperation.CREDIT);
        developerBankOperation.setOperationDate(new Date());
        developerBankOperation.setDescription("Credit Sur Salaire");
        developerBankOperation.setAmount(amount);
        developerBankOperationRepository.save(developerBankOperation);
        equipeDevBank.setSalaire(equipeDevBank.getSalaire() - amount);
        equipeDevBankRepository.save(equipeDevBank);
    }

    @Override
    public List<OperationByDeveloperDto> listOperationByDeveloper(String idEquipDevBank) {
        List<DeveloperBankOperation> developerBankOperations = developerBankOperationRepository.findByEquipeDevBankId(idEquipDevBank);
        List<OperationByDeveloperDto> operationByDeveloperDtos = developerBankOperations
                .stream().map(operation -> dtoDeveloperMapper.fromEntityDeveloperBankOperation(operation))
                .collect(Collectors.toList());
        //   return developerBankOperations
        //                .stream().map(operation-> dtoDeveloperMapper.fromEntityDeveloperBankOperation(operation))
        //                .collect(Collectors.toList());
        return operationByDeveloperDtos;
    }

    @Override
    public EquipHistoryDto historyEquip(String idEquip, int page, int size) throws EquipeDevBankNotFoundException {
        EquipeDevBank equipDevBank = equipeDevBankRepository.findById(idEquip).orElse(null);
        if (equipDevBank == null)
            throw new EquipeDevBankNotFoundException("Equip Not Found");
        Page<DeveloperBankOperation> developerBankOperations = developerBankOperationRepository
                .findByEquipeDevBankId(idEquip, PageRequest.of(page, size));
        List<OperationByDeveloperDto> operationByDeveloperDtos = developerBankOperations.stream().map(operation -> dtoDeveloperMapper.fromEntityDeveloperBankOperation(operation)).collect(Collectors.toList());

        EquipHistoryDto equipHistoryDto = new EquipHistoryDto();
        equipHistoryDto.setIdEquip(idEquip);
        equipHistoryDto.setName(equipDevBank.getDeveloper().getName());
        equipHistoryDto.setSalaire(equipDevBank.getSalaire());
        equipHistoryDto.setCurrentPage(page);
        equipHistoryDto.setSizePage(size);
        equipHistoryDto.setTotalPage(developerBankOperations.getTotalPages());
        equipHistoryDto.setOperationByDeveloperDtoList(operationByDeveloperDtos);
        return equipHistoryDto;
    }


}
