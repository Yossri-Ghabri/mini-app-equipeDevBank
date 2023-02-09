package org.sid.equipedeveloperbank.equipeController;


import lombok.AllArgsConstructor;
import org.sid.equipedeveloperbank.dtos.DeveloperDto;
import org.sid.equipedeveloperbank.entities.Developer;
import org.sid.equipedeveloperbank.exceptions.DeveloperNotFoundException;
import org.sid.equipedeveloperbank.services.EquipeDevBankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/developer")
public class DeveloperRestController {
    private EquipeDevBankService equipeDevBankService;

    @GetMapping("/getDeveloper/{id}")
    public DeveloperDto getDeveloper(@PathVariable  Long id) throws DeveloperNotFoundException {
        return equipeDevBankService.getDeveloper(id);
    }

    @GetMapping("/listDeveloper")
    public List<DeveloperDto> listDeveloper(){
        return equipeDevBankService.listDeveloperDto();
    }

    @PostMapping("/saveDeveloper")
    public DeveloperDto saveDeveloper(@RequestBody DeveloperDto developerDto){
        return equipeDevBankService.saveDeveloper(developerDto);
    }


    @PutMapping("/updateDeveloper/{id}")
    public DeveloperDto updateDeveloper(@PathVariable Long id, @RequestBody DeveloperDto developerDto){
        developerDto.setId(id);
        return equipeDevBankService.updateDeveloper(developerDto);
    }



    @DeleteMapping("/deleteDeveloper/{id}")
    public void deleteDeveloper(@PathVariable Long id){
        equipeDevBankService.deleteDeveloper(id);
    }



}
