package com.its.caffebeans.entiry;

import com.its.caffebeans.dto.CoffeeDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "coffee_3")
public class CoffeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coffee_id")
    private Long coffeeId;
    @Column
    private int coffeePrice;
    @Column
    private String coffeeBenefits;
    @Column
    private String coffeeCompany;
    @Column
    private String coffeeVolume;
    @Column
    private String coffeeFileName;
    @Column
    private String coffeeOption;

    public static CoffeeEntity toSaveEntity(CoffeeDTO coffeeDTO) {
        CoffeeEntity coffee = new CoffeeEntity();
        coffee.setCoffeePrice(coffeeDTO.getCoffeePrice());
        coffee.setCoffeeBenefits(coffeeDTO.getCoffeeBenefits());
        coffee.setCoffeeCompany(coffeeDTO.getCoffeeCompany());
        coffee.setCoffeeVolume(coffeeDTO.getCoffeeVolume());
        coffee.setCoffeeFileName(coffeeDTO.getCoffeeFileName());
        coffee.setCoffeeOption(coffeeDTO.getCoffeeOption());
        return coffee;
    }

    public static CoffeeEntity toUpdate(CoffeeDTO coffeeDTO) {
        CoffeeEntity coffee = new CoffeeEntity();
        coffee.setCoffeeId(coffeeDTO.getId());
        coffee.setCoffeePrice(coffeeDTO.getCoffeePrice());
        coffee.setCoffeeCompany(coffeeDTO.getCoffeeCompany());
        coffee.setCoffeeVolume(coffeeDTO.getCoffeeVolume());
        coffee.setCoffeeFileName(coffeeDTO.getCoffeeFileName());
        coffee.setCoffeeOption(coffeeDTO.getCoffeeOption());
        return coffee;

    }
}
