package org.sid.equipedeveloperbank.mappers;

import org.sid.equipedeveloperbank.dtos.DeveloperDto;
import org.sid.equipedeveloperbank.entities.Developer;
import org.springframework.beans.BeanUtils;

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
}
