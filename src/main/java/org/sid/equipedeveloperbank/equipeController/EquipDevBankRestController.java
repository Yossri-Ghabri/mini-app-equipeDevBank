package org.sid.equipedeveloperbank.equipeController;


import lombok.AllArgsConstructor;
import org.sid.equipedeveloperbank.dtos.EquipeDevBankDto;
import org.sid.equipedeveloperbank.dtos.OperationByDeveloperDto;
import org.sid.equipedeveloperbank.exceptions.EquipeDevBankNotFoundException;
import org.sid.equipedeveloperbank.services.EquipeDevBankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equip")
@AllArgsConstructor
public class EquipDevBankRestController {
    private EquipeDevBankService equipeDevBankService;

    @GetMapping("/getEquipDevBank/{id}")
    public EquipeDevBankDto getEquipDevBank(@PathVariable String id) throws EquipeDevBankNotFoundException {
       return equipeDevBankService.getEquipeDevBankDto(id);
    }

    @GetMapping("/listEquipDevBank")
    public List<EquipeDevBankDto> listEquipDevBank(){
        return equipeDevBankService.listEquipeDevBank();
    }

    @GetMapping("/getOperationByDeveloper/{idEquipBank}")
    public List<OperationByDeveloperDto> getOperationByDeveloper(@PathVariable String idEquipBank){
        return equipeDevBankService.listOperationByDeveloper(idEquipBank);
    }

}
