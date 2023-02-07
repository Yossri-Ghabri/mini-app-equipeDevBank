package org.sid.equipedeveloperbank.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.equipedeveloperbank.enums.BadgeExtern;

@Entity
@DiscriminatorValue("Exter")
@Data
@AllArgsConstructor @NoArgsConstructor
public class ExternDeveloper extends EquipeDevBank {
    @Enumerated(EnumType.STRING)
    private BadgeExtern badgeExtern;
}
