package com.its.caffebeans.repository;

import com.its.caffebeans.entiry.CoffeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<CoffeeEntity,Long> {
//    void update(CaffeEntity toUpdateEntity);
}
