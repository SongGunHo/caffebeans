package com.its.caffebeans.entiry;

import com.its.caffebeans.dto.MenuDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "menu_1")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @Column
    private String caffe;
    @Column
    private String goods;

    public static MenuEntity toSaveEntity(MenuDTO menuDTO) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setCaffe(menuDTO.getCaffe());
        menuEntity.setGoods(menuDTO.getGoods());
        return menuEntity;
    }

    public static MenuEntity toUpdate(MenuDTO menuDTO) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setMenuId(menuDTO.getId());
        menuEntity.setCaffe(menuDTO.getCaffe());
        menuEntity.setGoods(menuDTO.getGoods());
        return menuEntity;
    }
}
