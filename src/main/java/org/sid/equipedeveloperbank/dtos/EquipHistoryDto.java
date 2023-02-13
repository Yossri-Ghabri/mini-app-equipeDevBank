package org.sid.equipedeveloperbank.dtos;

import lombok.Data;

import java.util.List;

@Data
public class EquipHistoryDto {
    private String idEquip;
    private String name;
    private Double Salaire;
    private int currentPage;
    private int totalPage;
    private int sizePage;
    List<OperationByDeveloperDto> operationByDeveloperDtoList;
}
