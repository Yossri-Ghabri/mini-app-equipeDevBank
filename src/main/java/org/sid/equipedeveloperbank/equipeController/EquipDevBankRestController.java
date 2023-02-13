package org.sid.equipedeveloperbank.equipeController;


import lombok.AllArgsConstructor;
import org.sid.equipedeveloperbank.dtos.EquipHistoryDto;
import org.sid.equipedeveloperbank.dtos.EquipeDevBankDto;
import org.sid.equipedeveloperbank.dtos.OperationByDeveloperDto;
import org.sid.equipedeveloperbank.exceptions.EquipeDevBankNotFoundException;
import org.sid.equipedeveloperbank.services.EquipeDevBankService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getHistoryOperation/{id}")
    public EquipHistoryDto getHistoryOperation(@PathVariable String id,
                                               @RequestParam(name="page", defaultValue = "0") int page,
                                               @RequestParam(name = "size", defaultValue = "5") int size) throws EquipeDevBankNotFoundException {
        return equipeDevBankService.historyEquip(id, page, size);
    }
}
