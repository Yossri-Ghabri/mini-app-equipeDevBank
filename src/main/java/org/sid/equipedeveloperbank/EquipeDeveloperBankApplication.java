package org.sid.equipedeveloperbank;

import org.sid.equipedeveloperbank.entities.*;
import org.sid.equipedeveloperbank.enums.AccountStatus;
import org.sid.equipedeveloperbank.enums.BadgeExtern;
import org.sid.equipedeveloperbank.enums.BadgeIntern;
import org.sid.equipedeveloperbank.enums.TypeOperation;
import org.sid.equipedeveloperbank.repositories.DeveloperBankOperationRepository;
import org.sid.equipedeveloperbank.repositories.DeveloperRepository;
import org.sid.equipedeveloperbank.repositories.EquipeDevBankRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EquipeDeveloperBankApplication {

    public static void main(String[] args) {

        SpringApplication.run(EquipeDeveloperBankApplication.class, args);
        System.out.println("Hello is new project");
    }

    @Bean
    CommandLineRunner addInBas(DeveloperRepository developerRepository,
                               EquipeDevBankRepository equipeDevBankRepository,
                               DeveloperBankOperationRepository developerBankOperationRepository){
        return args -> {
            Stream.of("alex","jhon","yossri").forEach(developerName->{
                Developer developer = new Developer();
                developer.setName(developerName);
                developer.setEmail(developerName+"@bankBnp.com");
                developerRepository.save(developer);
            });
            developerRepository.findAll().forEach(developer->{
                ExternDeveloper externDeveloper = new ExternDeveloper();
                externDeveloper.setDeveloper(developer);
                externDeveloper.setBadgeExtern(BadgeExtern.BADGE_EXTERN);
                externDeveloper.setCreateDate(new Date());
                externDeveloper.setSalaire(300.00);
                externDeveloper.setStatus(AccountStatus.CREATED);
                equipeDevBankRepository.save(externDeveloper);

                InternDeveloper internDeveloper = new InternDeveloper();
                internDeveloper.setDeveloper(developer);
                internDeveloper.setBadgeIntern(BadgeIntern.BADGE_INTERN);
                internDeveloper.setCreateDate(new Date());
                internDeveloper.setStatus(AccountStatus.CREATED);
                internDeveloper.setSalaire(500.00);
                equipeDevBankRepository.save(internDeveloper);
            });

            equipeDevBankRepository.findAll().forEach(equipe->{

                for(int i=0; i<10;i++){
                    DeveloperBankOperation developerBankOperation = new DeveloperBankOperation();
                    developerBankOperation.setAmount(100.0);
                    developerBankOperation.setDescription("Senior");
                    developerBankOperation.setOperationDate(new Date());
                    developerBankOperation.setTypeOperation(developerBankOperation.getAmount()>=100.0?TypeOperation.PRIME:TypeOperation.CREDIT);
                    developerBankOperation.setEquipeDevBank(equipe);
                    developerBankOperationRepository.save(developerBankOperation);
                }
            });

            EquipeDevBank equipeDevBank = equipeDevBankRepository.findById(1L).orElse(null);
            assert equipeDevBank != null;
            System.out.println("Client banque => "+equipeDevBank.getDeveloper().getName());
            if(equipeDevBank instanceof ExternDeveloper ){
                System.out.println("get Badge developer  extern => "+((ExternDeveloper) equipeDevBank).getBadgeExtern());
            }else if (equipeDevBank instanceof InternDeveloper){
                System.out.println("get badge developer intern => "+((InternDeveloper)equipeDevBank).getBadgeIntern());
            }

        };
    }

}
