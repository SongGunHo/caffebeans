package com.its.caffebeans.dto;

import com.its.caffebeans.entiry.CoffeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeDTO {
    private Long id;
    private int coffeePrice;
    private String coffeeBenefits;
    private String coffeeCompany;
    private String coffeeVolume;
    private LocalDateTime createdTime;
    private LocalDateTime updateDateTime;
    private MultipartFile coffeeFile;
    private String coffeeFileName;
    private String coffeeOption;

    public CoffeeDTO(int coffeePrice, String coffeeBenefits, String coffeeCompany, String coffeeVolume, LocalDateTime createdTime, LocalDateTime updateDateTime, MultipartFile coffeeFile, String coffeeFileName, String coffeeOption) {
        this.coffeePrice = coffeePrice;
        this.coffeeBenefits = coffeeBenefits;
        this.coffeeCompany = coffeeCompany;
        this.coffeeVolume = coffeeVolume;
        this.createdTime = createdTime;
        this.updateDateTime = updateDateTime;
        this.coffeeFile = coffeeFile;
        this.coffeeFileName = coffeeFileName;
        this.coffeeOption = coffeeOption;
    }

    public static CoffeeDTO toCoffeeDTO(CoffeeEntity coffee) {
        CoffeeDTO coffeeDTO = new CoffeeDTO();
        coffeeDTO.setId(coffee.getCoffeeId());
        coffeeDTO.setCoffeePrice(coffee.getCoffeePrice());
        coffeeDTO.setCoffeeBenefits(coffee.getCoffeeBenefits());
        coffeeDTO.setCoffeeCompany(coffee.getCoffeeCompany());
        coffeeDTO.setCoffeeVolume(coffee.getCoffeeVolume());
        coffeeDTO.setCoffeeFileName(coffee.getCoffeeFileName());
        coffeeDTO.setCoffeeOption(coffee.getCoffeeOption());
        return coffeeDTO;
    }
}
