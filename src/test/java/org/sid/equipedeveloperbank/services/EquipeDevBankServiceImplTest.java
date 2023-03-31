package org.sid.equipedeveloperbank.services;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.sid.equipedeveloperbank.EquipeDeveloperBankApplication;
import org.sid.equipedeveloperbank.dtos.DeveloperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.SystemPropertyUtils;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EquipeDeveloperBankApplication.class)
public class EquipeDevBankServiceImplTest {

    @Autowired
    private EquipeDevBankServiceImpl  equipeDevBankService ;
    @Test
    public void DeveloperDtoNotNull(){
        System.out.println("test 1");
        DeveloperDto newObject= DeveloperDto.builder().email("@gmail.com").name("gmail").build();
        DeveloperDto saving = equipeDevBankService.saveDeveloper(newObject);
        Assertions.assertNotNull(saving, "not null");
        Assertions.assertEquals(newObject.getName(), saving.getName());
    }


    @Test
    public void listDeveloperNotNull(){

        System.out.println("test2 List developerDto");
        DeveloperDto developerDto2 = DeveloperDto.builder().name("list2").email("@List2").build();
        DeveloperDto newObject2 = DeveloperDto.builder().name("Lis3").email("@Lis3").build();
        equipeDevBankService.saveDeveloper(developerDto2);
        equipeDevBankService.saveDeveloper(newObject2);

        List<DeveloperDto>  developerDtoList = equipeDevBankService.listDeveloperDto();
        developerDtoList.forEach(name->{
            System.out.println("name List developerDto  "+ name.getName());
        });
        Assertions.assertNotNull(developerDtoList);
    }

}