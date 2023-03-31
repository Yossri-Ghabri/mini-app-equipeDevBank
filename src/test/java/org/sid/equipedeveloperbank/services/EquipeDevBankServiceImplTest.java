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

}