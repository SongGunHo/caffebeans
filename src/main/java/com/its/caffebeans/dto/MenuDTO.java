package com.its.caffebeans.dto;

import com.its.caffebeans.entiry.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private Long id;
    private String caffe;
    private String goods;

    public MenuDTO(String caffe, String goods) {
        this.caffe = caffe;
        this.goods = goods;
    }

    public static MenuDTO toMenuTO(MenuEntity menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setCaffe(menu.getCaffe());
        menuDTO.setGoods(menu.getGoods());
        return menuDTO;
    }
}
