package org.sid.equipedeveloperbank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.equipedeveloperbank.enums.BadgeIntern;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("Inter")
public class InternDeveloper extends EquipeDevBank{
    @Enumerated(EnumType.STRING)
    private BadgeIntern badgeIntern;
}
