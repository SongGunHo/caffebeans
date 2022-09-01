package com.its.caffebeans.repository;

import com.its.caffebeans.entiry.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity,Long> {
}
