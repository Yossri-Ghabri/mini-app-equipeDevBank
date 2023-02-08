package org.sid.equipedeveloperbank.mappers;

import org.sid.equipedeveloperbank.dtos.DeveloperDto;
import org.sid.equipedeveloperbank.dtos.EquipedevBankExternDto;
import org.sid.equipedeveloperbank.dtos.EquipedevBankInternDto;
import org.sid.equipedeveloperbank.dtos.OperationByDeveloperDto;
import org.sid.equipedeveloperbank.entities.Developer;
import org.sid.equipedeveloperbank.entities.DeveloperBankOperation;
import org.sid.equipedeveloperbank.entities.ExternDeveloper;
import org.sid.equipedeveloperbank.entities.InternDeveloper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service

public class EquipeDeveloperMapperImp {

    public DeveloperDto fromEntityDeveloper(Developer developer){
        DeveloperDto developerDto = new DeveloperDto();
        BeanUtils.copyProperties(developer, developerDto);
        return developerDto;
    }


    public Developer fromDeveloperDto(DeveloperDto developerDto){
        Developer developer = new Developer();
        BeanUtils.copyProperties(developerDto, developer);
        return developer;
    }


    public EquipedevBankExternDto fromEntityExternDeveloper(ExternDeveloper externDeveloper ){
        EquipedevBankExternDto equipedevBankExternDto = new EquipedevBankExternDto();
        BeanUtils.copyProperties(externDeveloper, equipedevBankExternDto);
        equipedevBankExternDto.setDeveloperDto(fromEntityDeveloper(externDeveloper.getDeveloper()));
        equipedevBankExternDto.setType(externDeveloper.getClass().getSimpleName());
        return equipedevBankExternDto;
    }


    public ExternDeveloper fromEquipDevBankExternDto(EquipedevBankExternDto equipedevBankExternDto ){
        ExternDeveloper externDeveloper = new ExternDeveloper();
        BeanUtils.copyProperties(equipedevBankExternDto, externDeveloper);
        externDeveloper.setDeveloper(fromDeveloperDto(equipedevBankExternDto.getDeveloperDto()));
        return externDeveloper;
    }


    public EquipedevBankInternDto fromEntityInternDeveloper(InternDeveloper internDeveloper ){
        EquipedevBankInternDto equipedevBankInternDto = new EquipedevBankInternDto();
        BeanUtils.copyProperties(internDeveloper, equipedevBankInternDto);
        equipedevBankInternDto.setDeveloperDto(fromEntityDeveloper(internDeveloper.getDeveloper()));
        equipedevBankInternDto.setType(internDeveloper.getClass().getSimpleName());
        return equipedevBankInternDto;
    }


    public InternDeveloper fromEquipDevInternDto(EquipedevBankInternDto equipedevBankInternDto){
        InternDeveloper internDeveloper = new InternDeveloper();
        BeanUtils.copyProperties(equipedevBankInternDto, internDeveloper);
        internDeveloper.setDeveloper(fromDeveloperDto(equipedevBankInternDto.getDeveloperDto()));
        return internDeveloper;
    }


    public OperationByDeveloperDto fromEntityDeveloperBankOperation(DeveloperBankOperation developerBankOperation){
        OperationByDeveloperDto operationByDeveloperDto = new OperationByDeveloperDto();
        BeanUtils.copyProperties(developerBankOperation, operationByDeveloperDto);
        return operationByDeveloperDto;
    }
}
